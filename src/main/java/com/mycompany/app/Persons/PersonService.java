package com.mycompany.app.Persons;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

public class PersonService {

    RestTemplate restTemplate = new RestTemplate();

    @CrossOrigin(origins = "*")
    public int RegAddress(String url, String user){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(user, headers);
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://ballc-backend-api.herokuapp.com"));
        return restTemplate.exchange(url, HttpMethod.POST , entity, int.class).getBody();
    }

    @CrossOrigin(origins = "*")
    public String RegPerson(String url, String user){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(user, headers);
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://ballc-backend-api.herokuapp.com"));
        return restTemplate.exchange(url, HttpMethod.POST , entity, String.class).getBody();
    }

    @CrossOrigin(origins = "*")
    public String UpdatePerson(String url, String user){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(user, headers);
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://ballc-backend-api.herokuapp.com"));
        return restTemplate.exchange(url, HttpMethod.PUT , entity, String.class).getBody();
    }

    @CrossOrigin("*")
    public String getInfo(String url){
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://ballc-backend-api.herokuapp.com"));
        return restTemplate.getForObject(url, String.class);
    }

    @CrossOrigin("*")
    public String updateInfo(String url, String user){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(user, headers);
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://ballc-backend-api.herokuapp.com"));
        return restTemplate.exchange(url, HttpMethod.PUT , entity, String.class).getBody();
    }

    @CrossOrigin("*")
    public String deleteInfo(String url){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://ballc-backend-api.herokuapp.com"));
        return restTemplate.exchange(url, HttpMethod.DELETE , entity, String.class).getBody();
    }


    @CrossOrigin("*")
    public int findID(String url, String identifire, String endPoint , String userVal) throws ParseException {
        int id = 0;
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://ballc-backend-api.herokuapp.com"));
        String info = restTemplate.getForObject(url, String.class);


        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(info);
        System.out.println(json.toString());

        for (Object obj : json){
            JSONObject jsonObj = (JSONObject) parser.parse(obj.toString());

            if (jsonObj.get(identifire).equals(userVal)){

                id = Integer.parseInt(jsonObj.get(endPoint).toString());

            }

        }

        return id;

    }

    @CrossOrigin("*")
    public int findPerson(String url, String identifire, String endpoint ,int userVal) throws ParseException {
        int id = 0;
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://ballc-backend-api.herokuapp.com"));
        String info = restTemplate.getForObject(url, String.class);


        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(info);
        //System.out.println(json.toString());

        for (Object obj : json){
            JSONObject jsonObj = (JSONObject) parser.parse(obj.toString());

            int person_id = Integer.parseInt(jsonObj.get(identifire).toString());
            if (person_id == userVal){
                //System.out.println("Hello Bitch");
                id = Integer.parseInt(jsonObj.get(endpoint).toString());
                //System.out.println(jsonObj.toString());
            }


        }

        return id;

    }

    @CrossOrigin("*")
    public int findPersonBy(String url,String userVal) throws ParseException {
        int id = 0;
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://ballc-backend-api.herokuapp.com"));
        String info = restTemplate.getForObject(url, String.class);


        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(info);
        //System.out.println(json.toString());

        for (Object obj : json){
            JSONObject jsonObj = (JSONObject) parser.parse(obj.toString());

            if (jsonObj.get("first_name").equals(userVal)){

                id = Integer.parseInt(jsonObj.get("person_id").toString());
                //System.out.println(id);

            }

        }

        return id;

    }

    public String findPlayers(String url) throws ParseException {

        String object = null;

        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://ballc-backend-api.herokuapp.com"));
        String info = restTemplate.getForObject(url, String.class);

        System.out.println(info);
        //System.out.println(json.toString());
        //System.out.println(json.get("first_name").toString());
        /*
        try{
            restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://ballc-backend-api.herokuapp.com"));
            String info = restTemplate.getForObject(url, String.class);

            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(info);
            String fullName = json.get("first_name").toString() + " " + json.get("last_name").toString();
            String person_id = json.get("person_id").toString();

            JSONObject player = new JSONObject();
            player.put("label", fullName);
            player.put("value", person_id);

            object = player.toString();
            System.out.println(player.toString());
        }catch (HttpServerErrorException e){
            System.out.println("finished");
        }
*/
        return info;
    }

    public String findGoalType(String url) throws ParseException {

        String object = null;

        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://ballc-backend-api.herokuapp.com"));
        String info = restTemplate.getForObject(url, String.class);

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(info);
        //System.out.println(json.toString());

        String goal_type = json.get("type").toString();
        String goal_type_id = json.get("goal_type_id").toString();
        JSONObject player = new JSONObject();
        player.put("label", goal_type);
        player.put("value", goal_type_id);

        System.out.println(player.toString());
        //object = player.toString();


        return object;
    }

    public Boolean checkAddress(String addressID) throws ParseException {

        final String uri = "http://ballc-backend-api.herokuapp.com/addresses";
        String result = restTemplate.getForObject(uri, String.class);

        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(result);

        for(Object myjson : json){

            JSONObject myJson = (JSONObject) parser.parse(myjson.toString());
            String address_id = myJson.get("address_line_1").toString();
            if (addressID.equals(address_id)){
                return true;
            }
        }
        return false;
    }


}
