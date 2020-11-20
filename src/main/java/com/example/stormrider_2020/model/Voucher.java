package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Voucher {
    private int voucherId;
    private String redeemCode;
    private Date validFrom;
    private Date validUntil;
    private Integer timesUsed;
    private Integer maxTimesUsed;
    private byte active;
    private String comment;
    private Double discount;
    private Collection<VoucherHasCategory> voucherHasCategoriesByVoucherId;
    private Collection<VoucherHasProduct> voucherHasProductsByVoucherId;
    private Collection<VoucherHasProductGroup> voucherHasProductGroupsByVoucherId;
    private Collection<VoucherHasSubcategory> voucherHasSubcategoriesByVoucherId;

    @Id
    @Column(name = "voucher_id", nullable = false)
    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    @Basic
    @Column(name = "redeem_code", nullable = true, length = 25)
    public String getRedeemCode() {
        return redeemCode;
    }

    public void setRedeemCode(String redeemCode) {
        this.redeemCode = redeemCode;
    }

    @Basic
    @Column(name = "valid_from", nullable = true)
    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    @Basic
    @Column(name = "valid_until", nullable = true)
    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    @Basic
    @Column(name = "times_used", nullable = true)
    public Integer getTimesUsed() {
        return timesUsed;
    }

    public void setTimesUsed(Integer timesUsed) {
        this.timesUsed = timesUsed;
    }

    @Basic
    @Column(name = "max_times_used", nullable = true)
    public Integer getMaxTimesUsed() {
        return maxTimesUsed;
    }

    public void setMaxTimesUsed(Integer maxTimesUsed) {
        this.maxTimesUsed = maxTimesUsed;
    }

    @Basic
    @Column(name = "active", nullable = false)
    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    @Basic
    @Column(name = "comment", nullable = true, length = 255)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "discount", nullable = true, precision = 0)
    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voucher voucher = (Voucher) o;

        if (voucherId != voucher.voucherId) return false;
        if (active != voucher.active) return false;
        if (redeemCode != null ? !redeemCode.equals(voucher.redeemCode) : voucher.redeemCode != null) return false;
        if (validFrom != null ? !validFrom.equals(voucher.validFrom) : voucher.validFrom != null) return false;
        if (validUntil != null ? !validUntil.equals(voucher.validUntil) : voucher.validUntil != null) return false;
        if (timesUsed != null ? !timesUsed.equals(voucher.timesUsed) : voucher.timesUsed != null) return false;
        if (maxTimesUsed != null ? !maxTimesUsed.equals(voucher.maxTimesUsed) : voucher.maxTimesUsed != null)
            return false;
        if (comment != null ? !comment.equals(voucher.comment) : voucher.comment != null) return false;
        if (discount != null ? !discount.equals(voucher.discount) : voucher.discount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = voucherId;
        result = 31 * result + (redeemCode != null ? redeemCode.hashCode() : 0);
        result = 31 * result + (validFrom != null ? validFrom.hashCode() : 0);
        result = 31 * result + (validUntil != null ? validUntil.hashCode() : 0);
        result = 31 * result + (timesUsed != null ? timesUsed.hashCode() : 0);
        result = 31 * result + (maxTimesUsed != null ? maxTimesUsed.hashCode() : 0);
        result = 31 * result + (int) active;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "voucherByVoucherId")
    public Collection<VoucherHasCategory> getVoucherHasCategoriesByVoucherId() {
        return voucherHasCategoriesByVoucherId;
    }

    public void setVoucherHasCategoriesByVoucherId(Collection<VoucherHasCategory> voucherHasCategoriesByVoucherId) {
        this.voucherHasCategoriesByVoucherId = voucherHasCategoriesByVoucherId;
    }

    @OneToMany(mappedBy = "voucherByVoucherId")
    public Collection<VoucherHasProduct> getVoucherHasProductsByVoucherId() {
        return voucherHasProductsByVoucherId;
    }

    public void setVoucherHasProductsByVoucherId(Collection<VoucherHasProduct> voucherHasProductsByVoucherId) {
        this.voucherHasProductsByVoucherId = voucherHasProductsByVoucherId;
    }

    @OneToMany(mappedBy = "voucherByVoucherId")
    public Collection<VoucherHasProductGroup> getVoucherHasProductGroupsByVoucherId() {
        return voucherHasProductGroupsByVoucherId;
    }

    public void setVoucherHasProductGroupsByVoucherId(Collection<VoucherHasProductGroup> voucherHasProductGroupsByVoucherId) {
        this.voucherHasProductGroupsByVoucherId = voucherHasProductGroupsByVoucherId;
    }

    @OneToMany(mappedBy = "voucherByVoucherId")
    public Collection<VoucherHasSubcategory> getVoucherHasSubcategoriesByVoucherId() {
        return voucherHasSubcategoriesByVoucherId;
    }

    public void setVoucherHasSubcategoriesByVoucherId(Collection<VoucherHasSubcategory> voucherHasSubcategoriesByVoucherId) {
        this.voucherHasSubcategoriesByVoucherId = voucherHasSubcategoriesByVoucherId;
    }
}
