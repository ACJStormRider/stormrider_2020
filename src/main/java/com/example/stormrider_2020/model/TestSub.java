package com.example.stormrider_2020.model;

import java.util.List;

public class TestSub {

    private int id;
    private String name;
    private List<SubCat> subcats;

    public TestSub(int id, String name, List<SubCat> subcats) {
        this.id = id;
        this.name = name;
        this.subcats = subcats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubCat> getSubcats() {
        return subcats;
    }

    public void setSubcats(List<SubCat> subcats) {
        this.subcats = subcats;
    }
}
