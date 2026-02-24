package com.service;

import java.util.List;

import com.model.Department;
import com.model.Doctor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DepartmentToDoctorService {
	 private EntityManager em;

	    public DepartmentToDoctorService(EntityManager em) {
	        this.em = em;
	    }

	    public void createDepartmentsAndDoctors() {

	        EntityTransaction tx = em.getTransaction();
	        tx.begin();

	        Department cardio = new Department("Cardiology","Block A","Dr.Head1");
	        Department neuro = new Department("Neurology","Block B","Dr.Head2");

	        Doctor d1 = new Doctor("Smith","Heart","LIC101");
	        Doctor d2 = new Doctor("John","Heart","LIC102");

	        Doctor d3 = new Doctor("David","Brain","LIC201");
	        Doctor d4 = new Doctor("Ravi","Brain","LIC202");

	        cardio.addDoctor(d1);
	        cardio.addDoctor(d2);

	        neuro.addDoctor(d3);
	        neuro.addDoctor(d4);

	        em.persist(cardio);
	        em.persist(neuro);

	        tx.commit();

	        System.out.println("Departments + Doctors saved");
	    }


	    public void navigationTest(long deptId, long doctorId) {

	        Department dept = em.find(Department.class, deptId);

	        System.out.println("\nDoctors in department:");
	        for(Doctor d : dept.getDoctors()){
	            System.out.println(d.getName());
	        }

	        Doctor doc = em.find(Doctor.class, doctorId);
	        System.out.println("\nDoctor belongs to: "
	                + doc.getDepartment().getName());
	    }


	    public void transferDoctor(long doctorId,long newDeptId){

	        EntityTransaction tx = em.getTransaction();
	        tx.begin();

	        Doctor doc = em.find(Doctor.class, doctorId);
	        Department newDept = em.find(Department.class, newDeptId);

	        Department oldDept = doc.getDepartment();

	        if(oldDept!=null){
	            oldDept.removeDoctor(doc);
	        }

	        newDept.addDoctor(doc);

	        tx.commit();

	        System.out.println("Doctor transferred");
	    }


	    public void findDoctorsByDepartment(String name){

	        List<Doctor> list = em.createQuery(
	                "SELECT d FROM Doctor d WHERE d.department.name = :dname",
	                Doctor.class)
	                .setParameter("dname", name)
	                .getResultList();

	        System.out.println("\nDoctors in "+name+":");

	        for(Doctor d:list){
	            System.out.println(d.getName());
	        }
	    }
	}
