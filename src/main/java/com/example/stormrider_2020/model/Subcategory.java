package com.example.stormrider_2020.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Subcategory {

    private int subcategoryId;
    Set<SubcategoryLanguage> subcategoryLanguage;
    Set<ProductGroup> productGroup;
    Set<Category> category;

//==============================================================================================
//  GETTERS & SETTERS
//==============================================================================================

    @Id
    @Column(name = "subcategory_id", nullable = false)
    public int getSubcategoryId() {
        return subcategoryId;
    }
    public void setSubcategoryId(int subcategoryId) {
        this.subcategoryId = subcategoryId;
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

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "subcategory_has_category",
            joinColumns = @JoinColumn(name = "subcategory_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    public Set<Category> getCategory() {
        return category;
    }
    public void setCategory(Set<Category> category) {
        this.category = category;
    }

    //==============================================================================================
//  METHODS
//==============================================================================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subcategory that = (Subcategory) o;
        return subcategoryId == that.subcategoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subcategoryId);
    }
}
