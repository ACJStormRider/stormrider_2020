package com.example.stormrider_2020.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SubcategoryHasCategoryPK implements Serializable {
    private int subcategoryId;
    private int categoryId;

    @Column(name = "subcategory_id", nullable = false)
    @Id
    public int getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(int subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    @Column(name = "category_id", nullable = false)
    @Id
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubcategoryHasCategoryPK that = (SubcategoryHasCategoryPK) o;

        if (subcategoryId != that.subcategoryId) return false;
        if (categoryId != that.categoryId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subcategoryId;
        result = 31 * result + categoryId;
        return result;
    }
}
