package com.example.stormrider_2020.model;

import javax.persistence.*;

@Entity
@Table(name = "voucher_has_product_group", schema = "stormrider", catalog = "")
@IdClass(VoucherHasProductGroupPK.class)
public class VoucherHasProductGroup {
    private int voucherId;
    private int groupProductId;
    private Voucher voucherByVoucherId;
    private ProductGroup productGroupByGroupProductId;

    @Id
    @Column(name = "voucher_id", nullable = false)
    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    @Id
    @Column(name = "group_product_id", nullable = false)
    public int getGroupProductId() {
        return groupProductId;
    }

    public void setGroupProductId(int groupProductId) {
        this.groupProductId = groupProductId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VoucherHasProductGroup that = (VoucherHasProductGroup) o;

        if (voucherId != that.voucherId) return false;
        if (groupProductId != that.groupProductId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = voucherId;
        result = 31 * result + groupProductId;
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
    @JoinColumn(name = "group_product_id", referencedColumnName = "product_group_id", nullable = false)
    public ProductGroup getProductGroupByGroupProductId() {
        return productGroupByGroupProductId;
    }

    public void setProductGroupByGroupProductId(ProductGroup productGroupByGroupProductId) {
        this.productGroupByGroupProductId = productGroupByGroupProductId;
    }
}
