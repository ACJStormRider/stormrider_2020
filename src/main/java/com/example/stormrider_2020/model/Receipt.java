package com.example.stormrider_2020.model;

import javax.persistence.*;

@Entity
public class Receipt {
    private int receiptId;
    private String receiptInfo;
    private Invoice invoiceByInvoiceId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receipt receipt = (Receipt) o;

        if (receiptId != receipt.receiptId) return false;
        if (receiptInfo != null ? !receiptInfo.equals(receipt.receiptInfo) : receipt.receiptInfo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = receiptId;
        result = 31 * result + (receiptInfo != null ? receiptInfo.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id", nullable = false)
    public Invoice getInvoiceByInvoiceId() {
        return invoiceByInvoiceId;
    }

    public void setInvoiceByInvoiceId(Invoice invoiceByInvoiceId) {
        this.invoiceByInvoiceId = invoiceByInvoiceId;
    }
}
