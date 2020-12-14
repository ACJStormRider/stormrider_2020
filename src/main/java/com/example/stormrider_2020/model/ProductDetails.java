package com.example.stormrider_2020.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class ProductDetails {

    @Id
    private int productId;
    private int inventory;
    private int productGroupId;
    private LocalDate lastUpdated;
    private int variableId;
    private int variableTypeId;
    private String variableName;
    private String variableTypeName;

    public ProductDetails() {
    }

    public ProductDetails(int productId, int inventory, int productGroupId, LocalDate lastUpdated, int variableId, int variableTypeId, String variableName, String variableTypeName) {
        this.productId = productId;
        this.inventory = inventory;
        this.productGroupId = productGroupId;
        this.lastUpdated = lastUpdated;
        this.variableId = variableId;
        this.variableTypeId = variableTypeId;
        this.variableName = variableName;
        this.variableTypeName = variableTypeName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(int productGroupId) {
        this.productGroupId = productGroupId;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getVariableId() {
        return variableId;
    }

    public void setVariableId(int variableId) {
        this.variableId = variableId;
    }

    public int getVariableTypeId() {
        return variableTypeId;
    }

    public void setVariableTypeId(int variableTypeId) {
        this.variableTypeId = variableTypeId;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getVariableTypeName() {
        return variableTypeName;
    }

    public void setVariableTypeName(String variableTypeName) {
        this.variableTypeName = variableTypeName;
    }
}
