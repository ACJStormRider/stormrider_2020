package com.example.stormrider_2020.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {
    private int cartId;
    private String status;
    private Double totalPrice;
    private Double vat;
    private Double totalDiscount;
    private int voucherId;
    private int billingAddressId;
    private int shippingAddressId;
    private int customerId;

    @Id
    @Column(name = "cart_id")
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "total_price")
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "vat")
    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }

    @Basic
    @Column(name = "total_discount")
    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    @Basic
    @Column(name = "voucher_id")
    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    @Basic
    @Column(name = "billing_address_id")
    public int getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(int billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    @Basic
    @Column(name = "shipping_address_id")
    public int getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(int shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    @Basic
    @Column(name = "customer_id")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        if (cartId != cart.cartId) return false;
        if (voucherId != cart.voucherId) return false;
        if (billingAddressId != cart.billingAddressId) return false;
        if (shippingAddressId != cart.shippingAddressId) return false;
        if (customerId != cart.customerId) return false;
        if (status != null ? !status.equals(cart.status) : cart.status != null) return false;
        if (totalPrice != null ? !totalPrice.equals(cart.totalPrice) : cart.totalPrice != null) return false;
        if (vat != null ? !vat.equals(cart.vat) : cart.vat != null) return false;
        if (totalDiscount != null ? !totalDiscount.equals(cart.totalDiscount) : cart.totalDiscount != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cartId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (vat != null ? vat.hashCode() : 0);
        result = 31 * result + (totalDiscount != null ? totalDiscount.hashCode() : 0);
        result = 31 * result + voucherId;
        result = 31 * result + billingAddressId;
        result = 31 * result + shippingAddressId;
        result = 31 * result + customerId;
        return result;
    }
}
