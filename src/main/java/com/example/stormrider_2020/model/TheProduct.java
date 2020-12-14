package com.example.stormrider_2020.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;


public class TheProduct {

    private int id;
    private double price;
    private double vat;
    //private List<ProductImage> images = new ArrayList<>();


    public TheProduct(int id, double price, double vat) {
        this.id = id;
        this.price = price;
        this.vat = vat;
        //this.images = images;
    }

    public TheProduct() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }
/*
    public List<ProductImage> getImages() {
        return images;
    }

    public void setImages(List<ProductImage> images) {
        this.images = images;
    }

 */
}
