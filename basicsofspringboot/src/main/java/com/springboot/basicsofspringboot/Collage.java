package com.springboot.basicsofspringboot;

import java.util.List;

public class Collage {
	private String name;
	private String location;
	
	private List<Student> student;

	public Collage(String name, String location, List<Student> student) {
		super();
		this.name = name;
		this.location = location;
		this.student = student;
	}
	
	public Collage() {}

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

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Collage [name=" + name + ", location=" + location + ", student=" + student + "]";
	}
	
	
	
}
