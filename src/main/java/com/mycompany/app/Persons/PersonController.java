package com.mycompany.app.Persons;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.mycompany.app.MyCookieStore;
import com.mycompany.app.SendData;
import com.mycompany.app.Users.Users;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpCookie;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


@RestController
@CrossOrigin(origins = "*")
public class PersonController {

    ArrayList<Persons> persons = new ArrayList<>();

    int addressID;

    @JacksonInject
    RestTemplate restTemplate = new RestTemplate();
    PersonService sendData = new PersonService();
    MyCookieStore myStore = new MyCookieStore();


/*

    public PersonController() throws ParseException {


    }
    */

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/regperson", method = RequestMethod.POST)
    public String createPerson(@RequestBody String user) throws IOException, ParseException {

        int addressID = 0;
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(user);


        String address1 = (String) json.get("address_1");
        String address2 = (String) json.get("address_2");
        String address3 = (String) json.get("address_3");
        String psCode = (String) json.get("postal_code");
        String city = (String) json.get("city");
        String country = (String) json.get("country");

        JSONObject addresses = new JSONObject();

        addresses.put("address_line_1", address1);
        addresses.put("address_line_2", address2);
        addresses.put("address_line_3", address3);
        addresses.put("city", city);
        addresses.put("country", country);
        addresses.put("postal_code", psCode);

        if (sendData.checkAddress(address1)){

            addressID = sendData.findID("/addresses", "address_line_1", "address_id" ,  address1);
            System.out.println("its exist fuck off");
        }else{
            addressID = sendData.RegAddress("/addresses", addresses.toString());
            System.out.println(addressID);
        }


        String firstname = (String) json.get("firstname");
        String lastname = (String) json.get("lastname");
        String dob = (String) json.get("dob");



        JSONObject personalInfo = new JSONObject();
        personalInfo.put("first_name", firstname);
        personalInfo.put("last_name", lastname);
        personalInfo.put("date_of_birth", dob);

        personalInfo.put("address", addressID);

        String newPerson = sendData.RegPerson("/persons", personalInfo.toString());
        System.out.println(personalInfo.toString());
        System.out.println(newPerson);

        JSONObject json2 = (JSONObject) parser.parse(newPerson);
        String personID = json2.get("person_id").toString();

        String phonenumber = (String) json.get("phonenumber");
        String email = (String) json.get("email");

        JSONObject emails = new JSONObject();
        emails.put("contact_type", "Email");
        emails.put("person", personID);
        emails.put("contact_detail", email);
        System.out.println(emails.toString());
        String newEmail = sendData.RegPerson("/contacts", emails.toString());
        System.out.println(newEmail);
        JSONObject phone = new JSONObject();
        phone.put("contact_type", "Phonenumber");
        phone.put("person", personID);
        phone.put("contact_detail", phonenumber);
        String newphonenumber = sendData.RegPerson("/contacts", phone.toString());
        System.out.println(newphonenumber);


        System.out.println(user);

        return "user";
    }


    @CrossOrigin(value = "*")
    @GetMapping("/persons")
    public String getPersons() throws ParseException {

        String result = sendData.getInfo("/persons");
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(result);

        for (Object obj : json){
            JSONObject jsonObj = (JSONObject) parser.parse(obj.toString());
            //System.out.println(jsonObj.toString());

        }

        return result;
    }

    @CrossOrigin(value = "*")
    @GetMapping("/person")
    public String getPerson() throws ParseException {

        int id = 1;
        int address_id = sendData.findPerson("/persons", "person_id", "address_id", id);
        //System.out.println(address_id);

        /*
        String url = "/persons/" + id;
        String result = sendData.getInfo(url);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(result);
        System.out.println(json.toString());
*/
        return "yes";
    }

