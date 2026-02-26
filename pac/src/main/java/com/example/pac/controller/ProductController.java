package com.example.pac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.pac.model.Product;
import com.example.pac.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/category/{categoryId}")
    public Product addProduct(
            @PathVariable Long categoryId,
            @RequestBody Product product){

        return service.addProduct(categoryId, product);
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getProducts(
            @PathVariable Long categoryId){

        return service.getProductsByCategory(categoryId);
    }

    @GetMapping("/search")
    public List<Product> search(
            @RequestParam String name){

        return service.search(name);
    }
}