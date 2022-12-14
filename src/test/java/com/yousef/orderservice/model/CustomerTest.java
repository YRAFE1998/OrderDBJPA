package com.yousef.orderservice.model;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import static org.junit.jupiter.api.Assertions.*;



class CustomerTest {

    void testCreateCustomer(){
        Customer customer = new Customer();
    }
}