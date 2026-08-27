package com.tca.service;

import java.util.List;
import java.util.Optional;

import com.tca.entity.Student;

public interface StudentService {

	public Student saveStudent(Student student);
	public Student updateStudent(Student student);
	public Optional<Student> findById(int rno);
	public List<Student> findAllById(List<Integer> ids);
	public List<Student> fetchAllStudent();
	public Boolean deleteStudent(int rno);
	public List<Student> saveAll(List<Student> listStudent);
}
