package com.onetoone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Engine {
	@Id
	private int id;
	private String ss;
	String type;
	String fuelType;
	String mileage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSs() {
		return ss;
	}
	public void setSs(String ss) {
		this.ss = ss;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public Engine(int id, String ss, String type, String fuelType, String mileage) {
		super();
		this.id = id;
		this.ss = ss;
		this.type = type;
		this.fuelType = fuelType;
		this.mileage = mileage;
	}
	
	
	
	
}
