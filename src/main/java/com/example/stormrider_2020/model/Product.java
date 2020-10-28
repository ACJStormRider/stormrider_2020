package com.example.stormrider_2020.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    private int productId;
    private int inventory;
    private Double discountAmount;
    private Double discountPercentage;
    private String gender;
    private int productGroupId;
    private int fillingId;
    private int colorId;
    private int sizeId;

    @Id
    @Column(name = "product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "inventory")
    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Basic
    @Column(name = "discount_amount")
    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Basic
    @Column(name = "discount_percentage")
    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "product_group_id")
    public int getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(int productGroupId) {
        this.productGroupId = productGroupId;
    }

    @Basic
    @Column(name = "filling_id")
    public int getFillingId() {
        return fillingId;
    }

    public void setFillingId(int fillingId) {
        this.fillingId = fillingId;
    }

    @Basic
    @Column(name = "color_id")
    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    @Basic
    @Column(name = "size_id")
    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productId != product.productId) return false;
        if (inventory != product.inventory) return false;
        if (productGroupId != product.productGroupId) return false;
        if (fillingId != product.fillingId) return false;
        if (colorId != product.colorId) return false;
        if (sizeId != product.sizeId) return false;
        if (discountAmount != null ? !discountAmount.equals(product.discountAmount) : product.discountAmount != null)
            return false;
        if (discountPercentage != null ? !discountPercentage.equals(product.discountPercentage) : product.discountPercentage != null)
            return false;
        if (gender != null ? !gender.equals(product.gender) : product.gender != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + (int) inventory;
        result = 31 * result + (discountAmount != null ? discountAmount.hashCode() : 0);
        result = 31 * result + (discountPercentage != null ? discountPercentage.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + productGroupId;
        result = 31 * result + fillingId;
        result = 31 * result + colorId;
        result = 31 * result + sizeId;
        return result;
    }
}
