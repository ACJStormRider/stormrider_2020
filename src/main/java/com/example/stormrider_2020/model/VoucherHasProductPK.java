package com.example.stormrider_2020.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

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
        return voucherId == that.voucherId &&
                productId == that.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(voucherId, productId);
    }
}
