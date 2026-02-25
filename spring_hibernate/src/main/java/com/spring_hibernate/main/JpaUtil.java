package com.spring_hibernate.main;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


@Component
public class JpaUtil {
	
	public EntityManagerFactory getEmf() {
		return emf;
	}


	public EntityManager getEm() {
		return em;
	}

	private EntityManagerFactory emf;
	
	private EntityManager em;
	
    @PostConstruct
    public void createConnection() {
        System.out.println("PostConstruct called - about to connect...");
        emf = Persistence.createEntityManagerFactory("mysql");
        em = emf.createEntityManager();
        System.out.println("connection established successfully!");
    }
    
    @PreDestroy
    public void print() {
    	System.out.println("end");
    	emf.close();
    	em.close();
    }
	
}
