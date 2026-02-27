package com.example.product_controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.OpenAPI;

@OpenAPIDefinition(
        info = @Info(
                title = "Product & Category Management API",
                version = "1.0",
                description = "REST API for managing Products and Categories",
                contact = @Contact(
                        name = "Puneeth",
                        email = "nanipuneeth00@gmail.com"
                ),
                license = @License(
                        name = "Apache 2.0"
                )
        )
)
@SpringBootApplication
public class ProductControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductControllerApplication.class, args);
	}
	
	@Bean
	public OpenAPI getOpenAPI() {
		return new OpenAPI();
	}

}
