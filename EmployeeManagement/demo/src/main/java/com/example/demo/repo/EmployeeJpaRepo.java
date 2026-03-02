package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employee;

public interface EmployeeJpaRepo extends JpaRepository<Employee, String>{

	Employee findByEmailAndPassword(String email,
            String password);
	
}
