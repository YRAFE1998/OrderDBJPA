package com.yousef.orderservice.repositories;

import com.yousef.orderservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}