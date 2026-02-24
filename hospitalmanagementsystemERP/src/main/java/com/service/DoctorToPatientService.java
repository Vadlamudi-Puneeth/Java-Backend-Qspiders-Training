package com.service;

import java.time.LocalDate;
import java.util.List;

import com.model.Doctor;
import com.model.Patient;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DoctorToPatientService {
	 EntityManager em;

	    public DoctorToPatientService(EntityManager em){
	        this.em = em;
	    }

	    public void createAssignments(){

	        EntityTransaction tx = em.getTransaction();
	        tx.begin();

	        Doctor mehta = new Doctor("Mehta","Cardiology","LIC101");
	        Doctor singh = new Doctor("Singh","Neurology","LIC102");

	        Patient ali   = new Patient("Ali",LocalDate.of(2000,1,1),"O+","999");
	        Patient priya = new Patient("Priya",LocalDate.of(1998,5,5),"A+","888");
	        Patient raj   = new Patient("Raj",LocalDate.of(1995,3,3),"B+","777");

	        mehta.addPatient(ali);
	        mehta.addPatient(priya);

	        singh.addPatient(ali);
	        singh.addPatient(raj);

	        em.persist(mehta);
	        em.persist(singh);

	        tx.commit();

	        System.out.println("Assignments saved");
	    }


	    public void patientsOfDoctor(String name){

	        Doctor d = em.createQuery(
	                "SELECT d FROM Doctor d JOIN FETCH d.patients WHERE d.name=:n",
	                Doctor.class)
	                .setParameter("n",name)
	                .getSingleResult();

	        System.out.println("\nPatients of "+name+":");

	        for(Patient p : d.getPatients()){
	            System.out.println(p.getName());
	        }
	    }


	    public void doctorsOfPatient(String pname){

	        List<Doctor> list = em.createQuery(
	                "SELECT d FROM Doctor d JOIN d.patients p WHERE p.name=:n",
	                Doctor.class)
	                .setParameter("n",pname)
	                .getResultList();

	        System.out.println("\nDoctors treating "+pname+":");

	        for(Doctor d:list){
	            System.out.println(d.getName());
	        }
	    }


	    public void discharge(long doctorId,long patientId){

	        EntityTransaction tx = em.getTransaction();
	        tx.begin();

	        Doctor d = em.find(Doctor.class,doctorId);
	        Patient p = em.find(Patient.class,patientId);

	        d.removePatient(p);

	        tx.commit();

	        System.out.println("Patient discharged");
	    }


	    public void lazyExceptionDemo(long doctorId){

	        Doctor d = em.find(Doctor.class,doctorId);

	        System.out.println(d.getPatients().size());
	    }
}
