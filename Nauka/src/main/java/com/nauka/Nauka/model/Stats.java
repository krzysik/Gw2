package com.nauka.Nauka.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Stats {
    private int id;
    @JsonProperty("attributes")
    private Object attributes;

    public Stats(){
        super();
    }

    public Stats(int id ,Object attributes) {
        this.id = id;
        this.attributes = attributes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }
}
