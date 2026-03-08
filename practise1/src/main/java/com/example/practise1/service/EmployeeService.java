package com.example.practise1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.practise1.entity.Employee;
import com.example.practise1.repo.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	public List<Employee> createEmployee(List<Employee> emp) {
		return employeeRepository.saveAll(emp);
	}
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).get();
	}
	
	public Employee updateEmployee(Long id) {
		Employee e = employeeRepository.findById(id).get();
		return employeeRepository.save(e);
	}
	
	public Employee deleteEmployee(Long id) {
		Employee e = employeeRepository.findById(id).get();
		employeeRepository.delete(e);
		return e;
	}
	
	public List<Employee> findByDepartment(String dept) {
		List<Employee> emp = employeeRepository.findByDepartment(dept);
		return emp;
	}
	
	public List<Employee> highSalary() {
		double maxSalary =0;
		
		List<Employee> employees = employeeRepository.findAll();
		
		for(Employee e: employees) {
			if(e.getSalary() > maxSalary) {
				maxSalary = e.getSalary();
			}
		}
		
		List<Employee> res = new ArrayList<>();
		
		for(Employee e: employees) {
			if(e.getSalary() == maxSalary) {
				res.add(e);
			}
		}
		
		return res;
		
	}
	
	
	public double countOfEmployees() {
		
		List<Employee> employees = employeeRepository.findAll();
		
		double count = 0;
		
		for(Employee e: employees) {
			count+=1;
		}
		
		return count;
		
		
	}
	
	
	public List<Employee> sortByEmployee(){
		return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "salary"));
	}
	
	public Page<Employee> getEmployeesByPage(int page, int size){

	    Pageable pageable = PageRequest.of(page, size, Sort.by("salary"));

	    return employeeRepository.findAll(pageable);
	}
}
