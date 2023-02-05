package com.yousef.orderservice.bootstrap;

import com.yousef.orderservice.model.OrderHeader;
import com.yousef.orderservice.repositories.OrderHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class OrderDataGetter {

    @Autowired
    private OrderHeaderRepository orderHeaderRepository;

    @Transactional
    public void readOrderData(){
        OrderHeader orderHeader = orderHeaderRepository.findById(26L).get();
        orderHeader.getOrderLines().forEach((orderLine) ->{
            System.out.println("Description  + " + orderLine.getProduct().getDescription());
            orderLine.getProduct().getCategories().forEach(category -> {
                System.out.println(category.getDescription());
            });
        });
    }
}
