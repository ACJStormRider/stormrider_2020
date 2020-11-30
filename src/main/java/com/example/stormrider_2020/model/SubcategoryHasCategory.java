package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subcategory_has_category", schema = "stormrider_25112020", catalog = "")
@IdClass(SubcategoryHasCategoryPK.class)
public class SubcategoryHasCategory {
    private int subcategoryId;
    private int categoryId;

    @Id
    @Column(name = "subcategory_id", nullable = false)
    public int getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(int subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    @Id
    @Column(name = "category_id", nullable = false)
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
        SubcategoryHasCategory that = (SubcategoryHasCategory) o;
        return subcategoryId == that.subcategoryId &&
                categoryId == that.categoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subcategoryId, categoryId);
    }
}
