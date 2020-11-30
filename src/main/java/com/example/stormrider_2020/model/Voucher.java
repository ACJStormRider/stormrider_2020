package com.example.stormrider_2020.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

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
        return voucherId == voucher.voucherId &&
                active == voucher.active &&
                Objects.equals(redeemCode, voucher.redeemCode) &&
                Objects.equals(validFrom, voucher.validFrom) &&
                Objects.equals(validUntil, voucher.validUntil) &&
                Objects.equals(timesUsed, voucher.timesUsed) &&
                Objects.equals(maxTimesUsed, voucher.maxTimesUsed) &&
                Objects.equals(comment, voucher.comment) &&
                Objects.equals(discount, voucher.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voucherId, redeemCode, validFrom, validUntil, timesUsed, maxTimesUsed, active, comment, discount);
    }
}
