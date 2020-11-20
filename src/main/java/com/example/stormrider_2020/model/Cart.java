package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Cart {
    private int cartId;
    private String status;
    private double totalPrice;
    private double vat;
    private double totalDiscount;
    private Date created;
    private Integer voucherId;
    private String trackingNumber;
    private Address addressByBillingAddressId;
    private Address addressByShippingAddressId;
    private Customer customerByCustomerId;
    private Collection<CartHasProducts> cartHasProductsByCartId;
    private Collection<Invoice> invoicesByCartId;

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

        if (cartId != cart.cartId) return false;
        if (Double.compare(cart.totalPrice, totalPrice) != 0) return false;
        if (Double.compare(cart.vat, vat) != 0) return false;
        if (Double.compare(cart.totalDiscount, totalDiscount) != 0) return false;
        if (status != null ? !status.equals(cart.status) : cart.status != null) return false;
        if (created != null ? !created.equals(cart.created) : cart.created != null) return false;
        if (voucherId != null ? !voucherId.equals(cart.voucherId) : cart.voucherId != null) return false;
        if (trackingNumber != null ? !trackingNumber.equals(cart.trackingNumber) : cart.trackingNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = cartId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        temp = Double.doubleToLongBits(totalPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(vat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(totalDiscount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (voucherId != null ? voucherId.hashCode() : 0);
        result = 31 * result + (trackingNumber != null ? trackingNumber.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "billing_address_id", referencedColumnName = "address_id")
    public Address getAddressByBillingAddressId() {
        return addressByBillingAddressId;
    }

    public void setAddressByBillingAddressId(Address addressByBillingAddressId) {
        this.addressByBillingAddressId = addressByBillingAddressId;
    }

    @ManyToOne
    @JoinColumn(name = "shipping_address_id", referencedColumnName = "address_id")
    public Address getAddressByShippingAddressId() {
        return addressByShippingAddressId;
    }

    public void setAddressByShippingAddressId(Address addressByShippingAddressId) {
        this.addressByShippingAddressId = addressByShippingAddressId;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    public Customer getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    @OneToMany(mappedBy = "cartByCartId")
    public Collection<CartHasProducts> getCartHasProductsByCartId() {
        return cartHasProductsByCartId;
    }

    public void setCartHasProductsByCartId(Collection<CartHasProducts> cartHasProductsByCartId) {
        this.cartHasProductsByCartId = cartHasProductsByCartId;
    }

    @OneToMany(mappedBy = "cartByCartId")
    public Collection<Invoice> getInvoicesByCartId() {
        return invoicesByCartId;
    }

    public void setInvoicesByCartId(Collection<Invoice> invoicesByCartId) {
        this.invoicesByCartId = invoicesByCartId;
    }
}
