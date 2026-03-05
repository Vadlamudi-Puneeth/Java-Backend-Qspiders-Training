package com.example.springbootthreemarch.dto;

import com.example.springbootthreemarch.entity.Student;

public class StudentMapper {

	public static Student createStudent(StudentDTO dto) {
		Student s = new Student();
		s.setName(dto.getName());
		s.setGender(dto.getGender());
		s.setMarks(dto.getMarks());
		s.setCollage(dto.getCollage());
		s.setEmail(dto.getEmail());
		
		return s;
	}
	
	public static StudentDTO createStudentDTO(Student s) {
		StudentDTO dto = new StudentDTO();
		dto.setName(s.getName());
		dto.setMarks(s.getMarks());
		
		return dto;
	}
	
}
