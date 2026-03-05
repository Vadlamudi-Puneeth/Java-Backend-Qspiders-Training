package com.example.springbootthreemarch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	private Long id;
	private String name;
	private double cost_price;
	private double sell_price;
	private int quantity;
	
	
	public Product() {}


	public Product(Long id, String name, double cost_price, double sell_price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.cost_price = cost_price;
		this.sell_price = sell_price;
		this.quantity = quantity;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getCost_price() {
		return cost_price;
	}


	public void setCost_price(double cost_price) {
		this.cost_price = cost_price;
	}


	public double getSell_price() {
		return sell_price;
	}


	public void setSell_price(double sell_price) {
		this.sell_price = sell_price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", cost_price=" + cost_price + ", sell_price=" + sell_price
				+ ", quantity=" + quantity + "]";
	}
	
	
	
	
}
