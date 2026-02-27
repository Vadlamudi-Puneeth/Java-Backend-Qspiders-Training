package com.example.pac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pac.model.Category;
import com.example.pac.repository.CategoryRepository;
import com.example.pac.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService service;
    
    public CategoryController(CategoryService service) {
    	this.service = service;
    }
    
    @Autowired
    private CategoryRepository cr;

    @PostMapping
    public List<Category> create(@RequestBody List<Category> c){
        return service.saveAll(c);
    }
    
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id){
        return service.getById(id);
    }
    
    @PutMapping("/{id}")
    public Category updateCategory(
            @PathVariable Long id,
            @RequestBody Category c){

        return service.updateCategory(id, c);
    }
    
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){

        service.deleteCategory(id);
        return "Category Deleted Successfully";
    }
    
    @GetMapping("/page")
    public List<Category> getCategory(@RequestParam int page, @RequestParam int size) {
        return service.getCategories(page, size);
    }
    
    @GetMapping("/sort")
    public List<Category> sortById(@RequestParam int page, @RequestParam int size) {
        return service.getSort(page, size);
    }


}