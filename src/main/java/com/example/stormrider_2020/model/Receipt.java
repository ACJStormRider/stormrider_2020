package com.example.stormrider_2020.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Receipt {
    private int receiptId;
    private String receiptInfo;
    private int invoiceId;

    @Id
    @Column(name = "receipt_id", nullable = false)
    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    @Basic
    @Column(name = "receipt_info", nullable = true, length = 255)
    public String getReceiptInfo() {
        return receiptInfo;
    }

    public void setReceiptInfo(String receiptInfo) {
        this.receiptInfo = receiptInfo;
    }

    @Basic
    @Column(name = "invoice_id", nullable = false)
    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return receiptId == receipt.receiptId &&
                invoiceId == receipt.invoiceId &&
                Objects.equals(receiptInfo, receipt.receiptInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiptId, receiptInfo, invoiceId);
    }
}
