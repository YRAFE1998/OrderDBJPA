package com.yousef.orderservice.DAO;

import com.yousef.orderservice.model.OrderHeader;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface OrderHeaderDAO {
    OrderHeader saveNewOrderHeader(OrderHeader orderHeader);
    OrderHeader getOrderHeaderById(Long id);
    //Optional<List<OrderHeader>> getOrderHeaderByCustmoerName(String name);
    void deleteOrderById(Long id);
    OrderHeader updateOrderHeader(OrderHeader orderHeader);
}
