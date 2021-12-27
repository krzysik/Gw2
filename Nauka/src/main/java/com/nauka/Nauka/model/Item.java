package com.nauka.Nauka.model;

public class Item {

    private String name;
    private String description;
    private String icon;
    private String type;
    private String rarity;
    private int level;
    private Object details;

    public Item(){
        super();
    }

    public Item(String name, String description, String icon, String type, String rarity, int level, Object details) {
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.type = type;
        this.rarity = rarity;
        this.level = level;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }
}
