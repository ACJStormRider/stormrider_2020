package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product_group", schema = "stormrider", catalog = "")
public class ProductGroup {
    private int productGroupId;
    private double basePrice;
    private double vat;
    private Collection<Product> productsByProductGroupId;

    private Collection<ProductGroupHasSubcategory> productGroupHasSubcategoriesByProductGroupId;
    private Collection<ProductGroupLanguage> productGroupLanguagesByProductGroupId;
    private Collection<ProductImage> productImagesByProductGroupId;
    private Collection<VoucherHasProductGroup> voucherHasProductGroupsByProductGroupId;

    @Id
    /**
     * M2M productgroup & subcategory
     * overwritten from generated class
     */
    /*@ManyToMany
    @JoinTable(
            name = "ProductGroupHasSubcategory",
            joinColumns = @JoinColumn(name = "product_group_id"),,
            inverseJoinColumns = @JoinColumn(name = "subcategory_id"))
    Set<Subcategory> subcategories;*/

    @Column(name = "product_group_id", nullable = false)
    public int getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(int productGroupId) {
        this.productGroupId = productGroupId;
    }

    @Basic
    @Column(name = "base_price", nullable = false, precision = 0)
    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    @Basic
    @Column(name = "vat", nullable = false, precision = 0)
    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductGroup that = (ProductGroup) o;

        if (productGroupId != that.productGroupId) return false;
        if (Double.compare(that.basePrice, basePrice) != 0) return false;
        if (Double.compare(that.vat, vat) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productGroupId;
        temp = Double.doubleToLongBits(basePrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(vat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "productGroupByProductGroupId")
    public Collection<Product> getProductsByProductGroupId() {
        return productsByProductGroupId;
    }

    public void setProductsByProductGroupId(Collection<Product> productsByProductGroupId) {
        this.productsByProductGroupId = productsByProductGroupId;
    }
/*
    @OneToMany(mappedBy = "productGroupByProductGroupId")
    public Collection<ProductGroupHasSubcategory> getProductGroupHasSubcategoriesByProductGroupId() {
        return productGroupHasSubcategoriesByProductGroupId;
    }
*/
    public void setProductGroupHasSubcategoriesByProductGroupId(Collection<ProductGroupHasSubcategory> productGroupHasSubcategoriesByProductGroupId) {
        this.productGroupHasSubcategoriesByProductGroupId = productGroupHasSubcategoriesByProductGroupId;
    }

    @OneToMany(mappedBy = "productGroupByProductGroupId")
    public Collection<ProductGroupLanguage> getProductGroupLanguagesByProductGroupId() {
        return productGroupLanguagesByProductGroupId;
    }

    public void setProductGroupLanguagesByProductGroupId(Collection<ProductGroupLanguage> productGroupLanguagesByProductGroupId) {
        this.productGroupLanguagesByProductGroupId = productGroupLanguagesByProductGroupId;
    }

    @OneToMany(mappedBy = "productGroupByProductGroupId")
    public Collection<ProductImage> getProductImagesByProductGroupId() {
        return productImagesByProductGroupId;
    }

    public void setProductImagesByProductGroupId(Collection<ProductImage> productImagesByProductGroupId) {
        this.productImagesByProductGroupId = productImagesByProductGroupId;
    }

    @OneToMany(mappedBy = "productGroupByGroupProductId")
    public Collection<VoucherHasProductGroup> getVoucherHasProductGroupsByProductGroupId() {
        return voucherHasProductGroupsByProductGroupId;
    }

    public void setVoucherHasProductGroupsByProductGroupId(Collection<VoucherHasProductGroup> voucherHasProductGroupsByProductGroupId) {
        this.voucherHasProductGroupsByProductGroupId = voucherHasProductGroupsByProductGroupId;
    }

}
