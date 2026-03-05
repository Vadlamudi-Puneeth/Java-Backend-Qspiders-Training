package com.practise.cachepractise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practise.cachepractise.entity.Product;
import com.practise.cachepractise.service.ProductService;

@RestController
public class ProductController {

	private ProductService service;
	
	public ProductController(ProductService service) {
		this.service = service;
	}
	
	@PostMapping("/create")
	public Product addProduct(@RequestBody Product p) {
		return service.addProduct(p);
	}
	
	@GetMapping("/find-id/{id}")
	public Product getProductById(@PathVariable Long id) {
		return service.getById(id);
	}
	
//	@PutMapping("/update/{id}")
//	public Product updateProduct(@)
	
}
