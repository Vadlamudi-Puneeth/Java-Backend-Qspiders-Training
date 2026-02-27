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
    
    @GetMapping
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getProducts(
            @PathVariable Long categoryId){

        return service.getProductsByCategory(categoryId);
    }
    
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return service.getProductById(id);
    }
    
    @PutMapping("/{id}")
    public Product updateProduct(
            @PathVariable Long id,
            @RequestBody Product p){

        return service.updateProduct(id, p);
    }
    
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){

        service.deleteProduct(id);
        return "Product Deleted Successfully";
    }

    @GetMapping("/search")
    public List<Product> search(
            @RequestParam String name){

        return service.search(name);
    }
}