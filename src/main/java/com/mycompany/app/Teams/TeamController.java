package com.mycompany.app.Teams;

import com.fasterxml.jackson.annotation.JacksonInject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;


@RestController
@CrossOrigin(origins = "*")
public class TeamController {

    @JacksonInject
    RestTemplate restTemplate = new RestTemplate();
    TeamService sendData = new TeamService();

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public String getTeams() throws ParseException {

        String result = sendData.getInfo("/teams");
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(result);

        for (Object obj : json){
            JSONObject jsonObj = (JSONObject) parser.parse(obj.toString());
            System.out.println(jsonObj.toString());

        }

        return result;
    }

    @CrossOrigin(value = "*")
    @GetMapping("/team/{id}")
    public String getTeam(@PathVariable("id") String id) throws ParseException {

        //System.out.println(id);


        String url = "/teams/" + id;
        String result = sendData.getInfo(url);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(result);
        //System.out.println(json.toString());

        return json.toString();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/coaches", method = RequestMethod.GET)
    public String getCoaches() throws ParseException {

        String result = sendData.getInfo("/coaches");
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(result);

        for (Object obj : json){
            JSONObject jsonObj = (JSONObject) parser.parse(obj.toString());
            System.out.println(jsonObj.toString());

        }

        return result;
    }

    @CrossOrigin(value = "*")
    @GetMapping("/coach/{id}")
    public String getcouch(@PathVariable("id") String id) throws ParseException {

        //System.out.println(id);


        String url = "/coaches/" + id;
        String result = sendData.getInfo(url);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(result);
        //System.out.println(json.toString());

        return json.toString();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/matcheso", method = RequestMethod.GET)
    public String getMatches() throws ParseException {

        String result = sendData.getMatchInfo();
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(result);

        for (Object obj : json){
            JSONObject jsonObj = (JSONObject) parser.parse(obj.toString());
            System.out.println(jsonObj.toString());

        }

        return result;
    }

    @CrossOrigin(value = "*")
    @GetMapping("/match/{id}")
    public String getMatche(@PathVariable("id") String id) throws ParseException {

        //System.out.println(id);


        String url = "/matches/" + id;
        String result = sendData.getInfo(url);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(result);
        //System.out.println(json.toString());

        return json.toString();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/owners", method = RequestMethod.GET)
    public String getOwners() throws ParseException {

        String result = sendData.getInfo("/owners");
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(result);

        for (Object obj : json){
            JSONObject jsonObj = (JSONObject) parser.parse(obj.toString());
            System.out.println(jsonObj.toString());

        }

        return result;
    }

    @CrossOrigin(value = "*")
    @GetMapping("/owner/{id}")
    public String getOwner(@PathVariable("id") String id) throws ParseException {

        //System.out.println(id);


        String url = "/owners/" + id;
        String result = sendData.getInfo(url);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(result);
        //System.out.println(json.toString());

        return json.toString();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    public String getLocations() throws ParseException {

        String result = sendData.getInfo("/locations");
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(result);

        for (Object obj : json){
            JSONObject jsonObj = (JSONObject) parser.parse(obj.toString());
            System.out.println(jsonObj.toString());

        }

        return result;
    }

    @CrossOrigin(value = "*")
    @GetMapping("/location/{id}")
    public String getlocation(@PathVariable("id") String id) throws ParseException {

        //System.out.println(id);


        String url = "/locations/" + id;
        String result = sendData.getInfo(url);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(result);
        //System.out.println(json.toString());

        return json.toString();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/associations", method = RequestMethod.GET)
    public String getassociations() throws ParseException {

        String result = sendData.getInfo("/associations");
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(result);

        for (Object obj : json){
            JSONObject jsonObj = (JSONObject) parser.parse(obj.toString());
            System.out.println(jsonObj.toString());

        }

        return result;
    }

    @CrossOrigin(value = "*")
    @GetMapping("/association/{id}")
    public String getassociation(@PathVariable("id") String id) throws ParseException {

        //System.out.println(id);


        String url = "/associations/" + id;
        String result = sendData.getInfo(url);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(result);
        //System.out.println(json.toString());

        return json.toString();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/matchgoals", method = RequestMethod.GET)
    public String getmatchgoals() throws ParseException {

        String result = sendData.getInfo("/matchgoals");
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(result);

        for (Object obj : json){
            JSONObject jsonObj = (JSONObject) parser.parse(obj.toString());
            System.out.println(jsonObj.toString());

        }

        return result;
    }

    @CrossOrigin(value = "*")
    @GetMapping("/matchgoal/{id}")
    public String getmatchgoal(@PathVariable("id") String id) throws ParseException {

        //System.out.println(id);


        String url = "/matchgoals/" + id;
        String result = sendData.getInfo(url);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(result);
        //System.out.println(json.toString());

        return json.toString();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/seasons", method = RequestMethod.GET)
    public String getseasons() throws ParseException {

        String result = sendData.getInfo("/seasons");
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(result);

        for (Object obj : json){
            JSONObject jsonObj = (JSONObject) parser.parse(obj.toString());
            System.out.println(jsonObj.toString());

        }

        return result;
    }

    @CrossOrigin(value = "*")
    @GetMapping("/season/{id}")
    public String getseason(@PathVariable("id") String id) throws ParseException {

        //System.out.println(id);


        String url = "/seasons/" + id;
        String result = sendData.getInfo(url);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(result);
        //System.out.println(json.toString());

        return json.toString();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/goaltypes", method = RequestMethod.GET)
    public String getgoaltypes() throws ParseException {

        String result = sendData.getInfo("/goaltypes");
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(result);

        for (Object obj : json){
            JSONObject jsonObj = (JSONObject) parser.parse(obj.toString());
            System.out.println(jsonObj.toString());

        }

        return result;
    }

    @CrossOrigin(value = "*")
    @GetMapping("/goaltype/{id}")
    public String getgoaltype(@PathVariable("id") String id) throws ParseException {

        //System.out.println(id);


        String url = "/goaltypes/" + id;
        String result = sendData.getInfo(url);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(result);
        //System.out.println(json.toString());

        return json.toString();
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String addResult(@RequestBody String user) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(user);
        int homescore = Integer.parseInt(json.get("homescore").toString());
        int awayscore = Integer.parseInt(json.get("awayscore").toString());
        int hometeam = Integer.parseInt(json.get("hometeam").toString());
        int awayteam = Integer.parseInt(json.get("awayteam").toString());
        int match_id = Integer.parseInt(json.get("match_id").toString());
        String result = null;

        JSONObject homeresult = new JSONObject();
        homeresult.put("score", homescore);
        homeresult.put("matchId", match_id);
        homeresult.put("teamId", hometeam);

        JSONObject awayresult = new JSONObject();
        awayresult.put("score", awayscore);
        awayresult.put("matchId", match_id);
        awayresult.put("teamId", awayteam);

        if (homescore > awayscore){
            homeresult.put("result", "Win");
            awayresult.put("result", "Lose");
        }else if (homescore < awayscore){
            homeresult.put("result", "Lose");
            awayresult.put("result", "Win");
        }else if(homescore == awayscore){
            homeresult.put("result", "Tie");
            awayresult.put("result", "Tie");
        }


        System.out.println(homeresult.toString());
        System.out.println(awayresult.toString());

        sendData.RegTeam("/results", homeresult.toString());
        sendData.RegTeam("/results", awayresult.toString());
        //System.out.println(user);
        return user;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/addteam", method = RequestMethod.POST)
    public String addTeam(@RequestBody String user){

        sendData.RegTeam("/teams", user);
        System.out.println(user);
        return user;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/updateteam", method = RequestMethod.POST)
    public String updateTeam(@RequestBody String user) throws ParseException {

        System.out.println(user);

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(user);

        int id = Integer.parseInt(json.get("team_id").toString());
        System.out.println(id);

        json.remove("team_id");
        System.out.println(json.toString());

        String url = "/teams/" + id;
        sendData.UpTeam(url, json.toString());

        return user;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/delteam", method = RequestMethod.POST)
    public String delTeam(@RequestBody String user) throws ParseException {

        System.out.println(user);

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(user);
        String teamID = json.get("team_id").toString();
        System.out.println(teamID);


        String url = "/teams/" + teamID;
        sendData.DelTeam(url);


        return user;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/addmatch", method = RequestMethod.POST)
    public String addMatch(@RequestBody String user){

        //sendData.RegTeam("/matches", user);

        System.out.println(user);
        return user;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/addgoal", method = RequestMethod.POST)
    public String addGoal(@RequestBody String user) throws ParseException {

        //sendData.RegTeam("/matches", user);goaltypeformatch
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(user);

        int match_id = Integer.parseInt(json.get("match_id").toString());
        String homegoals = json.get("homegoals").toString();
        String awaygoals = json.get("awaygoals").toString();
        //System.out.println(homegoals);
        //System.out.println(awaygoals);
        JSONArray jsonhome = (JSONArray) parser.parse(homegoals);
        for (Object objh: jsonhome){
            JSONObject jsonh = (JSONObject) parser.parse(objh.toString());
            JSONObject goal = (JSONObject) parser.parse(jsonh.toString());
            JSONObject goaltype = (JSONObject) parser.parse(goal.get("goaltype").toString());
            JSONObject player = (JSONObject) parser.parse(goal.get("player").toString());

            JSONObject goalmatch = new JSONObject();
            int goaltype_id = Integer.parseInt(goaltype.get("value").toString());
            int player_id = Integer.parseInt(player.get("value").toString());
            goalmatch.put("goalType", goaltype_id);
            goalmatch.put("footballMatch", match_id);
            goalmatch.put("player", player_id);

            System.out.println(goalmatch.toString());
            sendData.RegTeam("/matchgoals", goalmatch.toString());

        }

        JSONArray jsonaway = (JSONArray) parser.parse(awaygoals);
        for (Object obja: jsonaway){
            JSONObject jsona = (JSONObject) parser.parse(obja.toString());
            JSONObject goal = (JSONObject) parser.parse(jsona.toString());
            JSONObject goaltype = (JSONObject) parser.parse(goal.get("goaltype").toString());
            JSONObject player = (JSONObject) parser.parse(goal.get("player").toString());


            JSONObject goalmatch = new JSONObject();
            int goaltype_id = Integer.parseInt(goaltype.get("value").toString());
            int player_id = Integer.parseInt(player.get("value").toString());
            goalmatch.put("goalType", goaltype_id);
            goalmatch.put("footballMatch", match_id);
            goalmatch.put("player", player_id);

            System.out.println(goalmatch.toString());
            sendData.RegTeam("/matchgoals", goalmatch.toString());
        }
        //System.out.println(json.toString());
        return user;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/addseason", method = RequestMethod.POST)
    public String addSeason(@RequestBody String user) throws ParseException, java.text.ParseException {

        //sendData.RegTeam("/seasons", user);
        System.out.println(user);
        JSONParser parser = new JSONParser();
        JSONObject seasonsObj = (JSONObject) parser.parse(user);
        String start_date = seasonsObj.get("start_date").toString();
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        Date date =  new Date(start_date);
        String date1 = format.format(date);
        System.out.println(date1);
        return user;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/addgoaltype", method = RequestMethod.POST)
    public String addGoalType(@RequestBody String user){

        sendData.RegTeam("/goaltypes", user);
        System.out.println(user);
        return user;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/matchlist", method = RequestMethod.GET)
    public String matchList() throws ParseException {

        String matchString = sendData.getInfo("/matches");
        JSONParser parser = new JSONParser();
        JSONArray matches = (JSONArray) parser.parse(matchString);

        JSONArray matchesArr = new JSONArray();

        for (Object objMatch : matches){
            JSONObject match11 = (JSONObject) parser.parse(objMatch.toString());

            int match_id = Integer.parseInt(match11.get("match_id").toString());
            int home = Integer.parseInt(match11.get("home_team").toString());
            int away = Integer.parseInt(match11.get("away_team").toString());
            int season = Integer.parseInt(match11.get("season").toString());
            String date = match11.get("match_date").toString();
            JSONObject matchup = new JSONObject();

            String urlhome = "/teams/" + home;
            String matchHome = sendData.getInfo(urlhome);
            JSONObject HomeTeam = (JSONObject) parser.parse(matchHome);

            String urlaway = "/teams/" + away;
            String matchAway = sendData.getInfo(urlaway);
            JSONObject AwayTeam = (JSONObject) parser.parse(matchAway);

            matchup.put("home_team", HomeTeam.get("teamName").toString());
            matchup.put("away_team", AwayTeam.get("teamName").toString());
            matchup.put("season", season);
            matchup.put("date", date);

            JSONArray resultsArr = new JSONArray();
            String resultString = sendData.getInfo("/results");
            JSONArray results = (JSONArray) parser.parse(resultString);

            for (Object objRes : results){
                JSONObject result1 = (JSONObject) parser.parse(objRes.toString());

                int matchResult = Integer.parseInt(result1.get("footballMatch").toString());
                int score = Integer.parseInt(result1.get("score").toString());
                String resultName = result1.get("result").toString();
                int team = Integer.parseInt(result1.get("team").toString());

                if (matchResult == match_id){
                    //resultsArr.add(result1);

                    if (team == home){
                        matchup.put("home_score", score);
                        matchup.put("home_result", resultName);
                    }else if (team == away){
                        matchup.put("away_score", score);
                        matchup.put("away_result", resultName);
                    }

                }

            }

            System.out.println(matchup.toString());
            matchesArr.add(matchup);

        }



        //System.out.println(user);
        return matchesArr.toString();
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/seasonslist", method = RequestMethod.GET)
    public String seasons() throws ParseException {

        String seasonsString = sendData.getInfo("/seasons");
        JSONParser parser = new JSONParser();
        JSONArray seasons = (JSONArray) parser.parse(seasonsString);
        JSONArray seasonObjArr = new JSONArray();
        for (Object obj : seasons){
            JSONObject season = (JSONObject) parser.parse(obj.toString());
            JSONObject seasonObj = new JSONObject();

            seasonObj.put("label", season.get("name").toString());
            seasonObj.put("value", season.get("season_id").toString());
            seasonObjArr.add(seasonObj);
        }
        System.out.println(seasonObjArr.toString());
        return seasonObjArr.toString();
    }








}
