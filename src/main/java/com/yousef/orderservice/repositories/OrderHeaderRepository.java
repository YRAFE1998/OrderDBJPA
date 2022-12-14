package com.yousef.orderservice.repositories;

import com.yousef.orderservice.model.OrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderHeaderRepository extends JpaRepository<OrderHeader, Long> {
    //Optional<List<OrderHeader>> findOrderHeaderByCustomerName(String customerName);
}
