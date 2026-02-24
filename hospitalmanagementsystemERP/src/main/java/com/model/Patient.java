package com.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private LocalDate dob;
	private String bloodGroup;
	private String phone;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "med_record_id")
	private MedicalRecord medicalRecord;
	
	@ManyToMany(mappedBy = "patients")
	private List<Doctor> doctors = new ArrayList<>();

	public Patient(String name, LocalDate dob, String bloodGroup, String phone) {
		super();
		this.name = name;
		this.dob = dob;
		this.bloodGroup = bloodGroup;
		this.phone = phone;
	}
	
	
	public Patient() {}


	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public String getBloodGroup() {
		return bloodGroup;
	}


	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}


	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}


	public List<Doctor> getDoctors() {
		return doctors;
	}


	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}


	@Override
	public String toString() {
	    return "Patient [id=" + id +
	            ", name=" + name +
	            ", dob=" + dob +
	            ", bloodGroup=" + bloodGroup +
	            ", phone=" + phone + "]";
	}
	
	
	
	
	
}
