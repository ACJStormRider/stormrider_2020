package com.example.stormrider_2020.model;

import javax.persistence.*;

@Entity
@Table(name = "product_group_has_subcategory", schema = "stormrider_25112020", catalog = "")
@IdClass(ProductGroupHasSubcategoryPK.class)
public class ProductGroupHasSubcategory {
    private int productGroupId;
    private int subcategoryId;

    @Id
    @Column(name = "product_group_id", nullable = false)
    public int getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(int productGroupId) {
        this.productGroupId = productGroupId;
    }

    @Id
    @Column(name = "subcategory_id", nullable = false)
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

        ProductGroupHasSubcategory that = (ProductGroupHasSubcategory) o;

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
