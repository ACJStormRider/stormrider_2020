package com.example.stormrider_2020.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductCard {

    @Id
    private int productGroupId;
    private String productGroupName;
    private double totalPrice;
    private String img;

    public ProductCard() {
    }


    public ProductCard(int productGroupId, String productGroupName, double totalPrice, String img) {
        this.productGroupId = productGroupId;
        this.productGroupName = productGroupName;
        this.totalPrice = totalPrice;
        this.img = img;
    }

    public int getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(int productGroupId) {
        this.productGroupId = productGroupId;
    }

    public String getProductGroupName() {
        return productGroupName;
    }

    public void setProductGroupName(String productGroupName) {
        this.productGroupName = productGroupName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
