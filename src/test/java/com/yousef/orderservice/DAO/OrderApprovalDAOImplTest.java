package com.yousef.orderservice.DAO;

import com.yousef.orderservice.model.OrderApproval;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ComponentScan("com.yousef.orderservice.DAO")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderApprovalDAOImplTest {

    @Autowired
    private OrderApprovalDAO orderApprovalDAO;

    @Test
    void testCreateOrderApproval(){
        OrderApproval orderApproval = new OrderApproval();
        orderApproval.setApprovedBy("Yousef Refaat");
        OrderApproval savedOrderApproval = orderApprovalDAO.saveNewOrderApproval(orderApproval);
        assertNotNull(savedOrderApproval);
    }
}