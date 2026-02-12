package com.practise;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Demo1 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		
		Student s = em.find(Student.class, 1);
		
		System.out.println(s.getId() + " " + s.getName() + " " + s.getPercentage());
		
		emf.close();
	}
}
