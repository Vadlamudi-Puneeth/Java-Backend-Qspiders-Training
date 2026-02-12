package com.test;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class UpdateAndFind {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager(); // to do CRUD
		
		EntityTransaction et = em.getTransaction();
		
//		String jpql = "select p from Product p where p.price>=?1";
//		
//		Query query = em.createQuery(jpql);
//		query.setParameter(1, 100.0);
//		
//		List<Product> list = query.getResultList();
//		list.forEach(i -> System.out.println(i.getName()));
		
//		String jpql = "select p from Product p where p.name = ?1";
//
//		Query query = em.createQuery(jpql);
//		query.setParameter(1, "kavali");
//
//		List<Product> list = query.getResultList();
//
//		list.forEach(p -> 
//		    System.out.println(p.getName() + " - " + p.getPrice())
//		);
		
//		String jpql = "select p from Product p where p.price >= ?1 and p.quantity >= ?2";
//
//		Query query = em.createQuery(jpql);
//		query.setParameter(1, 40);
//		query.setParameter(2, 3);
//
//		List<Product> list = query.getResultList();
//
//		list.forEach(p -> 
//		    System.out.println(p.getName() + " - " + p.getPrice())
//		);

		String jpql = "update Product p set p.price = ?1 where p.price = ?2";

		et.begin();
		
		Query query = em.createQuery(jpql);
		query.setParameter(1, 88);
		query.setParameter(2, 100);

		int rows = query.executeUpdate();
		et.commit();

		if(rows > 0) {
			System.out.println("updated");
		}else {
			System.out.println("no rows updated");
		}
		
	}
}
