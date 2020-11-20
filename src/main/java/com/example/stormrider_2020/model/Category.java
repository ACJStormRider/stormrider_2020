package com.example.stormrider_2020.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Category {
    private int categoryId;
    private Collection<CategoryLanguage> categoryLanguagesByCategoryId;
    private Collection<SubcategoryHasCategory> subcategoryHasCategoriesByCategoryId;
    private Collection<VoucherHasCategory> voucherHasCategoriesByCategoryId;

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

        Category category = (Category) o;

        if (categoryId != category.categoryId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return categoryId;
    }

    @OneToMany(mappedBy = "categoryByCategoryId")
    public Collection<CategoryLanguage> getCategoryLanguagesByCategoryId() {
        return categoryLanguagesByCategoryId;
    }

    public void setCategoryLanguagesByCategoryId(Collection<CategoryLanguage> categoryLanguagesByCategoryId) {
        this.categoryLanguagesByCategoryId = categoryLanguagesByCategoryId;
    }

    @OneToMany(mappedBy = "categoryByCategoryId")
    public Collection<SubcategoryHasCategory> getSubcategoryHasCategoriesByCategoryId() {
        return subcategoryHasCategoriesByCategoryId;
    }

    public void setSubcategoryHasCategoriesByCategoryId(Collection<SubcategoryHasCategory> subcategoryHasCategoriesByCategoryId) {
        this.subcategoryHasCategoriesByCategoryId = subcategoryHasCategoriesByCategoryId;
    }

    @OneToMany(mappedBy = "categoryByCategoryId")
    public Collection<VoucherHasCategory> getVoucherHasCategoriesByCategoryId() {
        return voucherHasCategoriesByCategoryId;
    }

    public void setVoucherHasCategoriesByCategoryId(Collection<VoucherHasCategory> voucherHasCategoriesByCategoryId) {
        this.voucherHasCategoriesByCategoryId = voucherHasCategoriesByCategoryId;
    }
}
