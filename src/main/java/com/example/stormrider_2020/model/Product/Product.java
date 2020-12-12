package com.example.stormrider_2020.model.Product;

import com.example.stormrider_2020.model.Variable.Variable;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "product", schema = "stormrider", catalog = "")
public class Product {

    private int productId;
    private short inventory;
    private int productGroupId;
    private Date lastUpdated;
    private Set<Long> variableIds;

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

    @Basic
    @Column(name = "last_updated", nullable = false)
    public Date getLastUpdated() {
        return lastUpdated;
    }
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @ElementCollection
    @CollectionTable(name="product_has_variable", joinColumns=@JoinColumn(name="product_id"))
    @Column(name="variable_id")
    public Set<Long> getVariableIds() {
        return variableIds;
    }
    public void setVariableIds(Set<Long> variableIds) {
        this.variableIds = variableIds;
    }

//==============================================================================================
//  METHODS
//==============================================================================================

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
