package com.example.stormrider_2020.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class VoucherHasProductGroupPK implements Serializable {
    private int voucherId;
    private int groupProductId;

    @Column(name = "voucher_id", nullable = false)
    @Id
    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    @Column(name = "group_product_id", nullable = false)
    @Id
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

        VoucherHasProductGroupPK that = (VoucherHasProductGroupPK) o;

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
}
