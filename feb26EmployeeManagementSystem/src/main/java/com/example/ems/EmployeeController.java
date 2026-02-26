package com.example.ems;

import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeJpaRepository ejr;

    public EmployeeController(EmployeeJpaRepository ejr){
        this.ejr = ejr;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee e){
        return ejr.save(e);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return ejr.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){

        return ejr.findById(id)
                .orElseThrow(() ->
                    new EmployeeNotFoundException(
                        "Employee not found with id "+id));
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee e){

        Employee emp = ejr.findById(id)
                .orElseThrow(() ->
                    new EmployeeNotFoundException(
                        "Employee not found"));

        emp.setName(e.getName());
        emp.setEmail(e.getEmail());
        emp.setDepartment(e.getDepartment());
        emp.setSalary(e.getSalary());

        return ejr.save(emp);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){

        Employee emp = ejr.findById(id)
                .orElseThrow(() ->
                    new EmployeeNotFoundException(
                        "Employee not found"));

        ejr.delete(emp);
        return "Employee deleted successfully";
    }

    @GetMapping("/department/{name}")
    public List<Employee> findByDepartment(
            @PathVariable String name){

        return ejr.findByDepartment(name);
    }

    @GetMapping("/highsalary")
    public List<Employee> highSalary(
            @RequestParam double value){

        return ejr.findBySalaryGreaterThan(value);
    }

    @GetMapping("/count")
    public long countEmployees(){
        return ejr.count();
    }

    @GetMapping("/sort")
    public List<Employee> sortBySalary(){

        return ejr.findAll(
                Sort.by("salary").descending());
    }

    @GetMapping("/page")
    public Page<Employee> pagination(@RequestParam int page, @RequestParam int size){

        Pageable pageable =
                PageRequest.of(page, size);

        return ejr.findAll(pageable);
    }

    @GetMapping("/above-average")
    public List<Employee> salaryAboveAverage(){
        return ejr.salaryAboveAverage();
    }
}