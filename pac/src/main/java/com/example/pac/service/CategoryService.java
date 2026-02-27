package com.example.pac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.pac.exceptions.CategoryNotFoundException;
import com.example.pac.model.Category;
import com.example.pac.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public List<Category> saveAll(List<Category> c){
        return repo.saveAll(c);
    }
    
    
    
    public Category updateCategory(Long id, Category c){

        Category category = repo.findById(id)
                .orElseThrow(() ->
                    new CategoryNotFoundException("Category not found"));

        category.setCategoryName(c.getCategoryName());
        category.setDescription(c.getDescription());

        return repo.save(category);
    }
    
    public void deleteCategory(Long id){

        Category category = repo.findById(id)
                .orElseThrow(() ->
                    new CategoryNotFoundException("Category not found"));

        repo.delete(category);
    }


    public Category getById(Long id){
        return repo.findById(id)
                .orElseThrow(() ->
                        new CategoryNotFoundException("Category not found"));
    }
    
    public List<Category> getCategories(int page, int size) {

        Page<Category> categoryPage =
                repo.findAll(PageRequest.of(page, size));

        return categoryPage.getContent();
    }
    
    public List<Category> getSort(int page, int size){
        Page<Category> categoryPage =
                repo.findAll(PageRequest.of(page, size, Sort.by("categoryId").descending()));

        return categoryPage.getContent();
    }
    
}