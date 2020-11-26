package com.example.stormrider_2020.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subcategory {
    private int subCategoryId;

    @Id
    @Column(name = "sub_category_id", nullable = false)
    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subcategory that = (Subcategory) o;

        if (subCategoryId != that.subCategoryId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return subCategoryId;
    }
}
