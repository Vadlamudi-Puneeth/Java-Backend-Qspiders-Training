package com.example.pac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pac.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
