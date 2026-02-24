package com.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "dept")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String location;
	private String headDoctorName;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private List<Doctor> doctors = new ArrayList<>();

	public Department(String name, String location, String headDoctorName) {
		super();
		this.name = name;
		this.location = location;
		this.headDoctorName = headDoctorName;
	}
	
	public void addDoctor(Doctor d) {
	    doctors.add(d);
	    d.setDepartment(this);
	}

	public void removeDoctor(Doctor d) {
	    doctors.remove(d);
	    d.setDepartment(null);
	}
	
	public Department() {}


	public long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getHeadDoctorName() {
		return headDoctorName;
	}


	public void setHeadDoctorName(String headDoctorName) {
		this.headDoctorName = headDoctorName;
	}


	public List<Doctor> getDoctors() {
		return doctors;
	}


	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}


	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", location=" + location + ", headDoctorName="
				+ headDoctorName + ", doctors=" + doctors + "]";
	}
	
	
	
	
	
}
