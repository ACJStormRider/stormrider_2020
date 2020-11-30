package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subcategory_language", schema = "stormrider_25112020", catalog = "")
public class SubcategoryLanguage {
    private int categoryLanguageId;
    private String appLanguageCode;
    private int subcategoryId;
    private String name;

    @Id
    @Column(name = "category_language_id", nullable = false)
    public int getCategoryLanguageId() {
        return categoryLanguageId;
    }

    public void setCategoryLanguageId(int categoryLanguageId) {
        this.categoryLanguageId = categoryLanguageId;
    }

    @Basic
    @Column(name = "app_language_code", nullable = false, length = 2)
    public String getAppLanguageCode() {
        return appLanguageCode;
    }

    public void setAppLanguageCode(String appLanguageCode) {
        this.appLanguageCode = appLanguageCode;
    }

    @Basic
    @Column(name = "subcategory_id", nullable = false)
    public int getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(int subcategoryId) {
        this.subcategoryId = subcategoryId;
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
        return categoryLanguageId == that.categoryLanguageId &&
                subcategoryId == that.subcategoryId &&
                Objects.equals(appLanguageCode, that.appLanguageCode) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryLanguageId, appLanguageCode, subcategoryId, name);
    }
}