    @CrossOrigin(value = "*")
    @GetMapping("/addresses")
    public String getAddresses() throws ParseException {

        String result = sendData.getInfo("/addresses");
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(result);

        for (Object obj : json){
            JSONObject jsonObj = (JSONObject) parser.parse(obj.toString());
            //System.out.println(jsonObj.toString());
        }

        return result;
    }

    @CrossOrigin(value = "*")
    @GetMapping("/address/{id}")
    public String getAddress(@PathVariable("id") String id) throws ParseException {

        //System.out.println(id);


        String url = "/addresses/" + id;
        String result = sendData.getInfo(url);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(result);
        //System.out.println(json.toString());

        return json.toString();
    }

    @CrossOrigin(value = "*")
    @GetMapping("/contacts")
    public String getContacts() throws ParseException {

        String result = sendData.getInfo("/contacts");
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(result);

        for (Object obj : json){
            JSONObject jsonObj = (JSONObject) parser.parse(obj.toString());
            //System.out.println(jsonObj.toString());
        }

        return result;
    }

    @CrossOrigin(value = "*")
    @GetMapping("/contact/{id}")
    public String getContact(@PathVariable("id") String id) throws ParseException {

        String url = "/contacts/" + id;
        String result = sendData.getInfo(url);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(result);
        //System.out.println(json.toString());

        return result;
    }

    @CrossOrigin(value = "*")
    @GetMapping("/players")
    public String getPlayers() throws ParseException {

        String result = sendData.getInfo("/players");
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(result);

        for (Object obj : json){
            JSONObject jsonObj = (JSONObject) parser.parse(obj.toString());
            //System.out.println(jsonObj.toString());
        }

        return result;
    }

