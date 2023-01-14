package com.yousef.orderservice.DAO;


import com.yousef.orderservice.model.OrderHeader;
import com.yousef.orderservice.model.OrderLine;
import com.yousef.orderservice.model.Product;
import liquibase.pro.packaged.O;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

@DataJpaTest
@ComponentScan("com.yousef.orderservice.DAO")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FetchTest {

    @Autowired
    private OrderHeaderDAO orderHeaderDAO;

    @Autowired
    private ProductDAO productDAO;

    @Rollback(value = false)
    @Transactional
    @Test
    void testFetch(){
        OrderHeader orderHeader = orderHeaderDAO.getOrderHeaderById(39L);
        Product product = productDAO.getById(4013L);
        OrderLine orderLine = new OrderLine();
        orderLine.setProduct(product);
        orderLine.setQuantityOrdered(1);
        orderHeader.addOrderLine(orderLine);
        OrderHeader updated = orderHeaderDAO.updateOrderHeader(orderHeader);
        assertThat(updated.getOrderLines()).isNotNull();
    }
}
