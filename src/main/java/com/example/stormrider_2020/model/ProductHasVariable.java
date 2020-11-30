package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.util.Objects;

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
        return productHasVariableId == that.productHasVariableId &&
                productId == that.productId &&
                variableId == that.variableId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productHasVariableId, productId, variableId);
    }
}
