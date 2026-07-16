package com.tca.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.model.Student;
import com.tca.repository.StudentRepository;

@Service
public class StudentService
{
	@Autowired
	StudentRepository studentRepository;
	
	public Student getStudentId(String studentId)
	{
		return studentRepository.findById(studentId);
	}
	
	public Map<String,Student> getAllStudent()
	{
		
		return studentRepository.displayAll();
	}
}
