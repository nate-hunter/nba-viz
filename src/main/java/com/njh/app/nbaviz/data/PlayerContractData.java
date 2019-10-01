package com.njh.app.nbaviz.data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PlayerContractData {


    public Elements getPlayerContractData() throws IOException {
//        Document document = Jsoup.connect(this.URL).get();
        String filename = "C:\\Java-nh\\Projects\\nba-contracts\\20190903\\backend\\nba-contracts\\dataHtml\\playerContracts2.html";
        File file = new File(filename);
        Document doc = Jsoup.parse(file,"UTF-8");
        Elements playerContractData = doc.getElementsByTag("tr");

        return playerContractData;
    }

    public ArrayList<HashMap<String, String>> getContractValues(Elements data) {
        ArrayList<HashMap<String, String>> playerList = new ArrayList<>();

        for (Element player : data) {
            String playerName = player.select("[data-stat='player']").text();
            String teamAbbr = player.select("[data-stat='team_id']").text();
            String link = player.select("a[href]").attr("href");
            String y1 = player.select("[data-stat='y1']").text();
            String y2 = player.select("[data-stat='y2']").text();
            String y3 = player.select("[data-stat='y3']").text();
            String y4 = player.select("[data-stat='y4']").text();
            String y5 = player.select("[data-stat='y5']").text();
            String y6 = player.select("[data-stat='y6']").text();
            String gtd = player.select("[data-stat='remain_gtd']").text();
            String y1Num = player.select("[data-stat='y1']").attr("csk");
            String y2Num = player.select("[data-stat='y2']").attr("csk");
            String y3Num = player.select("[data-stat='y3']").attr("csk");
            String y4Num = player.select("[data-stat='y4']").attr("csk");
            String y5Num = player.select("[data-stat='y5']").attr("csk");
            String y6Num = player.select("[data-stat='y6']").attr("csk");
            String gtdNum = player.select("[data-stat='remain_gtd']").attr("csk");
            ArrayList<Integer> nums = new ArrayList<>();
            ArrayList<String> numsStr = new ArrayList<>();
            numsStr.add(y1Num);
            numsStr.add(y2Num);
            numsStr.add(y3Num);
            numsStr.add(y4Num);
            numsStr.add(y5Num);
            numsStr.add(y6Num);
            numsStr.add(gtdNum);

            if (!playerName.equals("Player") && !playerName.isEmpty()) {
                HashMap<String, String> dataMap = new HashMap<>();
                dataMap.put("playerName",playerName);
                dataMap.put("teamAbbr", teamAbbr);
                dataMap.put("link", link);
                dataMap.put("2019-2020", y1);
                dataMap.put("2020-2021", y2);
                dataMap.put("2021-2022", y3);
                dataMap.put("2022-2023", y4);
                dataMap.put("2023-2024", y5);
                dataMap.put("2024-2025", y6);
                dataMap.put("guaranteed", gtd);
                dataMap.put("2019-2020_Data", y1Num);
                dataMap.put("2020-2021_Data", y2Num);
                dataMap.put("2021-2022_Data", y3Num);
                dataMap.put("2022-2023_Data", y4Num);
                dataMap.put("2023-2024_Data", y5Num);
                dataMap.put("2024-2025_Data", y6Num);
                dataMap.put("guaranteed_Data", gtdNum);
                playerList.add(dataMap);
            }

            for( String s : numsStr ) {
                if(!s.isEmpty()) {
                    nums.add(Integer.parseInt(s));
                }
            }
        }
        return playerList;
    }

    public void printAllPlayerContracts() throws IOException {
        String filename = "C:\\Java-nh\\Projects\\nba-contracts\\20190903\\backend\\nba-contracts\\dataHtml\\playerContracts2.html";
        File file = new File(filename);
        Document doc = Jsoup.parse(file,"UTF-8");
        System.out.println(doc);
    }

}
