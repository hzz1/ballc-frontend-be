package com.mycompany.app;

import com.fasterxml.jackson.annotation.JacksonInject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

//import io.jsonwebtoken.Jwts;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {

    @JacksonInject
    RestTemplate restTemplate = new RestTemplate();
    SendData sendData = new SendData();
    MyCookieStore myStore = new MyCookieStore();
    String username = null;
    JSONArray json = new JSONArray();


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody String user) throws ParseException, NoSuchAlgorithmException {

        username = null;

        JSONParser parser = new JSONParser();
        JSONObject jsonObj = (JSONObject) parser.parse(user);
        String name = (String) jsonObj.get("username");
        String password = (String) jsonObj.get("password");
        String generatedPassord = sendData.hashPassword(password);
        jsonObj.replace("password", password, generatedPassord);
        JSONObject tokenObj = new JSONObject();

        tokenObj.put("token", "");



        if(sendData.auth(name, generatedPassord) == false){
            System.out.println(sendData.auth(name, generatedPassord));
            System.out.println("User do not exist");

        }else{

            String url = "http://ballc-frontend-usersapi.herokuapp.com/users/" + name;

            String result = restTemplate.getForObject(url, String.class);

            JSONObject usernObj = (JSONObject) parser.parse(result);
            String name1 = usernObj.get("username").toString();
            Boolean admin = Boolean.valueOf(usernObj.get("admin").toString());

            tokenObj.put("username", name1);
            tokenObj.put("admin", admin);
            tokenObj.replace("token", "", "myToken");
            //getAdmin();
            System.out.println(tokenObj.toString());


        }

        //String url = "/checkadmin/" + username;

        return tokenObj.toString();

    }


    @CrossOrigin(value = "*")
    @GetMapping("/check")
    public String getAdmin(HttpSession mySession) throws ParseException {

        //System.out.println("from admin check");
        JSONObject tokenObj = new JSONObject();

        String response = "nothing";

        if (username != null){
            String url = "http://ballc-frontend-usersapi.herokuapp.com/users/";

            String result = restTemplate.getForObject(url, String.class);

            JSONParser parser = new JSONParser();
            JSONObject jsonObj = (JSONObject) parser.parse(result);
            response = jsonObj.toString();
            System.out.println(response);
            String name = jsonObj.get("username").toString();
            Boolean admin = Boolean.valueOf(jsonObj.get("admin").toString());

            tokenObj.put("username", name);
            tokenObj.put("admin", admin);
            tokenObj.replace("token", "", "myToken");


        }

        System.out.println(tokenObj.toString());

        return tokenObj.toString();
    }


}
