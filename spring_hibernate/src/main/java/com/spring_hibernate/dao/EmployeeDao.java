package com.spring_hibernate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring_hibernate.dto.Employee;
import com.spring_hibernate.main.JpaUtil;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


@Repository
public class EmployeeDao {
	
	@Autowired
	JpaUtil jpa;
	
	private EntityManager entityManager;
	
	@PostConstruct
	public void init() {
		this.entityManager = jpa.getEm();
		System.out.println("EmployeeDao PostConstruct - entityManager set!");
	}
	


	public void insert(Employee e) {
		
		EntityTransaction et = entityManager.getTransaction();
		
		et.begin();
		
		Employee employee = findById(e.getId());
		
		if(employee == null) {
			entityManager.persist(e);
		}else {
			System.out.println("Duplicate Data Found!");
		}
		
		et.commit();
	
	}
	
	public void update(int id, String newName) {
		EntityTransaction et = entityManager.getTransaction();

		Employee e = findById(id);

		et.begin();
		
		if(e != null) {
			e.setName(newName);
			entityManager.persist(e);
		}
		
		et.commit();
	}
	
	public void delete(int id) {
		EntityTransaction et = entityManager.getTransaction();
		et.begin();
		Employee e = findById(id);
		
		entityManager.remove(e);
		et.commit();
		
	}
	
	public Employee findById(int id) {
		return entityManager.find(Employee.class, id);
	}
	
}
