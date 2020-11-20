package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Address {
    private int addressId;
    private String address;
    private String zip;
    private String city;
    private String country;
    private String county;
    private Collection<Cart> cartsByAddressId;
    private Collection<Cart> cartsByAddressId_0;

    @Id
    @Column(name = "address_id", nullable = false)
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 100)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "zip", nullable = false, length = 15)
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "country", nullable = false, length = 56)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "county", nullable = false, length = 45)
    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address1 = (Address) o;

        if (addressId != address1.addressId) return false;
        if (address != null ? !address.equals(address1.address) : address1.address != null) return false;
        if (zip != null ? !zip.equals(address1.zip) : address1.zip != null) return false;
        if (city != null ? !city.equals(address1.city) : address1.city != null) return false;
        if (country != null ? !country.equals(address1.country) : address1.country != null) return false;
        if (county != null ? !county.equals(address1.county) : address1.county != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = addressId;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (county != null ? county.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "addressByBillingAddressId")
    public Collection<Cart> getCartsByAddressId() {
        return cartsByAddressId;
    }

    public void setCartsByAddressId(Collection<Cart> cartsByAddressId) {
        this.cartsByAddressId = cartsByAddressId;
    }

    @OneToMany(mappedBy = "addressByShippingAddressId")
    public Collection<Cart> getCartsByAddressId_0() {
        return cartsByAddressId_0;
    }

    public void setCartsByAddressId_0(Collection<Cart> cartsByAddressId_0) {
        this.cartsByAddressId_0 = cartsByAddressId_0;
    }
}
