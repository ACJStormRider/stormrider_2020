package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Subcategory {
    private int subCategoryId;
    private Collection<ProductGroupHasSubcategory> productGroupHasSubcategoriesBySubCategoryId;
    private Collection<SubcategoryHasCategory> subcategoryHasCategoriesBySubCategoryId;
    private Collection<SubcategoryLanguage> subcategoryLanguagesBySubCategoryId;
    private Collection<VoucherHasSubcategory> voucherHasSubcategoriesBySubCategoryId;

    @Id
    /**
     * M2M productgroup & subcategory
     * overwritten from generated class
     */
    /*@ManyToMany
    @JoinTable(
            name = "ProductGroupHasSubcategory",
            joinColumns = @JoinColumn(name = "subcategory_id"),,
            inverseJoinColumns = @JoinColumn(name = "product_group_id"))
    Set<ProductGroup> productGroups;*/

    //classes generated wrong

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

    @OneToMany(mappedBy = "subcategoryBySubcategoryId")
    public Collection<ProductGroupHasSubcategory> getProductGroupHasSubcategoriesBySubCategoryId() {
        return productGroupHasSubcategoriesBySubCategoryId;
    }

    public void setProductGroupHasSubcategoriesBySubCategoryId(Collection<ProductGroupHasSubcategory> productGroupHasSubcategoriesBySubCategoryId) {
        this.productGroupHasSubcategoriesBySubCategoryId = productGroupHasSubcategoriesBySubCategoryId;
    }

    @OneToMany(mappedBy = "subcategoryBySubcategoryId")
    public Collection<SubcategoryHasCategory> getSubcategoryHasCategoriesBySubCategoryId() {
        return subcategoryHasCategoriesBySubCategoryId;
    }

    public void setSubcategoryHasCategoriesBySubCategoryId(Collection<SubcategoryHasCategory> subcategoryHasCategoriesBySubCategoryId) {
        this.subcategoryHasCategoriesBySubCategoryId = subcategoryHasCategoriesBySubCategoryId;
    }

    @OneToMany(mappedBy = "subcategoryBySubcategoryId")
    public Collection<SubcategoryLanguage> getSubcategoryLanguagesBySubCategoryId() {
        return subcategoryLanguagesBySubCategoryId;
    }

    public void setSubcategoryLanguagesBySubCategoryId(Collection<SubcategoryLanguage> subcategoryLanguagesBySubCategoryId) {
        this.subcategoryLanguagesBySubCategoryId = subcategoryLanguagesBySubCategoryId;
    }

    @OneToMany(mappedBy = "subcategoryBySubcategoryId")
    public Collection<VoucherHasSubcategory> getVoucherHasSubcategoriesBySubCategoryId() {
        return voucherHasSubcategoriesBySubCategoryId;
    }

    public void setVoucherHasSubcategoriesBySubCategoryId(Collection<VoucherHasSubcategory> voucherHasSubcategoriesBySubCategoryId) {
        this.voucherHasSubcategoriesBySubCategoryId = voucherHasSubcategoriesBySubCategoryId;
    }
}
