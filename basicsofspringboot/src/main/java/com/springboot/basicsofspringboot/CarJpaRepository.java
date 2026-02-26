package com.springboot.basicsofspringboot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarJpaRepository extends JpaRepository<Car, Integer>{
	public Car getByPrice(double price);
}
