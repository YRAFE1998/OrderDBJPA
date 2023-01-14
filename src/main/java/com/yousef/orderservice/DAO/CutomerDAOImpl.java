package com.yousef.orderservice.DAO;

import com.yousef.orderservice.model.Customer;
import com.yousef.orderservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class CutomerDAOImpl implements CustomerDAO{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {

        return customerRepository.save(customer);
    }

    @Override
    public Customer getById(Long id) {

        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        if(customer.getId() == null)
            return null;
        return customerRepository.save(customer);

    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);

    }

    @Override
    public Customer findByName(String name) {
        return customerRepository.findByCustomerName(name);
    }
}
