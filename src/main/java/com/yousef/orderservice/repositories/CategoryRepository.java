package com.yousef.orderservice.repositories;

import com.yousef.orderservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}