    @CrossOrigin(value = "*")
    @GetMapping("/player/{id}")
    public String getPlayer(@PathVariable("id") String id) throws ParseException {

        String url = "/players/" + id;
        String result = sendData.getInfo(url);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(result);
        System.out.println(json.toString());

        return result;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/updateperson", method = RequestMethod.POST)
    public String updatePerson(@RequestBody String user) throws ParseException {

        //System.out.println("this is from person");
        //System.out.println(user);

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(user);
        int id = Integer.parseInt(json.get("person_id").toString());
        json.remove("person_id");
        //System.out.println(json.toString());

        //System.out.println(id);
        String url = "/persons/" + id;
        sendData.updateInfo(url, json.toString());
        return user;

    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/updateaddress", method = RequestMethod.POST)
    public String updateaddress (@RequestBody String user) throws ParseException {
        //System.out.println("this is from address");
        //System.out.println(addressID);
        System.out.println(user);

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(user);

        int id = Integer.parseInt(json.get("address_id").toString());
        json.remove("address_id");

        System.out.println(json.toString());

        System.out.println(id);

        String url = "/addresses/" + id;
        sendData.updateInfo(url, json.toString());

        return user;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/updatecontact", method = RequestMethod.POST)
    public String updateContact (@RequestBody String user) throws ParseException {
        //System.out.println("this is from address");
        //System.out.println(addressID);
        System.out.println(user);

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(user);
        String id = json.get("contact_id").toString();
        System.out.println(id);
        json.remove("contact_id");
        System.out.println(json.toString());

        String url = "/contacts/" + id;
        sendData.updateInfo(url, json.toString());

        return user;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/addcontact", method = RequestMethod.POST)
    public String addContact(@RequestBody String user){

        System.out.println(user);
        String contact = sendData.RegPerson("/contacts", user);

        System.out.println(contact);
        return user;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/delcontact", method = RequestMethod.POST)
    public String delContact(@RequestBody String user) throws ParseException {

        System.out.println(user);

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(user);
        String id = json.get("contact_id").toString();
        System.out.println(id);

        String url = "/contacts/" + id;
        String contact = sendData.deleteInfo(url);

        System.out.println(contact);
        return user;
    }


    @CrossOrigin(value = "*")
    @RequestMapping(value = "/delperson", method = RequestMethod.POST)
    public String delPerson(@RequestBody String user) throws ParseException {

        System.out.println(user);

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(user);
        String personID = json.get("person_id").toString();
        System.out.println(personID);

        String addressID = json.get("address_id").toString();
        System.out.println(addressID);

        String url2 = "/persons/" + personID;
        String person = sendData.deleteInfo(url2);


        return user;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/addrole", method = RequestMethod.POST)
    public String addRole(@RequestBody String user) throws ParseException {

            System.out.println(user);

            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(user);

        System.out.println(json.get("coach").toString());



            //String coachcheck = json.get("coach").toString();
            //String owner = json.get("owner").toString();
            //Boolean player = Boolean.valueOf(json.get("player").toString());
            //System.out.println(coachcheck);
            int personID =Integer.parseInt(json.get("person_id").toString());
            //int teamnID =Integer.parseInt(json.get("team_id").toString());


            String url = "/persons/" + personID;
            JSONObject json2 = new JSONObject();
            json2.put("person", personID);
            json2.put("team", 1);

            //String person = sendData.getInfo(url);
            System.out.println(json2.toString());
            if (json.get("coach").toString().equals("true")){
                System.out.println("he is a couch");
                String url1 = "/coaches";
                String res = sendData.RegPerson(url1, json2.toString());
                System.out.println(res);
            }
            if (json.get("owner").toString().equals("true")){
                System.out.println("he is an owner");
                String url1 = "/owners";
                sendData.RegPerson(url1, json2.toString());
            }

            if (json.get("player").toString().equals("true")){
                System.out.println("he is a player");
                String url1 = "/players";
                json2.put("normal_position", json.get("selected").toString());
                json2.put("number", json.get("number").toString());
                json2.put("team", json.get("team").toString());
                System.out.println(json2.toString());
                sendData.RegPerson(url1, json2.toString());
            }

            return user;


    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/addaddress", method = RequestMethod.POST)
    public String addAddress(@RequestBody String user){

        System.out.println(user);

        sendData.RegPerson("/addresses", user);
        return user;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/addlocation", method = RequestMethod.POST)
    public String addLocation(@RequestBody String user){

        sendData.RegPerson("/locations", user);
        System.out.println(user);
        return user;
    }


    @CrossOrigin(value = "*")
    @RequestMapping(value = "/updatelocation", method = RequestMethod.POST)
    public String upLocation(@RequestBody String user) throws ParseException {

        System.out.println(user);

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(user);

        int id = Integer.parseInt(json.get("location_id").toString());
        System.out.println(id);

        json.remove("location_id");
        System.out.println(json.toString());

        String url = "/locations/" + id;
        sendData.updateInfo(url, json.toString());

        return user;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/addassociation", method = RequestMethod.POST)
    public String addAssociation(@RequestBody String user){

        sendData.RegPerson("/associations", user);
        System.out.println(user);
        return user;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/updateassociation", method = RequestMethod.POST)
    public String updateAssociation(@RequestBody String user) throws ParseException {

        System.out.println(user);

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(user);

        int id = Integer.parseInt(json.get("association_id").toString());
        System.out.println(id);

        json.remove("association_id");
        System.out.println(json.toString());

        String url = "/associations/" + id;
        sendData.updateInfo(url, json.toString());

        return user;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/delassociation", method = RequestMethod.POST)
    public String delAssociation(@RequestBody String user) throws ParseException {

        System.out.println(user);

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(user);
        String associationID = json.get("association_id").toString();
        System.out.println(associationID);


        String url = "/associations/" + associationID;
        sendData.deleteInfo(url);


        return user;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/dellocation", method = RequestMethod.POST)
    public String delLocation(@RequestBody String user) throws ParseException {

        System.out.println(user);

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(user);
        String locationID = json.get("location_id").toString();
        System.out.println(locationID);


        String url = "/locations/" + locationID;
        sendData.deleteInfo(url);


        return user;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/deladdress", method = RequestMethod.POST)
    public String delAddress(@RequestBody String user) throws ParseException {

        System.out.println(user);

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(user);
        String addressID = json.get("address_id").toString();
        System.out.println(addressID);


        String url = "/addresses/" + addressID;
        sendData.deleteInfo(url);


        return user;
    }

    @CrossOrigin(value = "*")
    @GetMapping("/goaltypeformatch")
    public String getGoalTypes() throws ParseException {


        String result = sendData.getInfo("/goaltypes");
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(result);

        JSONArray goalslist = new JSONArray();

        for (Object obj : json){
            JSONObject jsonObj = (JSONObject) parser.parse(obj.toString());
            int id = Integer.parseInt(jsonObj.get("goal_type_id").toString());

            String goal_type = jsonObj.get("type").toString();
            String goal_type_id = jsonObj.get("goal_type_id").toString();
            JSONObject goals = new JSONObject();
            goals.put("value", goal_type_id);
            goals.put("label", goal_type);
            System.out.println(goals.toString());
            goalslist.add(goals);
            //JSONObject jsonPlayers = (JSONObject) parser.parse(goal_types);

            //jsonPlayers.put("team", jsonObj.get("team").toString());
            //System.out.println(jsonPlayers.toString());
            //players.add(jsonPlayers);
            //System.out.println(jsonObj.toString());

        }

        System.out.println(goalslist.toString());


        return goalslist.toString();
    }


    @CrossOrigin(value = "*")
    @GetMapping("/playersformatch")
    public String getPlayersForMatch() throws ParseException {


        String result = sendData.getInfo("/playersinfo");
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(result);

        JSONArray playerslist = new JSONArray();

        for (Object obj : json){
            JSONObject jsonObj = (JSONObject) parser.parse(obj.toString());
            String fullName = jsonObj.get("first_name").toString() + " " + jsonObj.get("last_name").toString();
            int person_id = Integer.parseInt(jsonObj.get("person_id").toString());
            String team_id = jsonObj.get("team_id").toString();
            JSONObject player = new JSONObject();
            player.put("label", fullName);
            player.put("value", person_id);
            player.put("team", team_id);
            playerslist.add(player);
        }

        System.out.println(playerslist.toString());


        return playerslist.toString();
    }

    @CrossOrigin(value = "*")
    @GetMapping("/teamsformatch")
    public String getTeamsForMatch() throws ParseException {


        String result = sendData.getInfo("/teams");
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(result);

        JSONArray playerslist = new JSONArray();

        for (Object obj : json){
            JSONObject jsonObj = (JSONObject) parser.parse(obj.toString());
            String teamName = jsonObj.get("teamName").toString();
            int team_id = Integer.parseInt(jsonObj.get("team_id").toString());
            JSONObject player = new JSONObject();
            player.put("label", teamName);
            player.put("value", team_id);
            playerslist.add(player);
        }

        System.out.println(playerslist.toString());


        return playerslist.toString();
    }

    @CrossOrigin(value = "*")
    @GetMapping("/playersteam/{id}")
    public String getPlayersForMatchinTeam(@PathVariable("id") String id) throws ParseException {


        String result = sendData.getInfo("/playersinfo");
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(result);

        JSONArray playerslist = new JSONArray();

        for (Object obj : json){
            JSONObject jsonObj = (JSONObject) parser.parse(obj.toString());
            String fullName = jsonObj.get("first_name").toString() + " " + jsonObj.get("last_name").toString();
            int person_id = Integer.parseInt(jsonObj.get("player_id").toString());
            String team_id = jsonObj.get("team_id").toString();
            if (team_id.equals(id)){
                JSONObject player = new JSONObject();
                player.put("label", fullName);
                player.put("value", person_id);
                player.put("team", team_id);
                playerslist.add(player);
            }
        }

        System.out.println(playerslist.toString());


        return playerslist.toString();
    }


}
