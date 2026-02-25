package com.springboot.basicsofspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


//@Configuration
//@ComponentScan(basePackages = "com")
//@EnableAutoConfiguration // starts tomcat

//Instead of above 3 we can execute below 1

@SpringBootApplication
public class BasicsofspringbootApplication {

	public static void main(String[] args) {
		
		ApplicationContext ioc = SpringApplication.run(BasicsofspringbootApplication.class, args);
	
		Doctor d = ioc.getBean(Doctor.class);
		d.check();
	}

}
