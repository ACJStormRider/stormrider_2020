package com.example.stormrider_2020.model;

import javax.persistence.*;

@Entity
@Table(name = "subcategory_language", schema = "stormrider", catalog = "")
public class SubcategoryLanguage {
    private int categoryLanguageId;
    private String name;
    private AppLanguage appLanguageByAppLanguageCode;
    private Subcategory subcategoryBySubcategoryId;

    @Id
    @Column(name = "category_language_id", nullable = false)
    public int getCategoryLanguageId() {
        return categoryLanguageId;
    }

    public void setCategoryLanguageId(int categoryLanguageId) {
        this.categoryLanguageId = categoryLanguageId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubcategoryLanguage that = (SubcategoryLanguage) o;

        if (categoryLanguageId != that.categoryLanguageId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryLanguageId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "app_language_code", referencedColumnName = "code", nullable = false)
    public AppLanguage getAppLanguageByAppLanguageCode() {
        return appLanguageByAppLanguageCode;
    }

    public void setAppLanguageByAppLanguageCode(AppLanguage appLanguageByAppLanguageCode) {
        this.appLanguageByAppLanguageCode = appLanguageByAppLanguageCode;
    }

    @ManyToOne
    @JoinColumn(name = "subcategory_id", referencedColumnName = "sub_category_id", nullable = false)
    public Subcategory getSubcategoryBySubcategoryId() {
        return subcategoryBySubcategoryId;
    }

    public void setSubcategoryBySubcategoryId(Subcategory subcategoryBySubcategoryId) {
        this.subcategoryBySubcategoryId = subcategoryBySubcategoryId;
    }
}
