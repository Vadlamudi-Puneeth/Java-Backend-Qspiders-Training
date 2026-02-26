package com.example.pac.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pac.model.Category;
import com.example.pac.repository.CategoryRepository;
import com.example.pac.exceptions.CategoryNotFoundException;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public Category save(Category c){
        return repo.save(c);
    }

    public List<Category> getAll(){
        return repo.findAll();
    }

    public Category getById(Long id){
        return repo.findById(id)
                .orElseThrow(() ->
                        new CategoryNotFoundException("Category not found"));
    }
}