package com.yousef.orderservice.DAO;

import com.yousef.orderservice.model.Product;
import org.springframework.stereotype.Component;

@Component
public interface ProductDAO {
    Product saveNewProduct(Product product);
    Product updateProduct(Product product);
    Product getById(Long id);
    void deleteById(Long id);
    Product getByDescription(String description);

}
