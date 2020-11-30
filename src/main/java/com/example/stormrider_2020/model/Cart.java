package com.example.stormrider_2020.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Cart {
    private int cartId;
    private String status;
    private double totalPrice;
    private double vat;
    private double totalDiscount;
    private Integer billingAddressId;
    private Integer shippingAddressId;
    private Integer customerId;
    private Date created;
    private Integer voucherId;
    private String trackingNumber;

    @Id
    @Column(name = "cart_id", nullable = false)
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 45)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "total_price", nullable = false, precision = 0)
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "vat", nullable = false, precision = 0)
    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    @Basic
    @Column(name = "total_discount", nullable = false, precision = 0)
    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    @Basic
    @Column(name = "billing_address_id", nullable = true)
    public Integer getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(Integer billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    @Basic
    @Column(name = "shipping_address_id", nullable = true)
    public Integer getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(Integer shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    @Basic
    @Column(name = "customer_id", nullable = true)
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "created", nullable = true)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Basic
    @Column(name = "voucher_id", nullable = true)
    public Integer getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Integer voucherId) {
        this.voucherId = voucherId;
    }

    @Basic
    @Column(name = "tracking_number", nullable = true, length = 45)
    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return cartId == cart.cartId &&
                Double.compare(cart.totalPrice, totalPrice) == 0 &&
                Double.compare(cart.vat, vat) == 0 &&
                Double.compare(cart.totalDiscount, totalDiscount) == 0 &&
                Objects.equals(status, cart.status) &&
                Objects.equals(billingAddressId, cart.billingAddressId) &&
                Objects.equals(shippingAddressId, cart.shippingAddressId) &&
                Objects.equals(customerId, cart.customerId) &&
                Objects.equals(created, cart.created) &&
                Objects.equals(voucherId, cart.voucherId) &&
                Objects.equals(trackingNumber, cart.trackingNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, status, totalPrice, vat, totalDiscount, billingAddressId, shippingAddressId, customerId, created, voucherId, trackingNumber);
    }
}
