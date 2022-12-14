package com.yousef.orderservice.DAO;

import com.yousef.orderservice.model.Address;
import com.yousef.orderservice.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ComponentScan("com.yousef.orderservice.DAO")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CutomerDAOImplTest {


    @Autowired
    private CustomerDAO customerDAO;
    @Test
    void testSaveCustomer(){
        Customer customer = new Customer();
        customer.setCustomerName("Yousef");
        customer.setAddress(Address.generateSampleAddress());
        customer.setEmail("test@email.com");
        customer.setPhone("01228899932");
        Customer savedCustomer = customerDAO.saveCustomer(customer);
        assertNotNull(savedCustomer);

    }

}