package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "voucher_has_product", schema = "stormrider_25112020", catalog = "")
@IdClass(VoucherHasProductPK.class)
public class VoucherHasProduct {
    private int voucherId;
    private int productId;

    @Id
    @Column(name = "voucher_id", nullable = false)
    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    @Id
    @Column(name = "product_id", nullable = false)
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
        VoucherHasProduct that = (VoucherHasProduct) o;
        return voucherId == that.voucherId &&
                productId == that.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(voucherId, productId);
    }
}
