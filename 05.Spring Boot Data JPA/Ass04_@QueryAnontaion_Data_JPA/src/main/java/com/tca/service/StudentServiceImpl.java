package com.tca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.entity.Student;
import com.tca.enums.Gender;
import com.tca.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> fetchAllStudent() {
		return studentRepository.fetchByAllUsingJPQL();
	}

	@Override
	public List<Student> fetchByPerBetweenStudent(Double start, Double end) {
		return studentRepository.findPercentageRangeUsingJPQL(start, end);
	}

	@Override
	public List<Object[]> fetchByGenderAndPer(Gender gender, Double per) {
		return studentRepository.findByGenderAndPerUsingJPQL(gender, per);
	}

	@Override
	public void updateByName(String name, int rno) {
		studentRepository.updateByName(name, rno);
	}

	@Override
	public void deleteByRno(Integer rno) 
	{
		studentRepository.deleteByrno(rno);
	}
	
}
