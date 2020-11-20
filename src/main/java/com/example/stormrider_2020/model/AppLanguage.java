package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "app_language", schema = "stormrider", catalog = "")
public class AppLanguage {
    private String code;
    private String language;
    private Collection<CategoryLanguage> categoryLanguagesByCode;
    private Collection<ColorLanguage> colorLanguagesByCode;
    private Collection<FillingLanguage> fillingLanguagesByCode;
    private Collection<GenderLanguage> genderLanguagesByCode;
    private Collection<ProductGroupLanguage> productGroupLanguagesByCode;
    private Collection<SizeLanguage> sizeLanguagesByCode;
    private Collection<SubcategoryLanguage> subcategoryLanguagesByCode;

    @Id
    @Column(name = "code", nullable = false, length = 2)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "language", nullable = true, length = 20)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppLanguage that = (AppLanguage) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "appLanguageByAppLanguageCode")
    public Collection<CategoryLanguage> getCategoryLanguagesByCode() {
        return categoryLanguagesByCode;
    }

    public void setCategoryLanguagesByCode(Collection<CategoryLanguage> categoryLanguagesByCode) {
        this.categoryLanguagesByCode = categoryLanguagesByCode;
    }

    @OneToMany(mappedBy = "appLanguageByAppLanguageCode")
    public Collection<ColorLanguage> getColorLanguagesByCode() {
        return colorLanguagesByCode;
    }

    public void setColorLanguagesByCode(Collection<ColorLanguage> colorLanguagesByCode) {
        this.colorLanguagesByCode = colorLanguagesByCode;
    }

    @OneToMany(mappedBy = "appLanguageByAppLanguageCode")
    public Collection<FillingLanguage> getFillingLanguagesByCode() {
        return fillingLanguagesByCode;
    }

    public void setFillingLanguagesByCode(Collection<FillingLanguage> fillingLanguagesByCode) {
        this.fillingLanguagesByCode = fillingLanguagesByCode;
    }

    @OneToMany(mappedBy = "appLanguageByAppLanguageCode")
    public Collection<GenderLanguage> getGenderLanguagesByCode() {
        return genderLanguagesByCode;
    }

    public void setGenderLanguagesByCode(Collection<GenderLanguage> genderLanguagesByCode) {
        this.genderLanguagesByCode = genderLanguagesByCode;
    }

    @OneToMany(mappedBy = "appLanguageByAppLanguageCode")
    public Collection<ProductGroupLanguage> getProductGroupLanguagesByCode() {
        return productGroupLanguagesByCode;
    }

    public void setProductGroupLanguagesByCode(Collection<ProductGroupLanguage> productGroupLanguagesByCode) {
        this.productGroupLanguagesByCode = productGroupLanguagesByCode;
    }

    @OneToMany(mappedBy = "appLanguageByAppLanguageCode")
    public Collection<SizeLanguage> getSizeLanguagesByCode() {
        return sizeLanguagesByCode;
    }

    public void setSizeLanguagesByCode(Collection<SizeLanguage> sizeLanguagesByCode) {
        this.sizeLanguagesByCode = sizeLanguagesByCode;
    }

    @OneToMany(mappedBy = "appLanguageByAppLanguageCode")
    public Collection<SubcategoryLanguage> getSubcategoryLanguagesByCode() {
        return subcategoryLanguagesByCode;
    }

    public void setSubcategoryLanguagesByCode(Collection<SubcategoryLanguage> subcategoryLanguagesByCode) {
        this.subcategoryLanguagesByCode = subcategoryLanguagesByCode;
    }
}
