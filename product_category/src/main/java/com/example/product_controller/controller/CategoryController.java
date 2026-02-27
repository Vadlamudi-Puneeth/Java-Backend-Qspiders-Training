package com.example.product_controller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.product_controller.model.Category;
import com.example.product_controller.repository.CategoryRepository;
import com.example.product_controller.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<List<Category>> create(
            @RequestBody List<Category> c){

        List<Category> saved = service.saveAll(c);

        return ResponseEntity
                .status(201)   // CREATED
                .body(saved);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(
            @PathVariable Long id){

        Category category = service.getById(id);

        return ResponseEntity.ok(category);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(
            @PathVariable Long id,
            @RequestBody Category c){

        Category updated = service.updateCategory(id, c);

        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(
            @PathVariable Long id){

        service.deleteCategory(id);

        return ResponseEntity.ok("Category Deleted Successfully");
    }


    @GetMapping("/page")
    public ResponseEntity<List<Category>> getCategory(
            @RequestParam int page,
            @RequestParam int size){

        List<Category> categories =
                service.getCategories(page, size);

        return ResponseEntity.ok(categories);
    }

    @GetMapping("/sort")
    public ResponseEntity<List<Category>> sortById(
            @RequestParam int page,
            @RequestParam int size){

        List<Category> categories =
                service.getSort(page, size);

        return ResponseEntity.ok(categories);
    }
}