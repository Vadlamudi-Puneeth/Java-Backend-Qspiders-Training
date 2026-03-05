package com.example.springbootthreemarch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootthreemarch.dto.StudentDTO;
import com.example.springbootthreemarch.entity.Student;
import com.example.springbootthreemarch.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {

	StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

    @PostMapping("/create")
    public Student addStudent(@Valid @RequestBody Student s) {
        return studentService.addStudent(s);
    }
	
    @GetMapping("/find/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
	
}

