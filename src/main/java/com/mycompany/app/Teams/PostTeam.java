package com.mycompany.app.Teams;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "*")
public class PostTeam {

    RestTemplate restTemplate = new RestTemplate();
    TeamService sendData = new TeamService();

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/teams", method = RequestMethod.POST)
    public String createTeam(@RequestBody String user){

        String result = sendData.RegTeam("/teams", user);

        System.out.println(result);
        return user;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/coaches", method = RequestMethod.POST)
    public String createCouch(@RequestBody String user){

        String result = sendData.RegTeam("/coaches", user);

        System.out.println(result);
        return user;
    }
    @CrossOrigin(value = "*")
    @RequestMapping(value = "/matches", method = RequestMethod.POST)
    public String createMatches(@RequestBody String user){

        String result = sendData.RegTeam("/matches", user);

        System.out.println(result);
        return user;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/owners", method = RequestMethod.POST)
    public String createOwner(@RequestBody String user){

        String result = sendData.RegTeam("/owners", user);

        System.out.println(result);
        return user;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/locations", method = RequestMethod.POST)
    public String createLocation(@RequestBody String user){

        String result = sendData.RegTeam("/locations", user);

        System.out.println(result);
        return user;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/associations", method = RequestMethod.POST)
    public String createassociations(@RequestBody String user){

        String result = sendData.RegTeam("/associations", user);

        System.out.println(result);
        return user;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/matchgoals", method = RequestMethod.POST)
    public String creatematchgoals(@RequestBody String user){

        String result = sendData.RegTeam("/matchgoals", user);

        System.out.println(result);
        return user;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/seasons", method = RequestMethod.POST)
    public String createseasons(@RequestBody String user){

        String result = sendData.RegTeam("/seasons", user);

        System.out.println(result);
        return user;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/goaltypes", method = RequestMethod.POST)
    public String creategoaltypes(@RequestBody String user){

        String result = sendData.RegTeam("/goaltypes", user);

        System.out.println(result);
        return user;
    }



}
