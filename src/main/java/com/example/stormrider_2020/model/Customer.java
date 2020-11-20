package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String cvrNumber;
    private String companyName;
    private Collection<Cart> cartsByCustomerId;

    @Id
    @Column(name = "customer_id", nullable = false)
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 80)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 45)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 120)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 45)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "cvr_number", nullable = true, length = 10)
    public String getCvrNumber() {
        return cvrNumber;
    }

    public void setCvrNumber(String cvrNumber) {
        this.cvrNumber = cvrNumber;
    }

    @Basic
    @Column(name = "company_name", nullable = true, length = 120)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (customerId != customer.customerId) return false;
        if (firstName != null ? !firstName.equals(customer.firstName) : customer.firstName != null) return false;
        if (lastName != null ? !lastName.equals(customer.lastName) : customer.lastName != null) return false;
        if (email != null ? !email.equals(customer.email) : customer.email != null) return false;
        if (phone != null ? !phone.equals(customer.phone) : customer.phone != null) return false;
        if (cvrNumber != null ? !cvrNumber.equals(customer.cvrNumber) : customer.cvrNumber != null) return false;
        if (companyName != null ? !companyName.equals(customer.companyName) : customer.companyName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (cvrNumber != null ? cvrNumber.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<Cart> getCartsByCustomerId() {
        return cartsByCustomerId;
    }

    public void setCartsByCustomerId(Collection<Cart> cartsByCustomerId) {
        this.cartsByCustomerId = cartsByCustomerId;
    }
}
