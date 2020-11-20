package com.example.stormrider_2020.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class VoucherHasCategoryPK implements Serializable {
    private int voucherId;
    private int categoryId;

    @Column(name = "voucher_id", nullable = false)
    @Id
    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    @Column(name = "category_id", nullable = false)
    @Id
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

        VoucherHasCategoryPK that = (VoucherHasCategoryPK) o;

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
}
