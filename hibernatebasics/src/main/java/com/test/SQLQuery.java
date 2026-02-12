package com.test;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class SQLQuery {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager(); // to do CRUD
		
		EntityTransaction et = em.getTransaction();
		
//		String sql = "select * from product";
//		Query query = em.createNativeQuery(sql);
//		List<Product> list = query.getResultList();
//		System.out.println(list);
		
		String sql = "update product set price=:a where price =:b";
		et.begin();
		Query query = em.createNativeQuery(sql);
		query.setParameter("a", 13);
		query.setParameter("b", 15);
		
		query.executeUpdate();
		et.commit();
		
	}
}
