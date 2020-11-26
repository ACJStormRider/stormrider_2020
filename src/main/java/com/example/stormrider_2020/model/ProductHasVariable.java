package com.example.stormrider_2020.model;

import javax.persistence.*;

@Entity
@Table(name = "product_has_variable", schema = "stormrider_25112020", catalog = "")
public class ProductHasVariable {
    private int productHasVariableId;
    private int productId;
    private int variableId;

    @Id
    @Column(name = "product_has_variable_id", nullable = false)
    public int getProductHasVariableId() {
        return productHasVariableId;
    }

    public void setProductHasVariableId(int productHasVariableId) {
        this.productHasVariableId = productHasVariableId;
    }

    @Basic
    @Column(name = "product_id", nullable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "variable_id", nullable = false)
    public int getVariableId() {
        return variableId;
    }

    public void setVariableId(int variableId) {
        this.variableId = variableId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductHasVariable that = (ProductHasVariable) o;

        if (productHasVariableId != that.productHasVariableId) return false;
        if (productId != that.productId) return false;
        if (variableId != that.variableId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productHasVariableId;
        result = 31 * result + productId;
        result = 31 * result + variableId;
        return result;
    }
}
