package com.example.pac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pac.model.*;
import com.example.pac.repository.*;
import com.example.pac.exceptions.*;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    public Product addProduct(Long categoryId,
                              Product product){

        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() ->
                        new CategoryNotFoundException("Category not found"));

        product.setCategory(category);

        return productRepo.save(product);
    }
    
    public Product updateProduct(Long id, Product p){

        Product product = productRepo.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Product not found"));

        product.setProductName(p.getProductName());
        product.setPrice(p.getPrice());

        return productRepo.save(product);
    }
    
    public Product getProductById(Long id){
        return productRepo.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Product not found"));
    }
    
    public void deleteProduct(Long id){

        Product product = productRepo.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Product not found"));

        productRepo.delete(product);
    }
    
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public List<Product> getProductsByCategory(Long categoryId){
        return productRepo
                .findByCategoryCategoryId(categoryId);
    }

    public List<Product> search(String name){
        return productRepo
                .findByProductNameContaining(name);
    }
}