package com.onetoone;

import jakarta.persistence.Persistence;

public class User {
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("mysql");
		
	}
}
