package com.example.stormrider_2020.model.Category;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category", schema = "stormrider", catalog = "")
public class Category {

    private int categoryId;
    private Set<CategoryLanguage> categoryLanguages;
    private Set<Long> subcategoryIds;

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
    public Set<CategoryLanguage> getCategoryLanguages() {
        return categoryLanguages;
    }
    public void setCategoryLanguages(Set<CategoryLanguage> categoryLanguages) {
        this.categoryLanguages = categoryLanguages;
    }

    @ElementCollection
    @CollectionTable(name="subcategory_has_category", joinColumns=@JoinColumn(name="category_id"))
    @Column(name="subcategory_id")
    public Set<Long> getSubcategoryIds() {
        return subcategoryIds;
    }
    public void setSubcategoryIds(Set<Long> subcategoryIds) {
        this.subcategoryIds = subcategoryIds;
    }

//==============================================================================================
//  METHODS
//==============================================================================================

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
