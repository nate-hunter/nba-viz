package com.njh.app.nbaviz.data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TeamData {

    private String URL = "https://www.basketball-reference.com";

    public Elements getTeamData() throws IOException {

        Document document = Jsoup.connect(this.URL).get();

        Elements dataGrid = document.getElementsByClass("data_grid section_wrapper");

        Elements teamData = dataGrid.select("[data-stat='team_name']").select("a[href]");

        return teamData;
    }

}
