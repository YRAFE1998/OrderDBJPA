package com.yousef.orderservice.bootstrap;

import com.yousef.orderservice.model.*;
import com.yousef.orderservice.repositories.CategoryRepository;
import com.yousef.orderservice.repositories.CustomerRepository;
import com.yousef.orderservice.repositories.OrderHeaderRepository;
import com.yousef.orderservice.repositories.ProductRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderDataGetter orderDataGetter;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Product product =new Product();
        product.setProductStatus(ProductStatus.NEW);
        Category cat = categoryRepository.findById(3L).get();
        HashSet<Category> categories = new HashSet<>();
        categories.add(cat);
        product.setCategories(categories);
        product.setQuantityOnHand(5);
        product.setDescription("Product sample x");

        Product savedProduct = productRepository.saveAndFlush(product);
        savedProduct.setQuantityOnHand(4);
        productRepository.saveAndFlush(savedProduct);


    }

//    @Transactional
//    public void readOrderData(){
//        OrderHeader orderHeader = orderHeaderRepository.findById(26L).get();
//        orderHeader.getOrderLines().forEach((orderLine) ->{
//            System.out.println("Description  + " + orderLine.getProduct().getDescription());
//            orderLine.getProduct().getCategories().forEach(category -> {
//                System.out.println(category.getDescription());
//            });
//        });
//    }


}
