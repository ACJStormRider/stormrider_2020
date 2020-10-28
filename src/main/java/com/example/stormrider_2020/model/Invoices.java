package com.example.stormrider_2020.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Invoices {
    private int invoiceId;
    private Date date;
    private int cartId;

    @Id
    @Column(name = "invoice_id")
    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "cart_id")
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoices invoices = (Invoices) o;

        if (invoiceId != invoices.invoiceId) return false;
        if (cartId != invoices.cartId) return false;
        if (date != null ? !date.equals(invoices.date) : invoices.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = invoiceId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + cartId;
        return result;
    }
}
