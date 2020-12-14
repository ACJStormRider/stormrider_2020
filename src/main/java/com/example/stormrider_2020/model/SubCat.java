package com.example.stormrider_2020.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubCat {

    @Id
    private int subcategory_id;
    private String name;

    public SubCat() {
    }

    public SubCat(int subcategory_id, String name) {
        this.subcategory_id = subcategory_id;
        this.name = name;
    }

    public int getSubcategory_id() {
        return subcategory_id;
    }

    public void setSubcategory_id(int subcategory_id) {
        this.subcategory_id = subcategory_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
