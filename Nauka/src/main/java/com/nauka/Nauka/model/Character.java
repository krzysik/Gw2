package com.nauka.Nauka.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class Character {
    private String name;
    private String race;
    private String gender;
    private String profession;
    private int level;
    private int deaths;
    @JsonProperty("crafting")
    private List<Crafting> crafting;
    @JsonProperty("equipment")
    private List<Equipment> equipment;


    public Character() {
        super();
    }

    public Character(String name, String race, String gender, String profession, int level, int deaths, List<Crafting> crafting, List<Equipment> equipment) {
        this.name = name;
        this.race = race;
        this.gender = gender;
        this.profession = profession;
        this.level = level;
        this.deaths = deaths;
        this.crafting = crafting;
        this.equipment = equipment;
    }

    public Character(String name, String race, String gender, String profession, int level, int deaths) {
        this.name = name;
        this.race = race;
        this.gender = gender;
        this.profession = profession;
        this.level = level;
        this.deaths = deaths;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public List<Crafting> getCrafting() {
        return crafting;
    }

    public void setCrafting(List<Crafting> crafting) {
        this.crafting = crafting;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
