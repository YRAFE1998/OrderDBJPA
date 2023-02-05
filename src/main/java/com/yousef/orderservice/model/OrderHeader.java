package com.yousef.orderservice.model;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@AttributeOverrides({
        @AttributeOverride(name = "shippingAddress.address",column = @Column(name = "shipping_address")),
        @AttributeOverride(name = "shippingAddress.city",column = @Column(name = "shipping_city")),
        @AttributeOverride(name = "shippingAddress.state",column = @Column(name = "shipping_state")),
        @AttributeOverride(name = "shippingAddress.zipCode",column = @Column(name = "shipping_zip_code")),
        @AttributeOverride(name = "billingAddress.address",column = @Column(name = "bill_to_address")),
        @AttributeOverride(name = "billingAddress.city",column = @Column(name = "bill_to_city")),
        @AttributeOverride(name = "billingAddress.state",column = @Column(name = "bill_to_state")),
        @AttributeOverride(name = "billingAddress.zipCode",column = @Column(name = "bill_to_zip_code"))
})
public class OrderHeader extends BaseEntity{



    @Embedded
    private Address shippingAddress;
    @Embedded
    private Address billingAddress;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Version
    private Integer version;


    @OneToMany(mappedBy = "orderHeader", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Set<OrderLine> orderLines;

    @ManyToOne
    private Customer customer;


    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private OrderApproval orderApproval;


    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public OrderApproval getOrderApproval(){
        return orderApproval;
    }


    public void setOrderApproval(OrderApproval orderApproval) {
        this.orderApproval = orderApproval;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Set<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void addOrderLine(OrderLine orderLine){
        if(this.orderLines == null){
            this.orderLines = new HashSet<OrderLine>();
        }
        this.orderLines.add(orderLine);
        orderLine.setOrderHeader(this);
    }

    public void setOrderLines(Set<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderHeader)) return false;
        if (!super.equals(o)) return false;

        OrderHeader that = (OrderHeader) o;

        if (getShippingAddress() != null ? !getShippingAddress().equals(that.getShippingAddress()) : that.getShippingAddress() != null)
            return false;
        if (getBillingAddress() != null ? !getBillingAddress().equals(that.getBillingAddress()) : that.getBillingAddress() != null)
            return false;
        if (getOrderStatus() != that.getOrderStatus()) return false;
        if (getOrderLines() != null ? !getOrderLines().equals(that.getOrderLines()) : that.getOrderLines() != null)
            return false;
        return getCustomer() != null ? getCustomer().equals(that.getCustomer()) : that.getCustomer() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getShippingAddress() != null ? getShippingAddress().hashCode() : 0);
        result = 31 * result + (getBillingAddress() != null ? getBillingAddress().hashCode() : 0);
        result = 31 * result + (getOrderStatus() != null ? getOrderStatus().hashCode() : 0);
        result = 31 * result + (getOrderLines() != null ? getOrderLines().hashCode() : 0);
        return result;
    }
}
