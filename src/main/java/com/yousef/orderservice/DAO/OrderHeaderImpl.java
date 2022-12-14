package com.yousef.orderservice.DAO;

import com.yousef.orderservice.model.OrderHeader;
import com.yousef.orderservice.repositories.OrderHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderHeaderImpl implements OrderHeaderDAO{

    @Autowired
    private OrderHeaderRepository orderHeaderRepository;

    @Override
    public OrderHeader saveNewOrderHeader(OrderHeader orderHeader) {
        return orderHeaderRepository.save(orderHeader);
    }

    @Override
    public OrderHeader getOrderHeaderById(Long id) {
        return orderHeaderRepository.findById(id).orElse(null);
    }

    /*@Override
    public Optional<List<OrderHeader>> getOrderHeaderByCustmoerName(String name) {
        return orderHeaderRepository.findOrderHeaderByCustomerName(name);
    }*/

    @Override
    public void deleteOrderById(Long id) {
        orderHeaderRepository.deleteById(id);
    }

    @Override
    public OrderHeader updateOrderHeader(OrderHeader orderHeader) {
        if(orderHeader.getId()!=null)
            return orderHeaderRepository.save(orderHeader);
        return null;
    }
}
