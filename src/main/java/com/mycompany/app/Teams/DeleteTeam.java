package com.mycompany.app.Teams;

import com.fasterxml.jackson.annotation.JacksonInject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@CrossOrigin(origins = "*")
public class DeleteTeam {

    @JacksonInject
    RestTemplate restTemplate = new RestTemplate();
    TeamService sendData = new TeamService();

    @CrossOrigin(value = "*")
    @GetMapping("/delteam/{id}")
    public String getTeam(@PathVariable("id") String id) throws ParseException {

        //System.out.println(id);


        String url = "/teams/" + id;
        String result = sendData.DelTeam(url);
        return result;
    }

    @CrossOrigin(value = "*")
    @GetMapping("/delcoach/{id}")
    public String getcouch(@PathVariable("id") String id) throws ParseException {

        //System.out.println(id);


        String url = "/coaches/" + id;
        String result = sendData.DelTeam(url);
        return result;
    }


    @CrossOrigin(value = "*")
    @GetMapping("/delmatch/{id}")
    public String getMatche(@PathVariable("id") String id) throws ParseException {

        //System.out.println(id);


        String url = "/matches/" + id;
        String result = sendData.DelTeam(url);
        return result;
    }

    @CrossOrigin(value = "*")
    @GetMapping("/delowner/{id}")
    public String getOwner(@PathVariable("id") String id) throws ParseException {

        //System.out.println(id);


        String url = "/owners/" + id;
        String result = sendData.DelTeam(url);
        return result;
    }

    @CrossOrigin(value = "*")
    @GetMapping("/dellocation/{id}")
    public String getlocation(@PathVariable("id") String id) throws ParseException {

        //System.out.println(id);


        String url = "/locations/" + id;
        String result = sendData.DelTeam(url);
        return result;
    }

    @CrossOrigin(value = "*")
    @GetMapping("/delassociation/{id}")
    public String getassociation(@PathVariable("id") String id) throws ParseException {

        //System.out.println(id);


        String url = "/associations/" + id;
        String result = sendData.DelTeam(url);
        return result;
    }

    @CrossOrigin(value = "*")
    @GetMapping("/delmatchgoal/{id}")
    public String getmatchgoal(@PathVariable("id") String id) throws ParseException {

        //System.out.println(id);


        String url = "/matchgoals/" + id;
        String result = sendData.DelTeam(url);
        return result;
    }

    @CrossOrigin(value = "*")
    @GetMapping("/delseason/{id}")
    public String getseason(@PathVariable("id") String id) throws ParseException {

        //System.out.println(id);


        String url = "/seasons/" + id;
        String result = sendData.DelTeam(url);
        return result;
    }

    @CrossOrigin(value = "*")
    @GetMapping("/delgoaltype/{id}")
    public String getgoaltype(@PathVariable("id") String id) throws ParseException {

        //System.out.println(id);


        String url = "/goaltypes/" + id;
        String result = sendData.DelTeam(url);
        return result;
    }

}
