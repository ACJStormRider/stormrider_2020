package com.example.stormrider_2020.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Product {
    private int productId;
    private short inventory;
    private int productGroupId;
    private Date lastUpdated;

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

    @Basic
    @Column(name = "last_updated", nullable = false)
    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productId != product.productId) return false;
        if (inventory != product.inventory) return false;
        if (productGroupId != product.productGroupId) return false;
        if (lastUpdated != null ? !lastUpdated.equals(product.lastUpdated) : product.lastUpdated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + (int) inventory;
        result = 31 * result + productGroupId;
        result = 31 * result + (lastUpdated != null ? lastUpdated.hashCode() : 0);
        return result;
    }
}
