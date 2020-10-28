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
    private Integer voucherId;
    private Integer billingAddressId;
    private Integer shippingAddressId;
    private Integer customerId;

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
    public Integer getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Integer voucherId) {
        this.voucherId = voucherId;
    }

    @Basic
    @Column(name = "billing_address_id")
    public Integer getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(Integer billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    @Basic
    @Column(name = "shipping_address_id")
    public Integer getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(Integer shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    @Basic
    @Column(name = "customer_id")
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        if (cartId != cart.cartId) return false;
        if (status != null ? !status.equals(cart.status) : cart.status != null) return false;
        if (totalPrice != null ? !totalPrice.equals(cart.totalPrice) : cart.totalPrice != null) return false;
        if (vat != null ? !vat.equals(cart.vat) : cart.vat != null) return false;
        if (totalDiscount != null ? !totalDiscount.equals(cart.totalDiscount) : cart.totalDiscount != null)
            return false;
        if (voucherId != null ? !voucherId.equals(cart.voucherId) : cart.voucherId != null) return false;
        if (billingAddressId != null ? !billingAddressId.equals(cart.billingAddressId) : cart.billingAddressId != null)
            return false;
        if (shippingAddressId != null ? !shippingAddressId.equals(cart.shippingAddressId) : cart.shippingAddressId != null)
            return false;
        if (customerId != null ? !customerId.equals(cart.customerId) : cart.customerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cartId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (vat != null ? vat.hashCode() : 0);
        result = 31 * result + (totalDiscount != null ? totalDiscount.hashCode() : 0);
        result = 31 * result + (voucherId != null ? voucherId.hashCode() : 0);
        result = 31 * result + (billingAddressId != null ? billingAddressId.hashCode() : 0);
        result = 31 * result + (shippingAddressId != null ? shippingAddressId.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        return result;
    }
}
