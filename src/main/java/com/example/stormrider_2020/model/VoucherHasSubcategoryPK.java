package com.example.stormrider_2020.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class VoucherHasSubcategoryPK implements Serializable {
    private int voucherId;
    private int subcategoryId;

    @Column(name = "voucher_id", nullable = false)
    @Id
    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    @Column(name = "subcategory_id", nullable = false)
    @Id
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

        VoucherHasSubcategoryPK that = (VoucherHasSubcategoryPK) o;

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
}
