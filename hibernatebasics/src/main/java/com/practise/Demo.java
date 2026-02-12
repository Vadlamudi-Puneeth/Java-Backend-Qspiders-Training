package com.practise;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Demo {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager(); // to do CRUD
		
		EntityTransaction et = em.getTransaction();
		
		Student s = new Student();
		s.setId(1);
		s.setName("nani");
		s.setPercentage(90);
		
		et.begin();
		em.persist(s);
		et.commit();
		
		emf.close();
		
	}
}
