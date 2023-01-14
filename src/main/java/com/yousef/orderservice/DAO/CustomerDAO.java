package com.yousef.orderservice.DAO;

import com.yousef.orderservice.model.Customer;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
public interface CustomerDAO {
    Customer saveCustomer(Customer customer);
    Customer getById(Long id);
    Customer updateCustomer(Customer customer);
    void deleteCustomerById(Long id);
    Customer findByName(String name);

}
