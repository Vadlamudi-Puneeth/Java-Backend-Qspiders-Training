package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeJpaRepo;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeJpaRepo repo;

    // -------- SAVE EMPLOYEE --------
    public void save(Employee emp) {
        repo.save(emp);
    }

    // -------- LOGIN CHECK --------
    public Employee findByEmailAndPassword(String email,
                                           String password) {

        return repo.findByEmailAndPassword(email, password);
    }
    
    public ModelAndView getAdminPage() {

        ModelAndView mv = new ModelAndView();

        List<Employee> employees = repo.findAll();

        mv.addObject("list_of_employees", employees);
        mv.setViewName("admin");

        return mv;
    }
    
    public void deleteEmployee(String email) {
        repo.deleteById(email);
    }
    
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }
    
}