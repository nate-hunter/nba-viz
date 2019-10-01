//package com.njh.app.nbaviz;
//
//import com.njh.app.nbaviz.data.PlayerContractData;
//import com.njh.app.nbaviz.data.TeamData;
//import com.njh.app.nbaviz.io.TeamRepository;
//import com.njh.app.nbaviz.model.PlayerContract;
//import com.njh.app.nbaviz.model.Team;
//import org.jsoup.select.Elements;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//
//@Component
//class InitializerCopy implements CommandLineRunner {
//
//
//    private final TeamRepository repository;
//
//    public InitializerCopy(TeamRepository repository) {
//        this.repository = repository;
//    }
//
//
//    @Override
//    public void run(String... strings) throws IOException {
//        TeamData teamData = new TeamData();
//        Elements teams = teamData.getTeamData();
//        ArrayList<Team> teamList = new ArrayList<>();
//
//        teams.forEach(team -> {
//            String teamName = team.attr("title");
//            String accronym = team.text();
//            String link = team.attr("href");
//            Team nbaTeam = new Team(teamName, accronym, link);
//            repository.save(nbaTeam);
//            teamList.add(nbaTeam);
//        });
//
//        PlayerContractData playerContracts = new PlayerContractData();
//        Elements data = playerContracts.getPlayerContractData();
//
//        ArrayList<HashMap<String, String>> players = playerContracts.getContractValues(data);
//        ArrayList<PlayerContract> playerList = new ArrayList<>();
//
//
//        players.forEach(player -> {
//            HashMap<String, String> d = new HashMap<>();
//            HashMap<String, String> di = new HashMap<>();
//
//            String playerName = player.get("playerName");
//            String link = player.get("link");
//            String teamAccr = player.get("teamAccr");
//            String y2019 = player.get("2019-2020");
//            String y2020 = player.get("2020-2021");
//            String y2021 = player.get("2021-2022");
//            String y2022 = player.get("2022-2023");
//            String y2023 = player.get("2023-2024");
//            String y2024 = player.get("2024-2025");
//            String gtd = player.get("guaranteed");
//            d.put("2019-2020", y2019);
//            d.put("2020-2021", y2020);
//            d.put("2021-2022", y2021);
//            d.put("2022-2023", y2022);
//            d.put("2023-2024", y2023);
//            d.put("2024-2025", y2024);
//
//            HashMap<String, String> t = new HashMap<>();
//            String y2019Data = player.get("2019-2020_Data");
//            String y2020Data = player.get("2020-2021_Data");
//            String y2021Data = player.get("2021-2022_Data");
//            String y2022Data = player.get("2022-2023_Data");
//            String y2023Data = player.get("2023-2024_Data");
//            String y2024Data = player.get("2024-2025_Data");
//            di.put("2019-2020_Data", y2019Data);
//            di.put("2020-2021_Data", y2020Data);
//            di.put("2021-2022_Data", y2021Data);
//            di.put("2022-2023_Data", y2022Data);
//            di.put("2023-2024_Data", y2023Data);
//            di.put("2024-2025_Data", y2024Data);
//            String gtdData = player.get("guaranteed_Data");
//
//
////			 for ( Map.Entry<String, String> y : t.entrySet() ) {
////				 if(!y.getValue().isEmpty()) {
////					 System.out.println("    PLAYER: " + playerName);
////					 System.out.println(" YEAR DATA: " + y.getValue());
////					 double i = Double.parseDouble(y.getValue());
////					 System.out.println("          : " + i);
////					 di.put(y.getKey(), i);
////				 }
////			 }
//
//            PlayerContract p = new PlayerContract(playerName, link, teamAccr, d, gtd, di, gtdData);
//            playerList.add(p);
//        });
//
//        for ( Team t : teamList ) {
//            for ( PlayerContract p : playerList ) {
//                if(p.getTeamAbrev().equals(t.getTeamAbbr())) {
////				 System.out.println("  TEAM ACCR |" + t.getAccronym() + "|   PLAYER |" + p.getName() + "|");
//                    t.getPlayerContracts().add(p);
//                }
//            }
//            repository.save(t);
//        }
//
//        System.out.println("    PLAYERCONTRACT COUNT: " + PlayerContract.playerCount);
//        System.out.println("    PLAYERLIST SIZE: " + playerList.size());
//        System.out.println("    TEAM COUNT: " + teamList.size());
////		 repository.findAll().forEach(System.out::println);
//    }
//
//
//}
//
