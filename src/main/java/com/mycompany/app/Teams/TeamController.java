package com.mycompany.app.Teams;

import com.fasterxml.jackson.annotation.JacksonInject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;


@RestController
@CrossOrigin(origins = "*")
public class TeamController {

    @JacksonInject
    RestTemplate restTemplate = new RestTemplate();
    TeamService sendData = new TeamService();
    String test = null;


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
    public String addMatch(@RequestBody String user) throws ParseException {

        //sendData.RegTeam("/matches", user);

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(user);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate localDate = LocalDate.parse(json.get("match_date").toString(), formatter);

        String date = json.get("match_date").toString();
        json.replace("match_date", date, localDate.toString());
        String match_date = json.get("match_date").toString();
        String season = json.get("season").toString();
        String homeTeam = json.get("home_team").toString();
        String awayTeam = json.get("away_team").toString();
        JSONObject homeTeamObj = (JSONObject) parser.parse(homeTeam);
        JSONObject seasonObj = (JSONObject) parser.parse(season);
        JSONObject awayTeamObj = (JSONObject) parser.parse(awayTeam);

        String positionsHome = json.get("positionsHome").toString();
        String positionsAway = json.get("positionsAway").toString();

        int seasonID = Integer.parseInt(seasonObj.get("value").toString());
        int homeTeamID = Integer.parseInt(homeTeamObj.get("value").toString());
        int awayTemID = Integer.parseInt(awayTeamObj.get("value").toString());
        JSONObject matchObj = new JSONObject();
        matchObj.put("match_date", match_date);
        matchObj.put("season", seasonID);
        matchObj.put("location", 1);
        matchObj.put("home_team", homeTeamID);
        matchObj.put("away_team", awayTemID);

        //System.out.println(matchObj.toString());

        String match = sendData.RegTeam("/matches", matchObj.toString());
        JSONObject matchObject = (JSONObject) parser.parse(match);

        int matchID = Integer.parseInt(matchObject.get("match_id").toString());
        JSONArray positionsHomeArr = (JSONArray) parser.parse(positionsHome);
        JSONArray positionsAwayArr = (JSONArray) parser.parse(positionsAway);

        for (Object objaway : positionsAwayArr){
            JSONObject awayJson = (JSONObject) parser.parse(objaway.toString());
            String player = awayJson.get("player").toString();
            JSONObject playerObj = (JSONObject) parser.parse(player);



            int personID = Integer.parseInt(playerObj.get("value").toString());

            JSONObject playerposition = new JSONObject();
            playerposition.put("playerId", personID);
            playerposition.put("matchId", matchID);
            playerposition.put("position", awayJson.get("description").toString());
            System.out.println(playerposition.toString());
            //sendData.RegTeam("/matchpositions", playerposition.toString());




        }

        for (Object objhome : positionsHomeArr){
            JSONObject homeJson = (JSONObject) parser.parse(objhome.toString());
            String player = homeJson.get("player").toString();
            JSONObject playerObj = (JSONObject) parser.parse(player);

            System.out.println(playerObj.toString());

            //System.out.println(homeJson.toString());

            int personID = Integer.parseInt(playerObj.get("value").toString());
            JSONObject playerposition = new JSONObject();
            playerposition.put("playerId", personID);
            playerposition.put("matchId", matchID);
            playerposition.put("position", homeJson.get("description").toString());
            System.out.println(playerposition.toString());
            //sendData.RegTeam("/matchpositions", playerposition.toString());


        }


        //System.out.println(match);

        //System.out.println(user);
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
        //System.out.println(jsonhome.toString());

        for (Object objh: jsonhome){
            JSONObject jsonh = (JSONObject) parser.parse(objh.toString());
            System.out.println(jsonh);
            //System.out.println(goal.toString());

            JSONObject goaltype = (JSONObject) parser.parse(jsonh.get("goal").toString());
            JSONObject player = (JSONObject) parser.parse(jsonh.get("player").toString());

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
        //System.out.println(jsonaway.toString());

        for (Object obja: jsonaway){


            JSONObject jsona = (JSONObject) parser.parse(obja.toString());

            JSONObject goaltype = (JSONObject) parser.parse(jsona.get("goal").toString());
            JSONObject player = (JSONObject) parser.parse(jsona.get("player").toString());


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
        String end_date = seasonsObj.get("end_date").toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate localDate = LocalDate.parse(start_date, formatter);

        LocalDate localDate1 = LocalDate.parse(end_date, formatter);

        seasonsObj.replace("start_date", localDate.toString());
        seasonsObj.replace("end_date", localDate1.toString());

        System.out.println(seasonsObj.toString());
        sendData.RegTeam("/seasons", seasonsObj.toString());
/*
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        SimpleDateFormat df1 = new SimpleDateFormat("YYYY-MM-dd", Locale.ENGLISH);

        Date datestart =  new Date(start_date);
        String dates1 = df.format(datestart);
        System.out.println(dates1);

        Date dateend =  new Date(seasonsObj.get("end_date").toString());
        String datee1 = df.format(dateend);

        System.out.println(datee1);
*/
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

        String resultString = sendData.getInfo("/results");
        JSONArray results = (JSONArray) parser.parse(resultString);

        JSONArray finalResults = new JSONArray();

        for (Object matchObj : matches){
            JSONObject match = (JSONObject) parser.parse(matchObj.toString());
            int match_id = Integer.parseInt(match.get("match_id").toString());
            int home_id = Integer.parseInt(match.get("home_team").toString());
            int away_id = Integer.parseInt(match.get("away_team").toString());
            JSONObject final_result = new JSONObject();

            final_result.put("date", match.get("match_date").toString());
            for (Object resultObj : results){


                JSONObject result = (JSONObject) parser.parse(resultObj.toString());

                System.out.println(result.toString());


                int match_result = Integer.parseInt(result.get("footballMatch").toString());
                if (match_id == match_result) {
                    int team = Integer.parseInt(result.get("team").toString());
                    String url = "/teams/" + team;
                    String teamNameString = sendData.getInfo(url);
                    JSONObject team_name = (JSONObject) parser.parse(teamNameString);


                    if (team == home_id) {
                        final_result.put("home_team", team_name.get("teamName").toString());
                        final_result.put("home_score", result.get("score").toString());
                        final_result.put("home_result", result.get("result").toString());


                    } else if (team == away_id) {
                        final_result.put("away_team", team_name.get("teamName").toString());
                        final_result.put("away_score", result.get("score").toString());
                        final_result.put("away_result", result.get("result").toString());
                    }

                    finalResults.add(final_result);


                }
            }
        }


        //System.out.println(user);
        return finalResults.toString();
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




    @CrossOrigin(value = "*")
    @RequestMapping(value = "/positions", method = RequestMethod.POST)
    public RedirectView addpostions(@RequestBody String user){

        test = user;
        //sendData.RegTeam("/goaltypes", user);
        //System.out.println(user);
        return new RedirectView("/sendposition");
    }

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/sendposition", method = RequestMethod.GET)
    public String getpostions(){

        System.out.println(test);
        String back = test;
        test = null;
        System.out.println(back);
        System.out.println(test);
        //sendData.RegTeam("/goaltypes", user);

        return back;
    }



}
