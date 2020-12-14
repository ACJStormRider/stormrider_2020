package com.example.stormrider_2020.model;


import java.util.List;

public class TesterProduct {

    private int id;
    private String name;
    private List<TheProduct> products;

    public TesterProduct(int id, String name, List<TheProduct> products) {
        this.id = id;
        this.name = name;
        this.products = products;
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

    public List<TheProduct> getProducts() {
        return products;
    }

    public void setProducts(List<TheProduct> products) {
        this.products = products;
    }
}
