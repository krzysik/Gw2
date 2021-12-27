package com.nauka.Nauka.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Equipment {
    private int id;


    public Equipment(){
        super();
    }

    public Equipment(int id) {
        this.id = id;


    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
