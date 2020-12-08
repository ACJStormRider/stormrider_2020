package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Subcategory {

    private int subCategoryId;
    Set<SubcategoryLanguage> subcategoryLanguage;
    Set<ProductGroup> productGroup;

//==============================================================================================
//  GETTERS & SETTERS
//==============================================================================================

    @Id
    @Column(name = "sub_category_id", nullable = false)
    public int getSubCategoryId() {
        return subCategoryId;
    }
    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    @OneToMany(mappedBy="subcategoryId")
    public Set<SubcategoryLanguage> getSubcategoryLanguage() {
        return subcategoryLanguage;
    }
    public void setSubcategoryLanguage(Set<SubcategoryLanguage> subcategoryLanguage) {
        this.subcategoryLanguage = subcategoryLanguage;
    }

    @ManyToMany
    @JoinTable(
            name = "product_group_has_subcategory",
            joinColumns = @JoinColumn(name = "subcategory_id"),
            inverseJoinColumns = @JoinColumn(name = "product_group_id"))
    public Set<ProductGroup> getProductGroup() {
        return productGroup;
    }
    public void setProductGroup(Set<ProductGroup> productGroup) {
        this.productGroup = productGroup;
    }

//==============================================================================================
//  METHODS
//==============================================================================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subcategory that = (Subcategory) o;
        return subCategoryId == that.subCategoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subCategoryId);
    }
}
