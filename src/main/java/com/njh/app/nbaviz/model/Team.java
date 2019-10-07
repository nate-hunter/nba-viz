package com.njh.app.nbaviz.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
//@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String teamName;
//    private String city;
    private String teamAbbr;
    private String link;
//    private String season;
//    private float champOdds;
//    private float overUnder;
//    private String conference;
//    private String division;
//    private String colorPrimary;
//    private String colorSecondary;
    private String logo;

    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<PlayerContract> playerContracts = new ArrayList<>();

    public Team(@NonNull String teamName, String teamAbbr, String link) {
        this.teamName = teamName;
        this.teamAbbr = teamAbbr;
        this.link = link;
    }

    public Team(@NonNull String teamName, String teamAbbr, String link, String logo) {
        this.teamName = teamName;
        this.teamAbbr = teamAbbr;
        this.link = link;
        this.logo = logo;
    }

    public Team(String teamName, String teamAbbr, String link, List<PlayerContract> playerContracts) {
        this.teamName = teamName;
        this.teamAbbr = teamAbbr;
        this.link = link;
        this.playerContracts = playerContracts;
    }

}
