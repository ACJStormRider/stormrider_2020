package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Invoice {
    private int invoiceId;
    private Date date;
    private String status;
    private String paymentMethod;
    private byte paid;
    private Cart cartByCartId;
    private Collection<Receipt> receiptsByInvoiceId;

    @Id
    @Column(name = "invoice_id", nullable = false)
    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 25)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "payment_method", nullable = true, length = 45)
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Basic
    @Column(name = "paid", nullable = false)
    public byte getPaid() {
        return paid;
    }

    public void setPaid(byte paid) {
        this.paid = paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;

        if (invoiceId != invoice.invoiceId) return false;
        if (paid != invoice.paid) return false;
        if (date != null ? !date.equals(invoice.date) : invoice.date != null) return false;
        if (status != null ? !status.equals(invoice.status) : invoice.status != null) return false;
        if (paymentMethod != null ? !paymentMethod.equals(invoice.paymentMethod) : invoice.paymentMethod != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = invoiceId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (paymentMethod != null ? paymentMethod.hashCode() : 0);
        result = 31 * result + (int) paid;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id", nullable = false)
    public Cart getCartByCartId() {
        return cartByCartId;
    }

    public void setCartByCartId(Cart cartByCartId) {
        this.cartByCartId = cartByCartId;
    }

    @OneToMany(mappedBy = "invoiceByInvoiceId")
    public Collection<Receipt> getReceiptsByInvoiceId() {
        return receiptsByInvoiceId;
    }

    public void setReceiptsByInvoiceId(Collection<Receipt> receiptsByInvoiceId) {
        this.receiptsByInvoiceId = receiptsByInvoiceId;
    }
}
