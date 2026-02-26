package com.example.pac.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.pac.model.Category;
import com.example.pac.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping
    public Category create(@RequestBody Category c){
        return service.save(c);
    }

    @GetMapping
    public List<Category> all(){
        return service.getAll();
    }
}