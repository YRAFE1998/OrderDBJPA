package com.yousef.orderservice.DAO;

import com.yousef.orderservice.model.Product;
import com.yousef.orderservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDAOImpl implements ProductDAO{

    @Autowired
    ProductRepository productRepository;


    @Override
    public Product getByDescription(String description) {
        return productRepository.findByDescription(description).orElse(null);
    }


    @Override
    public Product saveNewProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        if(product.getId() == null)
            return null;
        return productRepository.save(product);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }


}
