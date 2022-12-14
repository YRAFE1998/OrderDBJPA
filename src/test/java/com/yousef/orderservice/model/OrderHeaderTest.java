package com.yousef.orderservice.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class OrderHeaderTest {

    @Test
    void testEquals() {
        OrderHeader o1 = new OrderHeader();
        o1.setId(1L);
        OrderHeader o2 = new OrderHeader();
        o2.setId(1L);
        assertThat(o1.equals(o2)).isTrue();
    }

    @Test
    void testNotEquals() {
        OrderHeader o1 = new OrderHeader();
        o1.setId(1L);
        OrderHeader o2 = new OrderHeader();
        o2.setId(2L);
        assertThat(o1.equals(o2)).isFalse();
    }

    @Test
    void testGetAddress(){
        OrderHeader o1 = new OrderHeader();
        Address shippingAddress = new Address();
        shippingAddress.setAddress("Address Line");
        shippingAddress.setCity("New Cairo");
        shippingAddress.setState("Cairo");
        shippingAddress.setZipCode("10808");

        Address billingAddress = new Address();
        billingAddress.setAddress("Address Line 1");
        billingAddress.setCity("Giza");
        billingAddress.setState("Giza");
        billingAddress.setZipCode("11111");

        o1.setBillingAddress(billingAddress);
        o1.setShippingAddress(shippingAddress);
    }



}