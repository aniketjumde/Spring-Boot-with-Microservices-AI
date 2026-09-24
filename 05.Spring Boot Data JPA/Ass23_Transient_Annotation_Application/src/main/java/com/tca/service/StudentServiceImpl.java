package com.tca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.entity.Student;
import com.tca.repository.StudentRepository;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student fetchStudent(Long rno) {
		return studentRepository.findById(rno).orElse(null);
	}

}
