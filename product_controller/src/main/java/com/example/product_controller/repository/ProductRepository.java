package com.example.product_controller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product_controller.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    List<Product> findByProductNameContaining(String name);

    List<Product> findByCategoryCategoryId(Long categoryId);
	
}
