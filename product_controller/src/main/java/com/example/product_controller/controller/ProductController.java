package com.example.product_controller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.product_controller.model.Product;
import com.example.product_controller.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/category/{categoryId}")
    public ResponseEntity<Product> addProduct(
            @PathVariable Long categoryId,
            @RequestBody Product product){

        Product savedProduct = service.addProduct(categoryId, product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){

        return ResponseEntity.ok(service.getAllProducts());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getProducts(
            @PathVariable Long categoryId){

        return ResponseEntity.ok(
                service.getProductsByCategory(categoryId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(
            @PathVariable Long id){

        return ResponseEntity.ok(
                service.getProductById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @RequestBody Product p){

        Product updatedProduct =
                service.updateProduct(id, p);

        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(
            @PathVariable Long id){

        service.deleteProduct(id);

        return ResponseEntity.ok(
                "Product Deleted Successfully");
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> search(
            @RequestParam String name){

        return ResponseEntity.ok(
                service.search(name));
    }
}