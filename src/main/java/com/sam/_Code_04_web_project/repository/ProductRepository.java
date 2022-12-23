package com.sam._Code_04_web_project.repository;

import com.sam._Code_04_web_project.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);
}
