package com.example.stormrider_2020.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ProductGroupHasSubcategoryPK implements Serializable {
    private int productGroupId;
    private int subcategoryId;

    @Column(name = "product_group_id", nullable = false)
    @Id
    public int getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(int productGroupId) {
        this.productGroupId = productGroupId;
    }

    @Column(name = "subcategory_id", nullable = false)
    @Id
    public int getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(int subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductGroupHasSubcategoryPK that = (ProductGroupHasSubcategoryPK) o;

        if (productGroupId != that.productGroupId) return false;
        if (subcategoryId != that.subcategoryId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productGroupId;
        result = 31 * result + subcategoryId;
        return result;
    }
}
