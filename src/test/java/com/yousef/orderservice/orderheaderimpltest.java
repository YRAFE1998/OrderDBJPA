package com.yousef.orderservice;

import com.yousef.orderservice.DAO.CustomerDAO;
import com.yousef.orderservice.DAO.OrderHeaderDAO;
import com.yousef.orderservice.DAO.ProductDAO;
import com.yousef.orderservice.model.*;
import com.yousef.orderservice.repositories.ProductRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import javax.transaction.Transactional;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@ComponentScan("com.yousef.orderservice.DAO")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class orderheaderimpltest {

    @Autowired
    OrderHeaderDAO orderHeaderDAO;

    @Autowired
    ProductDAO productDAO;

    @Autowired
    CustomerDAO customerDAO;


    @Test
    void testGetById(){
        OrderHeader orderHeader = new OrderHeader();
        //orderHeader.setCustomerName("Yousef Refaat Ahmed");
        OrderHeader returnedOrderHeader = orderHeaderDAO.saveNewOrderHeader(orderHeader);
        assertThat(orderHeaderDAO.getOrderHeaderById(returnedOrderHeader.getId())).isNotNull();

    }


    @Transactional
    @Test
    void testSaveOrderLine(){
        OrderHeader o1 = new OrderHeader();
        Address shippingAddress = new Address();
        shippingAddress.setAddress("Address Line");
        shippingAddress.setCity("New Cairo");
        shippingAddress.setState("Cairo");
        shippingAddress.setZipCode("10808");

        Address billingAddress = new Address();
        billingAddress.setAddress("Address Line 1");
        billingAddress.setCity("Giza");
        billingAddress.setState("Giza");
        billingAddress.setZipCode("11111");

        o1.setBillingAddress(billingAddress);
        o1.setShippingAddress(shippingAddress);
        //o1.setCustomerName("Yousef Refaat Ahmed");
        o1.setOrderStatus(OrderStatus.NEW);
        o1.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));

        Product product = new Product();
        product.setProductStatus(ProductStatus.NEW);
        product.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));

        Product savedProduct = productDAO.saveNewProduct(product);



        OrderLine orderLine = new OrderLine();
        orderLine.setQuantityOrdered(10);
        o1.addOrderLine(orderLine);
        orderLine.setProduct(savedProduct);
        //o1.setOrderLines(Set.of(orderLine));
        //orderLine.setOrderHeader(o1);

        OrderHeader returnedOrderHeader = orderHeaderDAO.saveNewOrderHeader(o1);
        assertThat(returnedOrderHeader).isNotNull();
        assertThat(returnedOrderHeader.getOrderLines().size()).isGreaterThan(0);
        assertThat(returnedOrderHeader.getOrderLines().iterator().next().getProduct()).isNotNull();
    }

    @Test
    void testGetByName(){
        OrderHeader orderHeader = new OrderHeader();
        //orderHeader.setCustomerName("Yousef Refaat Ahmed");
        OrderHeader returnedOrderHeader = orderHeaderDAO.saveNewOrderHeader(orderHeader);
        //assertThat(orderHeaderDAO.getOrderHeaderByCustmoerName("Yousef Refaat Ahmed").get().get(0).
        //        getCustomerName()).
        //        isEqualTo("Yousef Refaat Ahmed");

    }

    @Transactional
    @Test
    void testUpdate(){
        OrderHeader o1 = new OrderHeader();
        Address shippingAddress = new Address();
        shippingAddress.setAddress("Address Line");
        shippingAddress.setCity("New Cairo");
        shippingAddress.setState("Cairo");
        shippingAddress.setZipCode("10808");

        Address billingAddress = new Address();
        billingAddress.setAddress("Address Line 1");
        billingAddress.setCity("Giza");
        billingAddress.setState("Giza");
        billingAddress.setZipCode("11111");

        o1.setBillingAddress(billingAddress);
        o1.setShippingAddress(shippingAddress);
        //o1.setCustomerName("Yousef Refaat Ahmed");
        o1.setOrderStatus(OrderStatus.NEW);
        o1.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        OrderApproval orderApproval = new OrderApproval();
        orderApproval.setApprovedBy("Mohamed Hany");
        orderApproval.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        orderApproval.setLastModified(Timestamp.valueOf(LocalDateTime.now()));
        o1.setOrderApproval(orderApproval);
        Customer customer = customerDAO.getById(2L);
        o1.setCustomer(customer);
        OrderHeader saved = orderHeaderDAO.saveNewOrderHeader(o1);
        try {
            TimeUnit.SECONDS.sleep(10);
            Address billingUpdated = saved.getBillingAddress();
            billingUpdated.setState("New Giza");
            saved.setBillingAddress(billingUpdated);
            OrderHeader updated = orderHeaderDAO.updateOrderHeader(saved);
            //assertThat(updated.getCustomerName()).isEqualTo("Changed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

    @Test
    void testsaveNewOrderHeader(){

        OrderHeader o1 = new OrderHeader();
        Address shippingAddress = new Address();
        shippingAddress.setAddress("Address Line");
        shippingAddress.setCity("New Cairo");
        shippingAddress.setState("Cairo");
        shippingAddress.setZipCode("10808");

        Address billingAddress = new Address();
        billingAddress.setAddress("Address Line 1");
        billingAddress.setCity("Giza");
        billingAddress.setState("Giza");
        billingAddress.setZipCode("11111");

        o1.setBillingAddress(billingAddress);
        o1.setShippingAddress(shippingAddress);
        //o1.setCustomerName("Yousef Refaat Ahmed");
        o1.setOrderStatus(OrderStatus.NEW);
        o1.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        OrderHeader returnedOrderHeader = orderHeaderDAO.saveNewOrderHeader(o1);
        assertThat(returnedOrderHeader).isNotNull();
    }

    @Transactional
    @Test
    void testDelete(){
        OrderHeader orderHeader = new OrderHeader();
        //orderHeader.setCustomerName("Yousef Refaat Ahmed");
        OrderHeader returnedOrderHeader = orderHeaderDAO.saveNewOrderHeader(orderHeader);
        orderHeaderDAO.deleteOrderById(returnedOrderHeader.getId());
        assertThat(orderHeaderDAO.getOrderHeaderById(returnedOrderHeader.getId())).isNull();

    }
}
