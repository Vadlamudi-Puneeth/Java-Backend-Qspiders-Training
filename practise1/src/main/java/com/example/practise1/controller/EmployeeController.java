package com.example.practise1.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.practise1.entity.Employee;
import com.example.practise1.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@PostMapping
	public List<Employee> createEmployee(@RequestBody List<Employee> emp) {
		return employeeService.createEmployee(emp);
	}
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Long id) {
		return employeeService.updateEmployee(id);
	}
	
	@DeleteMapping("/{id}")
	public Employee deleteEmployee(@PathVariable Long id) {
		return employeeService.deleteEmployee(id);
	}
	
	@GetMapping("/department/{dept}")
	public List<Employee> findByDepartment(@PathVariable("dept") String dept) {
		return employeeService.findByDepartment(dept);
	}
	
	@GetMapping("/highsalary")
	public List<Employee> highSalary() {
		return employeeService.highSalary();
	}
	
	
	@GetMapping("/sort")
	public List<Employee> sortByEmployee(){
		return employeeService.sortByEmployee();
	}
	
	
	@GetMapping("/page")
	public Page<Employee> pagination(@RequestParam int page, @RequestParam int size){
		return employeeService.getEmployeesByPage(page, size);
	}
	
	
	@GetMapping("/count")
	public double countOfEmployees() {
		return employeeService.countOfEmployees();
	}
	
}
