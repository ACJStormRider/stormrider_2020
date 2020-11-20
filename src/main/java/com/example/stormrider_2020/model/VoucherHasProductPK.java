package com.example.stormrider_2020.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class VoucherHasProductPK implements Serializable {
    private int voucherId;
    private int productId;

    @Column(name = "voucher_id", nullable = false)
    @Id
    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    @Column(name = "product_id", nullable = false)
    @Id
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VoucherHasProductPK that = (VoucherHasProductPK) o;

        if (voucherId != that.voucherId) return false;
        if (productId != that.productId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = voucherId;
        result = 31 * result + productId;
        return result;
    }
}
