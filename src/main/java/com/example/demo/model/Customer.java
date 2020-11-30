package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name="customer")
public class Customer {
    private int id;
    private String fullName;
    private String phone;
    private String email;
    private byte isSubscribed;

    public Customer() {
    }

    public Customer(int id, String fullName, String phone, String email, byte isSubscribed) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.isSubscribed = isSubscribed;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "full_name", nullable = false, length = 45)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 12)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "is_subscribed", nullable = false)
    public byte getIsSubscribed() {
        return isSubscribed;
    }

    public void setIsSubscribed(byte isSubscribed) {
        this.isSubscribed = isSubscribed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                isSubscribed == customer.isSubscribed &&
                Objects.equals(fullName, customer.fullName) &&
                Objects.equals(phone, customer.phone) &&
                Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, phone, email, isSubscribed);
    }
}
