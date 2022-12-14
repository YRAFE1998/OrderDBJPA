package com.yousef.orderservice.DAO;


import com.yousef.orderservice.model.OrderApproval;
import org.springframework.stereotype.Component;

@Component
public interface OrderApprovalDAO {

    OrderApproval saveNewOrderApproval(OrderApproval orderApproval);
    OrderApproval updateOrderApproval(OrderApproval orderApproval);
    OrderApproval getOrderApprovalByID(Long id);
    void deleteOrderApprovalById(Long id);
}
