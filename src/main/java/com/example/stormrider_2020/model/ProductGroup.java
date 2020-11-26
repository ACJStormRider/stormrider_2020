package com.example.stormrider_2020.model;

import javax.persistence.*;

@Entity
@Table(name = "product_group", schema = "stormrider_25112020", catalog = "")
public class ProductGroup {
    private int productGroupId;
    private double basePrice;
    private double vat;

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
}
