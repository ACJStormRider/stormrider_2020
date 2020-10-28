package com.example.stormrider_2020.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Voucher {
    private int voucherId;
    private Double percentage;
    private boolean status;
    private Date validFrom;
    private Date validUntil;
    private int timesUsed;

    @Id
    @Column(name = "voucher_id")
    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    @Basic
    @Column(name = "percentage")
    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    @Basic
    @Column(name = "status")
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Basic
    @Column(name = "valid_from")
    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    @Basic
    @Column(name = "valid_until")
    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    @Basic
    @Column(name = "times_used")
    public int getTimesUsed() {
        return timesUsed;
    }

    public void setTimesUsed(int timesUsed) {
        this.timesUsed = timesUsed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voucher voucher = (Voucher) o;

        if (voucherId != voucher.voucherId) return false;
        if (status != voucher.status) return false;
        if (timesUsed != voucher.timesUsed) return false;
        if (percentage != null ? !percentage.equals(voucher.percentage) : voucher.percentage != null) return false;
        if (validFrom != null ? !validFrom.equals(voucher.validFrom) : voucher.validFrom != null) return false;
        if (validUntil != null ? !validUntil.equals(voucher.validUntil) : voucher.validUntil != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = voucherId;
        result = 31 * result + (percentage != null ? percentage.hashCode() : 0);
        result = 31 * result + (status ? 1 : 0);
        result = 31 * result + (validFrom != null ? validFrom.hashCode() : 0);
        result = 31 * result + (validUntil != null ? validUntil.hashCode() : 0);
        result = 31 * result + timesUsed;
        return result;
    }
}
