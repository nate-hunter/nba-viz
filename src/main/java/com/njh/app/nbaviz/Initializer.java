package com.njh.app.nbaviz;

import com.njh.app.nbaviz.data.PlayerContractData;
import com.njh.app.nbaviz.data.TeamData;
import com.njh.app.nbaviz.io.TeamRepository;
import com.njh.app.nbaviz.model.PlayerContract;
import com.njh.app.nbaviz.model.Team;
import org.jsoup.select.Elements;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@Component
class Initializer implements CommandLineRunner {

    private final TeamRepository repository;

    public Initializer(TeamRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws IOException {
        TeamData teamData = new TeamData();
        Elements teams = teamData.getTeamData();
        ArrayList<Team> teamList = new ArrayList<>();

        teams.forEach(team -> {
            String teamName = team.attr("title");
            String teamAbbr = team.text();
            String link = team.attr("href");
//            String season = "2019-2020";
            String logo = "https://d2p3bygnnzw9w3.cloudfront.net/req/201909231/tlogo/bbr/" + teamAbbr + "-2019.png";
            Team nbaTeam = new Team(teamName, teamAbbr, link, logo);
            repository.save(nbaTeam);
            teamList.add(nbaTeam);
        });

        PlayerContractData playerContracts = new PlayerContractData();
        Elements data = playerContracts.getPlayerContractData();

        ArrayList<HashMap<String, String>> players = playerContracts.getContractValues(data);
        ArrayList<PlayerContract> playerList = new ArrayList<>();


        players.forEach(player -> {
            HashMap<String, String> contractValueList = new HashMap<>();

            String playerName = player.get("playerName");
            String link = player.get("link");
            String teamAbbr = player.get("teamAbbr");

            HashMap<String, String> t = new HashMap<>();
            String y2019Data = player.get("2019-2020_Data");
            String y2020Data = player.get("2020-2021_Data");
            String y2021Data = player.get("2021-2022_Data");
            String y2022Data = player.get("2022-2023_Data");
            String y2023Data = player.get("2023-2024_Data");
            String y2024Data = player.get("2024-2025_Data");
            contractValueList.put("2019-2020_Data", y2019Data);
            contractValueList.put("2020-2021_Data", y2020Data);
            contractValueList.put("2021-2022_Data", y2021Data);
            contractValueList.put("2022-2023_Data", y2022Data);
            contractValueList.put("2023-2024_Data", y2023Data);
            contractValueList.put("2024-2025_Data", y2024Data);
            String gtdData = player.get("guaranteed_Data");

            PlayerContract p = new PlayerContract(playerName, link, teamAbbr, contractValueList, gtdData);
            playerList.add(p);
        });

        for ( Team t : teamList ) {
            for ( PlayerContract p : playerList ) {
                if(p.getTeamAbrev().equals(t.getTeamAbbr())) {
                    t.getPlayerContracts().add(p);
                }
            }
            repository.save(t);
        }

		 repository.findAll().forEach(System.out::println);
        System.out.println("    PLAYERCONTRACT COUNT: " + PlayerContract.playerCount);
        System.out.println("    PLAYERLIST SIZE: " + playerList.size());
        System.out.println("    TEAM COUNT: " + teamList.size());
    }

}
