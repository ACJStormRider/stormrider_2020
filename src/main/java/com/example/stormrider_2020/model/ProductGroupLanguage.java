package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_group_language", schema = "stormrider_25112020", catalog = "")
public class ProductGroupLanguage {
    private int productGroupLanguageId;
    private String appLanguageCode;
    private int productGroupId;
    private String productGroupName;
    private String productGroupDescription;

    @Id
    @Column(name = "product_group_language_id", nullable = false)
    public int getProductGroupLanguageId() {
        return productGroupLanguageId;
    }

    public void setProductGroupLanguageId(int productGroupLanguageId) {
        this.productGroupLanguageId = productGroupLanguageId;
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
    @Column(name = "product_group_id", nullable = false)
    public int getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(int productGroupId) {
        this.productGroupId = productGroupId;
    }

    @Basic
    @Column(name = "product_group_name", nullable = false, length = 100)
    public String getProductGroupName() {
        return productGroupName;
    }

    public void setProductGroupName(String productGroupName) {
        this.productGroupName = productGroupName;
    }

    @Basic
    @Column(name = "product_group_description", nullable = true, length = 500)
    public String getProductGroupDescription() {
        return productGroupDescription;
    }

    public void setProductGroupDescription(String productGroupDescription) {
        this.productGroupDescription = productGroupDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductGroupLanguage that = (ProductGroupLanguage) o;
        return productGroupLanguageId == that.productGroupLanguageId &&
                productGroupId == that.productGroupId &&
                Objects.equals(appLanguageCode, that.appLanguageCode) &&
                Objects.equals(productGroupName, that.productGroupName) &&
                Objects.equals(productGroupDescription, that.productGroupDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productGroupLanguageId, appLanguageCode, productGroupId, productGroupName, productGroupDescription);
    }
}
