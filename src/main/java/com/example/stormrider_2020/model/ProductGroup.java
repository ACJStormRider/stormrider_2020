package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "product_group", schema = "stormrider", catalog = "")
public class ProductGroup {

    private int productGroupId;
    private double basePrice;
    private double vat;
    Set<ProductGroupLanguage> productGroupLanguage;
    Set<Product> products;

//==============================================================================================
//  GETTERS & SETTERS
//==============================================================================================

    @Id
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

    @OneToMany(mappedBy="productGroupId")
    public Set<Product> getProducts() {
        return products;
    }
    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @OneToMany(mappedBy="productGroupId")
    public Set<ProductGroupLanguage> getProductGroupLanguage() {
        return productGroupLanguage;
    }
    public void setProductGroupLanguage(Set<ProductGroupLanguage> productGroupLanguage) {
        this.productGroupLanguage = productGroupLanguage;
    }

//==============================================================================================
//  METHODS
//==============================================================================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductGroup that = (ProductGroup) o;
        return productGroupId == that.productGroupId &&
                Double.compare(that.basePrice, basePrice) == 0 &&
                Double.compare(that.vat, vat) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productGroupId, basePrice, vat);
    }

}
