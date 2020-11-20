package com.example.stormrider_2020.model;

import javax.persistence.*;

@Entity
@Table(name = "voucher_has_product", schema = "stormrider", catalog = "")
@IdClass(VoucherHasProductPK.class)
public class VoucherHasProduct {
    private int voucherId;
    private int productId;
    private Voucher voucherByVoucherId;
    private Product productByProductId;

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

    @ManyToOne
    @JoinColumn(name = "voucher_id", referencedColumnName = "voucher_id", nullable = false)
    public Voucher getVoucherByVoucherId() {
        return voucherByVoucherId;
    }

    public void setVoucherByVoucherId(Voucher voucherByVoucherId) {
        this.voucherByVoucherId = voucherByVoucherId;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }
}
