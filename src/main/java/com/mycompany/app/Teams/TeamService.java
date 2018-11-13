package com.mycompany.app.Teams;


import com.fasterxml.jackson.annotation.JacksonInject;
import com.mycompany.app.Persons.PersonService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@RestController
@CrossOrigin(origins = "*")
public class TeamService {

    @JacksonInject
    RestTemplate restTemplate = new RestTemplate();


    @CrossOrigin("*")
    public String getInfo(String url){
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://ballc-backend-api.herokuapp.com"));
        return restTemplate.getForObject(url, String.class);
    }

    @CrossOrigin("*")
    public int getPlayer(String url, int id) throws ParseException {
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://ballc-backend-api.herokuapp.com"));
        String data = restTemplate.getForObject(url, String.class);
        JSONParser parser = new JSONParser();
        JSONArray players = (JSONArray) parser.parse(data);

        int playerID = 0;

        for (Object obj : players){
            JSONObject json = (JSONObject) parser.parse(obj.toString());
            int personID = Integer.parseInt(json.get("person").toString());
            if (personID == id){

                playerID = Integer.parseInt(json.get("player_id").toString());

            }
        }
        return playerID;
    }

    @CrossOrigin("*")
    public String getMatchInfo(){
        return restTemplate.getForObject("http://ballc-backend-api.herokuapp.com/matches", String.class);
    }

    @CrossOrigin(value = "*")
    public String getResultHome(int id) throws ParseException {
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://ballc-backend-api.herokuapp.com"));
        String results = restTemplate.getForObject("/results", String.class);

        JSONParser parser = new JSONParser();
        JSONArray matches = (JSONArray) parser.parse(results);


        for (Object obj : matches){
            JSONObject match = (JSONObject) parser.parse(obj.toString());

            int match_id = Integer.parseInt(match.get("match_id").toString());
            if (match_id == id){

            }
        }

        return "jj";
    }



    @CrossOrigin("*")
    public String getPositionsInfo(){
        return restTemplate.getForObject("http://localhost:3000/", String.class);
    }

    @CrossOrigin(origins = "*")
    public String RegTeam(String url, String user){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(user, headers);
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://ballc-backend-api.herokuapp.com"));
        return restTemplate.exchange(url, HttpMethod.POST , entity, String.class).getBody();
    }

    @CrossOrigin(origins = "*")
    public String DelTeam(String url){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://ballc-backend-api.herokuapp.com"));
        return restTemplate.exchange(url, HttpMethod.DELETE , entity, String.class).getBody();
    }

    @CrossOrigin(origins = "*")
    public String UpTeam(String url, String user){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(user, headers);
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://ballc-backend-api.herokuapp.com"));
        return restTemplate.exchange(url, HttpMethod.PUT , entity, String.class).getBody();
    }




}
