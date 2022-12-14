package com.yousef.orderservice.repositories;

import com.yousef.orderservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    Optional<Product> findByDescription(String description);
}
