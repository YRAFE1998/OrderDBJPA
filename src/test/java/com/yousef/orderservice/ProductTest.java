package com.yousef.orderservice;

import com.yousef.orderservice.DAO.ProductDAO;
import com.yousef.orderservice.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@ComponentScan("com.yousef.orderservice.DAO")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductTest {

    @Autowired
    ProductDAO productDAO;

    @Transactional
    @Test
    void testGetById(){

        Product p1 = new Product();
        p1.setProductStatus(ProductStatus.NEW);
        Product returnedProduct = productDAO.saveNewProduct(p1);

        assertThat(productDAO.getById(returnedProduct.getId())).isNotNull();

    }

    @Transactional
    @Test
    void testUpdate(){
        Product p1 = new Product();
        p1.setProductStatus(ProductStatus.NEW);
        Product returnedProduct = productDAO.saveNewProduct(p1);
        returnedProduct.setProductStatus(ProductStatus.IN_STOCK);
        Product updated = productDAO.updateProduct(returnedProduct);
        assertThat(updated.getProductStatus()).isEqualTo(ProductStatus.IN_STOCK);
    }


    @Test
    void testGetProductByDescription(){
        Product fetchedProduct = productDAO.getByDescription("PRODUCT1");
        assertThat(fetchedProduct).isNotNull();
    }
    @Test
    void testsaveNewOrderHeader(){
        Product p1 = new Product();
        p1.setProductStatus(ProductStatus.NEW);
        Product saved = productDAO.saveNewProduct(p1);
        assertThat(saved).isNotNull();
    }

    @Transactional
    @Test
    void testDelete(){
        Product p1 = new Product();
        p1.setProductStatus(ProductStatus.NEW);
        Product saved = productDAO.saveNewProduct(p1);
        productDAO.deleteById(saved.getId());
        assertThat(productDAO.getById(saved.getId())).isNull();

    }
}
