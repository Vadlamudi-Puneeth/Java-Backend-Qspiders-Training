package com.example.springbootthreemarch.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootthreemarch.entity.Student;

public interface StudentJpaRepository extends JpaRepository<Student, Long>{

}
