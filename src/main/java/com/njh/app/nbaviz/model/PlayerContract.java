package com.njh.app.nbaviz.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class PlayerContract {

    public static int playerCount;

    @Id
    @GeneratedValue
    private Long id;
    private String name;
//    private int age;
    private String link;
    private String teamAbrev;
    private HashMap<String, String> contract;
    private String guaranteed;
//    private HashMap<String, String> contractStr;
//    private String guaranteedStr;

    public PlayerContract(String name, String link, String teamAbrev, HashMap<String, String> contract, String guaranteed) {
        this.name = name;
        this.link = link;
        this.teamAbrev = teamAbrev;
        this.contract = contract;
        this.guaranteed = guaranteed;
        playerCount++;
    }

}
