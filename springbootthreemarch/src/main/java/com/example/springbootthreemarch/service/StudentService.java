package com.example.springbootthreemarch.service;

import org.springframework.stereotype.Service;

import com.example.springbootthreemarch.dto.StudentDTO;
import com.example.springbootthreemarch.dto.StudentMapper;
import com.example.springbootthreemarch.entity.Student;
import com.example.springbootthreemarch.repo.StudentJpaRepository;

@Service
public class StudentService {

	StudentJpaRepository studentJpaRepository;
	
	public StudentService(StudentJpaRepository studentJpaRepository) {
		this.studentJpaRepository = studentJpaRepository;
	}
	
	public Student addStudent(Student s) {
		return studentJpaRepository.save(s);
	}
	
	public StudentDTO getStudentById(Long id) {

	    Student student = studentJpaRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Student not found"));

	    return StudentMapper.createStudentDTO(student);
	}
	
}
