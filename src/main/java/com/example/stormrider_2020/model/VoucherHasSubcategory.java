package com.example.stormrider_2020.model;

import javax.persistence.*;

@Entity
@Table(name = "voucher_has_subcategory", schema = "stormrider", catalog = "")
@IdClass(VoucherHasSubcategoryPK.class)
public class VoucherHasSubcategory {
    private int voucherId;
    private int subcategoryId;
    private Voucher voucherByVoucherId;
    private Subcategory subcategoryBySubcategoryId;

    @Id
    @Column(name = "voucher_id", nullable = false)
    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    @Id
    @Column(name = "subcategory_id", nullable = false)
    public int getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(int subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VoucherHasSubcategory that = (VoucherHasSubcategory) o;

        if (voucherId != that.voucherId) return false;
        if (subcategoryId != that.subcategoryId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = voucherId;
        result = 31 * result + subcategoryId;
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
    @JoinColumn(name = "subcategory_id", referencedColumnName = "sub_category_id", nullable = false)
    public Subcategory getSubcategoryBySubcategoryId() {
        return subcategoryBySubcategoryId;
    }

    public void setSubcategoryBySubcategoryId(Subcategory subcategoryBySubcategoryId) {
        this.subcategoryBySubcategoryId = subcategoryBySubcategoryId;
    }
}
