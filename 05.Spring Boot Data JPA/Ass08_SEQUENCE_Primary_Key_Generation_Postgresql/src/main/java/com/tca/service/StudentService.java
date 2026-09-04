package com.tca.service;

import java.util.List;

import com.tca.entity.Student;

public interface StudentService {
	public Student addStudent(Student student);
	public List<Student> findAllStudents();
}
