package com.example.stormrider_2020.model.Subcategory;

import com.example.stormrider_2020.model.Category.Category;
import com.example.stormrider_2020.model.ProductGroup.ProductGroup;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "subcategory", schema = "stormrider", catalog = "")
public class Subcategory {

    private int subcategoryId;
    private Set<SubcategoryLanguage> subcategoryLanguages;
    private Set<Long> categoryIds;
    private Set<Long> productGroupIds;

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
    public Set<SubcategoryLanguage> getSubcategoryLanguages() {
        return subcategoryLanguages;
    }
    public void setSubcategoryLanguages(Set<SubcategoryLanguage> subcategoryLanguages) {
        this.subcategoryLanguages = subcategoryLanguages;
    }

    @ElementCollection
    @CollectionTable(name="subcategory_has_category", joinColumns=@JoinColumn(name="subcategory_id"))
    @Column(name="category_id")
    public Set<Long> getCategoryIds() {
        return categoryIds;
    }
    public void setCategoryIds(Set<Long> categoryIds) {
        this.categoryIds = categoryIds;
    }

    @ElementCollection
    @CollectionTable(name="product_group_has_subcategory", joinColumns=@JoinColumn(name="subcategory_id"))
    @Column(name="product_group_id")
    public Set<Long> getProductGroupIds() {
        return productGroupIds;
    }
    public void setProductGroupIds(Set<Long> productGroupIds) {
        this.productGroupIds = productGroupIds;
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
