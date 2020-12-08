package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class Product {

    private int productId;
    private short inventory;
    private int productGroupId;
    Set<GenderLanguage> gender;
    Set<FillingLanguage> filling;
    Set<ColorLanguage> color;
    Set<SizeLanguage> size;
    private Date lastUpdated;

//==============================================================================================
//  GETTERS & SETTERS
//==============================================================================================

    @Id
    @Column(name = "product_id", nullable = false)
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "inventory", nullable = false)
    public short getInventory() {
        return inventory;
    }
    public void setInventory(short inventory) {
        this.inventory = inventory;
    }

    @Basic
    @Column(name = "product_group_id", nullable = false)
    public int getProductGroupId() {
        return productGroupId;
    }
    public void setProductGroupId(int productGroupId) {
        this.productGroupId = productGroupId;
    }

    @OneToMany(mappedBy="genderId")
    public Set<GenderLanguage> getGender() {
        return gender;
    }
    public void setGender(Set<GenderLanguage> gender) {
        this.gender = gender;
    }

    @OneToMany(mappedBy="fillingId")
    public Set<FillingLanguage> getFilling() {
        return filling;
    }
    public void setFilling(Set<FillingLanguage> filling) {
        this.filling = filling;
    }

    @OneToMany(mappedBy="colorId")
    public Set<ColorLanguage> getColor() {
        return color;
    }
    public void setColor(Set<ColorLanguage> color) {
        this.color = color;
    }

    @OneToMany(mappedBy="sizeId")
    public Set<SizeLanguage> getSize() {
        return size;
    }
    public void setSize(Set<SizeLanguage> size) {
        this.size = size;
    }

    @Basic
    @Column(name = "last_updated", nullable = false)
    public Date getLastUpdated() {
        return lastUpdated;
    }
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

//==============================================================================================
//  METHODS
//==============================================================================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId &&
                inventory == product.inventory &&
                Objects.equals(lastUpdated, product.lastUpdated);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
