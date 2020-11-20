package com.example.stormrider_2020.model;

import javax.persistence.*;

@Entity
@Table(name = "product_group_language", schema = "stormrider", catalog = "")
public class ProductGroupLanguage {
    private int productGroupLanguageId;
    private String productGroupName;
    private String productGroupDescription;
    private AppLanguage appLanguageByAppLanguageCode;
    private ProductGroup productGroupByProductGroupId;

    @Id
    @Column(name = "product_group_language_id", nullable = false)
    public int getProductGroupLanguageId() {
        return productGroupLanguageId;
    }

    public void setProductGroupLanguageId(int productGroupLanguageId) {
        this.productGroupLanguageId = productGroupLanguageId;
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

        if (productGroupLanguageId != that.productGroupLanguageId) return false;
        if (productGroupName != null ? !productGroupName.equals(that.productGroupName) : that.productGroupName != null)
            return false;
        if (productGroupDescription != null ? !productGroupDescription.equals(that.productGroupDescription) : that.productGroupDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productGroupLanguageId;
        result = 31 * result + (productGroupName != null ? productGroupName.hashCode() : 0);
        result = 31 * result + (productGroupDescription != null ? productGroupDescription.hashCode() : 0);
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
    @JoinColumn(name = "product_group_id", referencedColumnName = "product_group_id", nullable = false)
    public ProductGroup getProductGroupByProductGroupId() {
        return productGroupByProductGroupId;
    }

    public void setProductGroupByProductGroupId(ProductGroup productGroupByProductGroupId) {
        this.productGroupByProductGroupId = productGroupByProductGroupId;
    }
}
