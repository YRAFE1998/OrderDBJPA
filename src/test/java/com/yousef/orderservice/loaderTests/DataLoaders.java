package com.yousef.orderservice.loaderTests;

import com.yousef.orderservice.DAO.CustomerDAO;
import com.yousef.orderservice.DAO.OrderApprovalDAO;
import com.yousef.orderservice.DAO.OrderHeaderDAO;
import com.yousef.orderservice.DAO.ProductDAO;
import com.yousef.orderservice.model.*;
import liquibase.pro.packaged.P;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

@DataJpaTest
@ComponentScan("com.yousef.orderservice.DAO")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataLoaders {

    final static Category CATEGORY_1 = new Category();
    final static Category CATEGORY_2 = new Category();
    final static Category CATEGORY_3 = new Category();
    final static Category CATEGORY_4 = new Category();

    final static Address ADDRESS_1 = new Address();
    final static Address ADDRESS_2 = new Address();
    final static Address ADDRESS_3 = new Address();
    final static Address ADDRESS_4 = new Address();

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private OrderHeaderDAO orderHeaderDAO;

    @Autowired
    private OrderApprovalDAO orderApprovalDAO;

    @BeforeAll
    static void setUp() {
        CATEGORY_1.setDescription("Tables");
        CATEGORY_1.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));

        CATEGORY_2.setDescription("Chairs");
        CATEGORY_2.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));

        CATEGORY_3.setDescription("Drapes");
        CATEGORY_3.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));

        CATEGORY_4.setDescription("Closets");
        CATEGORY_4.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));

        ADDRESS_1.setAddress("Address 1");
        ADDRESS_1.setCity("Cairo");
        ADDRESS_1.setZipCode("19011");
        ADDRESS_1.setState("Cairo");

        ADDRESS_2.setAddress("Address 2");
        ADDRESS_2.setCity("Faisal");
        ADDRESS_2.setZipCode("15678");
        ADDRESS_2.setState("Giza");

        ADDRESS_3.setAddress("Address 3");
        ADDRESS_3.setCity("New Cairo");
        ADDRESS_3.setZipCode("15022");
        ADDRESS_3.setState("Cairo");

        ADDRESS_4.setAddress("Address 4");
        ADDRESS_4.setCity("Assiut");
        ADDRESS_4.setZipCode("17544");
        ADDRESS_4.setState("Assiut");


    }

    @Disabled(value = "true")
    @Order(1)
    @Rollback(value = false)
    @Test
    void loadCustomers(){
        for(int i =0; i<20;i++){
            Customer customer = new Customer();
            customer.setCustomerName("Sample Customer " + i);
            customer.setPhone("0123465" + getLastFourDigits(i));
            customer.setEmail("test" + i +"@email.com");
            customer.setAddress(getAddress(i));
            customer.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
            customerDAO.saveCustomer(customer);
        }

    }


    @Order(1)
    @Rollback(value = false)
    @Transactional
    @Test
    void loadProducts(){

        for(int i=0;i<2000;i++){
            Product product = new Product();
            product.setProductStatus(ProductStatus.NEW);
            product.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
            product.setCategories(Set.of(getCategory(i)));
            product.setDescription("Description " + i);
            productDAO.saveNewProduct(product);
        }
    }



    @Disabled(value = "true")
    @Order(2)
    @Rollback(value = false)
    @Test
    void loadOrders(){
        Customer customer1 = customerDAO.findByName("Sample Customer 1");
        Customer customer2 = customerDAO.findByName("Sample Customer 15");
        Customer customer3 = customerDAO.findByName("Sample Customer 9");
        Customer customer4 = customerDAO.findByName("Sample Customer 6");
        for(int i=0;i<100;i++){
            OrderHeader orderHeader = new OrderHeader();
            Customer orderCustomer;
            switch (i%4){
                case 1:
                    orderCustomer = customer1;
                    break;
                case 2:
                    orderCustomer = customer2;
                    break;
                case 3:
                    orderCustomer = customer3;
                    break;
                default:
                    orderCustomer = customer4;
            }
            orderHeader.setCustomer(orderCustomer);
            orderHeader.setOrderStatus(OrderStatus.NEW);
            orderHeader.setShippingAddress(getAddress(i));
            orderHeader.setBillingAddress(getAddress(i));
            orderHeaderDAO.saveNewOrderHeader(orderHeader);
        }
    }


    static Category getCategory(int i){
        switch (i%4){
            case 1:
                return CATEGORY_2;
            case 2:
                return CATEGORY_3;
            case 3:
                return CATEGORY_4;
            default:
                return CATEGORY_1;
        }
    }

    static Address getAddress(int i){
        switch (i%4){
            case 1:
                return ADDRESS_2;
            case 2:
                return ADDRESS_3;
            case 3:
                return ADDRESS_4;
            default:
                return ADDRESS_1;
        }
    }



    static String getLastFourDigits(int count){
        if(count<10)
            return "000" + count;
        else if(count<100)
            return "00" + count;
        else if(count<1000)
            return "0" + count;
        return Integer.toString(count);
    }



}


