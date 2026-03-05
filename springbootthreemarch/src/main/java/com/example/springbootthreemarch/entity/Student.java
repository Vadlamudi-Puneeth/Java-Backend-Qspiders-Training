package com.example.springbootthreemarch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank	
	private String name;
	
	@NotBlank
	private String collage;
	
	@NotBlank
	private double marks;
	
//	@Email
	@NotBlank
	@Pattern(
		    regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
		    message = "Invalid email"
		)
	private String email;
	
	@NotBlank
	private String gender;
	
	public Student() {}

	public Student(int id, String name, String collage, double marks, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.collage = collage;
		this.marks = marks;
		this.gender = gender;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollage() {
		return collage;
	}

	public void setCollage(String collage) {
		this.collage = collage;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", collage=" + collage + ", marks=" + marks + ", gender="
				+ gender + "]";
	}
	
	
	
}
