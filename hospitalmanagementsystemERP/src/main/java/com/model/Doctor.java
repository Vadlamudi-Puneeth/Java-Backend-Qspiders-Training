package com.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctors")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String specialization;
	private String licenseNo;
	
	public void removePatient(Patient p) {
	    patients.remove(p);
	    p.getDoctors().remove(this);
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id")
	private Department department;
	
	@ManyToMany(cascade = {
			CascadeType.PERSIST, CascadeType.MERGE
	})
	@JoinTable(
				name = "patient_doctors",
				joinColumns = @JoinColumn(name = "doctor_id"),
				inverseJoinColumns = @JoinColumn(name = "patient_id")
			)
	private List<Patient> patients = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id")
	private List<Appointment> appointments = new ArrayList<>();

	public Doctor(String name, String specialization, String licenseNo) {
		super();
		this.name = name;
		this.specialization = specialization;
		this.licenseNo = licenseNo;
	}
	
	
	
	public Doctor() {}


	public void addPatient(Patient p) {
		patients.add(p);
		p.getDoctors().add(this);
	}

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSpecialization() {
		return specialization;
	}



	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}



	public String getLicenseNo() {
		return licenseNo;
	}



	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}



	public Department getDepartment() {
		return department;
	}



	public void setDepartment(Department department) {
		this.department = department;
	}



	public List<Patient> getPatients() {
		return patients;
	}



	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}



	public List<Appointment> getAppointments() {
		return appointments;
	}



	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}



	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", specialization=" + specialization + ", licenseNo=" + licenseNo
				+ ", department=" + department + ", patients=" + patients + ", appointments=" + appointments + "]";
	}
	
	
	
	
	
	
}
