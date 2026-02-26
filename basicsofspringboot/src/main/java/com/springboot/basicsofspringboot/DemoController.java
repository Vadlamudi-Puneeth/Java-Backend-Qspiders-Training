package com.springboot.basicsofspringboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
//	@Autowired // field injection
//	CarJpaRepository cjr;
	
//	@PostMapping("/api")
//	public Set<String> hello() {
//		return Set.of("Miller", "Bravis", "Makram"); // JSON collection
//	}
//	
//	@PostMapping("/add")
//	public String createCricketer(@RequestBody Cricketer c) {
//		// take http request json and converts into object
//		System.out.println(c);
//		return c.toString();
//	}
	
//	@PostMapping("/car")
//	public String createCar(@RequestBody Car c) {
//		return cjr.save(c).toString();
//	}
//	
//	@GetMapping("/id")
//	public Car getById(@RequestParam int id) {
//	    return cjr.findById(id)
//	              .orElseThrow(() -> new RuntimeException("Car not found"));
//	}
//	
//	@GetMapping("/all")
//	public List<Car> getAllCars(){
//		return cjr.findAll();
//	}
//	
//	@DeleteMapping("/delete/{id}")
//	public boolean deleteCar(@PathVariable int id) {
//		Optional<Car> car = cjr.findById(id);
//		if(car.isPresent()) {
//			cjr.delete(car.get());
//			return true;
//		}else {
//			return false;
//		}
//	}
//	
//	@PutMapping("/update/{id}")
//	public boolean updateCar(@PathVariable int id,@RequestBody Car c) {
//		Optional<Car> optional = cjr.findById(id);
//		if(optional.isPresent()) {
//			Car car = optional.get();
//			car.setBrand(c.getBrand());
//			car.setPrice(c.getPrice());
//			cjr.save(car);
//			return true;
//		}
//		return false;
//	}
//	
//	
//	@PatchMapping("/update-price/{id}")
//	public boolean updatePrice(@PathVariable int id,@RequestBody Car c) {
//		Optional<Car> optional = cjr.findById(id);
//		if(optional.isPresent()) {
//			Car car = optional.get();
//			car.setPrice(c.getPrice());
//			cjr.save(car);
//			return true;
//		}
//		return false;
//	}
//	
//	@GetMapping("/price/{price}")
//	public Car getCarByPrice(@PathVariable double price) {
//		return cjr.getByPrice(price);
//	}
//	
	
//	@PostMapping("/person")
//	public List<String> getPerson(@RequestBody Person p){
//		return p.getItem();
//	}
//	
//	@PostMapping("/collage")
//	public String getStudentsWithCollage(@RequestBody Collage c) {
//		return c.getName() + " " + c.getLocation() +  " \n" + c.getStudent();
//	}
	
	
	@Autowired
	CustomerJpaRepository cjr;
	
	@PostMapping("/customer")
	public void createCustomer(@RequestBody Customer c) {
		cjr.save(c);
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable long id) {
		Optional<Customer> c = cjr.findById(id);
	
		return c.get();
		
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return cjr.findAll();
	}
	
	@PutMapping("/update/{id}")
	public boolean updateCustomerById(@PathVariable Long id, @RequestBody Customer c) {
		Optional<Customer> optional = cjr.findById(id);
		
		if(optional.isPresent()) {
			Customer customer = optional.get();
			customer.setPhone(c.getPhone());
			customer.setEmail(c.getEmail());
			customer.setName(c.getName());
			customer.setAge(c.getAge());
			customer.setGender(c.getGender());
			customer.setDob(c.getDob());

			
			cjr.save(customer);
			return true;
			
		}
		return false;
		
	}
	
	@PatchMapping("/update-phone/{id}")
	public boolean updatePhoneById(@PathVariable Long id, @RequestBody Customer c) {
		Optional<Customer> optional = cjr.findById(id);
		
		if(optional.isPresent()) {
			Customer customer = optional.get();
			customer.setPhone(c.getPhone());
			
			cjr.save(customer);
			return true;
			
		}
		return false;
		
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable long id) {
		Customer c = cjr.findById(id).get();
		if(c != null) {
			cjr.delete(c);
			return true;
		}
		return false;
	}
	
}
