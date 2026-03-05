package com.practise.cachepractise.service;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.practise.cachepractise.entity.Product;
import com.practise.cachepractise.repo.ProductRepository;

@Service
public class ProductService {
	
	private ProductRepository repo;
	
	public ProductService(ProductRepository repo) {
		this.repo = repo;
	}
	
	@CachePut(cacheNames = "product", key = "#result.id")
	public Product addProduct(Product p) {
		return repo.save(p);
	}
	
	@Cacheable(cacheNames = "product", key = "#id")
	public Product getById(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
	}
	
}
