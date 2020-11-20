package com.example.stormrider_2020.model;

import javax.persistence.*;

@Entity
@Table(name = "voucher_has_category", schema = "stormrider", catalog = "")
@IdClass(VoucherHasCategoryPK.class)
public class VoucherHasCategory {
    private int voucherId;
    private int categoryId;
    private Voucher voucherByVoucherId;
    private Category categoryByCategoryId;

    @Id
    @Column(name = "voucher_id", nullable = false)
    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    @Id
    @Column(name = "category_id", nullable = false)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VoucherHasCategory that = (VoucherHasCategory) o;

        if (voucherId != that.voucherId) return false;
        if (categoryId != that.categoryId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = voucherId;
        result = 31 * result + categoryId;
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
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    public Category getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }
}
