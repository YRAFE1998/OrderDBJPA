package com.yousef.orderservice.model;


import org.hibernate.criterion.Order;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer extends BaseEntity {

    @Length(max = 50)
    private String customerName;

    @Embedded
    private Address address;
    @Length(max = 20)
    private String phone;
    @Length(max = 255)
    @Email
    private String email;

    @Version
    private Integer version;


    @OneToMany(mappedBy = "customer")
    private Set<OrderHeader> orderHeaders;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Address getAddress() {
        return address;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<OrderHeader> getOrderHeaders() {
        return orderHeaders;
    }

    public void setOrderHeaders(Set<OrderHeader> orderHeaders) {
        this.orderHeaders = orderHeaders;
    }

    public void addOrder(OrderHeader orderHeader){
        if( this.orderHeaders == null)
            this.orderHeaders = new HashSet<OrderHeader>();
        this.orderHeaders.add(orderHeader);
        orderHeader.setCustomer(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        if (!super.equals(o)) return false;

        Customer customer = (Customer) o;

        if (getCustomerName() != null ? !getCustomerName().equals(customer.getCustomerName()) : customer.getCustomerName() != null)
            return false;
        if (getAddress() != null ? !getAddress().equals(customer.getAddress()) : customer.getAddress() != null)
            return false;
        if (getPhone() != null ? !getPhone().equals(customer.getPhone()) : customer.getPhone() != null) return false;
        if (getEmail() != null ? !getEmail().equals(customer.getEmail()) : customer.getEmail() != null) return false;
        return getOrderHeaders() != null ? getOrderHeaders().equals(customer.getOrderHeaders()) : customer.getOrderHeaders() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getCustomerName() != null ? getCustomerName().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        return result;
    }
}
