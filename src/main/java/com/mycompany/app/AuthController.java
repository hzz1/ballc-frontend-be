package com.mycompany.app;

import com.fasterxml.jackson.annotation.JacksonInject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;
import java.security.NoSuchAlgorithmException;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {

    @JacksonInject
    RestTemplate restTemplate = new RestTemplate();
    SendData sendData = new SendData();
    MyCookieStore myStore = new MyCookieStore();
    HttpCookie myCookie = new HttpCookie("name", null);
    String username = null;
    JSONArray json = new JSONArray();


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public RedirectView login(@RequestBody String user , Model model, HttpSession httpSession) throws ParseException, NoSuchAlgorithmException {

        httpSession.setAttribute("username", null);
        httpSession.setAttribute("admin", false);

        System.out.println(user);

        JSONParser parser = new JSONParser();
        JSONObject jsonObj = (JSONObject) parser.parse(user);
        username = (String) jsonObj.get("username");
        String password = (String) jsonObj.get("password");
        System.out.println(username);

        String generatedPassord = sendData.hashPassword(password);
        jsonObj.replace("password", password, generatedPassord);


        if(sendData.auth(username, generatedPassord) == false){
            System.out.println(sendData.auth(username, generatedPassord));
            System.out.println("User do not exist");

        }else{

            System.out.println(myCookie.getValue());
            httpSession.setAttribute("username", username);
            System.out.println("welcome back    " + username);

        }

        model.addAttribute("username", username);
        return new RedirectView("/checkadmin");
    }


    @CrossOrigin(value = "*")
    @RequestMapping(value = "/checkadmin", method = RequestMethod.GET)
    public String getAdmin(HttpSession httpSession) throws ParseException {

        System.out.println("this from checkadmin");
        String myJsonObj = null;
        final String uri = "http://ballc-frontend-usersapi.herokuapp.com/users";
        String result = restTemplate.getForObject(uri, String.class);

        JSONParser parser = new JSONParser();
        json = (JSONArray) parser.parse(result);

        for(Object myjson : json){

            JSONObject myJson = (JSONObject) parser.parse(myjson.toString());
            Boolean admin = Boolean.valueOf(myJson.get("admin").toString());

            if (myJson.get("username").toString().equals(username)){
                System.out.println(myJson.toString());
                if (admin){


                    System.out.println("he is an admin");
                }else{
                    System.out.println("he is not an admin");
                }
                myJsonObj = myJson.toString();
                System.out.println(myJsonObj);

            }

        }
        System.out.println(myJsonObj);

        return myJsonObj;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/coo")
    public String showMyCookie(HttpSession httpSession) throws ParseException {

        try{
            Object value = httpSession.getValue("username");
            System.out.println(value.toString());
            //String myCookie = myStore.sendingCookies();
            return value.toString();

        }catch(NullPointerException e){
            return "no session found please login";
        }

    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/logout")
    public String logout(HttpSession httpSession) throws ParseException {

        Object value = httpSession.getValue("username");
        //String myCookie = myStore.sendingCookies();
        httpSession.setAttribute("username", null);

        return "logout is done";
    }


}
