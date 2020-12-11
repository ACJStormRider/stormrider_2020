package com.example.stormrider_2020.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Category {

    private int categoryId;
    Set<CategoryLanguage> categoryLanguage;
    Set<Subcategory> subcategory;

//==============================================================================================
//  GETTERS & SETTERS
//==============================================================================================

    @Id
    @Column(name = "category_id", nullable = false)
    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @OneToMany(mappedBy="categoryId")
    public Set<CategoryLanguage> getCategoryLanguage() {
        return categoryLanguage;
    }
    public void setCategoryLanguage(Set<CategoryLanguage> categoryLanguage) {
        this.categoryLanguage = categoryLanguage;
    }

    @ManyToMany
    @JoinTable(
            name = "subcategory_has_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "subcategory_id"))
    public Set<Subcategory> getSubcategory() {
        return subcategory;
    }
    public void setSubcategory(Set<Subcategory> subcategory) {
        this.subcategory = subcategory;
    }

//==============================================================================================
//  METHODS
//==============================================================================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return categoryId == category.categoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId);
    }
}
