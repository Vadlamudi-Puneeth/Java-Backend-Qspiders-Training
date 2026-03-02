package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // ---------- REGISTER PAGE ----------
    @GetMapping("/hello")
    public String registerPage() {
        return "register";
    }

    // ---------- SAVE EMPLOYEE ----------
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee emp) {

        service.save(emp);

        return "login";
    }

    // ---------- LOGIN PAGE ----------
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/loginCheck")
    public ModelAndView loginCheck(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String role) {

        ModelAndView mv = new ModelAndView();

        Employee emp =
                service.findByEmailAndPassword(email, password);

        // LOGIN FAILED
        if (emp == null) {
            mv.setViewName("failure");
            return mv;
        }

        // ROLE NOT MATCH
        if (!emp.getRole().equalsIgnoreCase(role)) {
            mv.setViewName("role");
            return mv;
        }

        // ADMIN LOGIN
        if (role.equalsIgnoreCase("ADMIN")) {
            return service.getAdminPage();
        }

        // USER LOGIN
        mv.addObject("name", emp.getName());
        mv.setViewName("welcome");

        return mv;
    }
    
    @GetMapping("/editEmployee")
    public ModelAndView editEmployee(@RequestParam String email) {

        ModelAndView mv = new ModelAndView();

        Employee emp = service.getEmployeeByEmail(email);

        mv.addObject("employee", emp);
        mv.setViewName("update");

        return mv;
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute Employee emp) {

        service.updateEmployee(emp);

        return "redirect:/admin";
    }
    
    @PostMapping("/deleteRecord")
    public String deleteRecord(@RequestParam String email) {

        service.deleteEmployee(email);

        return "redirect:/admin";
    }

    // ---------- ADMIN PAGE ----------
    @GetMapping("/admin")
    public ModelAndView adminPage() {

        ModelAndView mv = new ModelAndView();

        List<Employee> employees =
                service.getAllEmployees();

        mv.addObject("list_of_employees", employees);
        mv.setViewName("admin");

        return mv;
    }
    
    
}