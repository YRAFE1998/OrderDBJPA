package com.yousef.orderservice.repositories;

import com.yousef.orderservice.model.OrderApproval;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderApprovalRepository extends JpaRepository<OrderApproval, Long> {
}