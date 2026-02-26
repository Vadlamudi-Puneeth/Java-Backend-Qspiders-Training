package com.springboot.basicsofspringboot;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Doctor {
	
	public void check() {
		System.out.println("Temp");
	}
}
