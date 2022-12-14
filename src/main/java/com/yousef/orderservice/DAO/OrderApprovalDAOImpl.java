package com.yousef.orderservice.DAO;

import com.yousef.orderservice.model.OrderApproval;
import com.yousef.orderservice.repositories.OrderApprovalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderApprovalDAOImpl implements OrderApprovalDAO{

    @Autowired
    OrderApprovalRepository orderApprovalRepository;

    @Override
    public OrderApproval saveNewOrderApproval(OrderApproval orderApproval) {
        return  orderApprovalRepository.save(orderApproval);
    }

    @Override
    public OrderApproval updateOrderApproval(OrderApproval orderApproval) {
        if(orderApproval.getId() == null)
            return null;
        return orderApprovalRepository.save(orderApproval);
    }

    @Override
    public OrderApproval getOrderApprovalByID(Long id) {
        return orderApprovalRepository.findById(id).get();
    }

    @Override
    public void deleteOrderApprovalById(Long id) {
        orderApprovalRepository.deleteById(id);
    }
}