package com.spring_hibernate.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring_hibernate.ProjectConfiguration;
import com.spring_hibernate.dao.EmployeeDao;
import com.spring_hibernate.dto.Employee;
import com.spring_hibernate.service.EmployeeService;

public class Main {
	
	// single ton design pattern --> one object
	public static void main(String[] args) {
		System.out.println("Main started...");
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
		System.out.println("Context created successfully!");
		ac.close();
	}
}
