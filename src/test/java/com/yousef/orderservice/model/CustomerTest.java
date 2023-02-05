package com.yousef.orderservice.model;

import com.yousef.orderservice.DAO.CustomerDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@ComponentScan("com.yousef.orderservice.DAO")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomerTest {

    @Autowired
    CustomerDAO customerDAO;

    @Test
    void saveCustomerTest(){
        Customer customer = new Customer();
        customer.setCustomerName("Yousef");
        customer.setPhone("01234567891");
        customer.setEmail("test@email.com");

        customer.setAddress(Address.generateSampleAddress());
        customer.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));

        customerDAO.saveCustomer(customer);
    }

}