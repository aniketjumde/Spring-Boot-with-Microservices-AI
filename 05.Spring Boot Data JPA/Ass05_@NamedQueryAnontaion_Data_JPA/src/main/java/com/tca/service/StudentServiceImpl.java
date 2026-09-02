package com.tca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.tca.entity.Student;
import com.tca.enums.Gender;
import com.tca.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> findAllByGreaterThanPerAndGender(@Param("per") Double per,@Param("gender") Gender gender) {
		return  studentRepository.findAllByGreaterThanPerAndGender(per, gender);
	}

	@Override
	public List<Student> findAllByGreaterThanPerAndGenderUsingSQL(Double per, Gender gender) {
		return  studentRepository.findAllByGreaterThanPerAndGenderUsingSQL(per, gender);

	}

	@Override
	public List<Object[]> findAllNameAndPer() {
		return studentRepository.findAllNameAndPer();
	}

	@Override
	public List<Object[]> findAllNameAndPerUsingSQL() {
		return studentRepository.findAllNameAndPerUsingSQL();
	}

	@Override
	public List<Object[]> fetchGenderWiseCount() {
		return studentRepository.findGenderWiseCount();
	}

	@Override
	public void updateStudentName(String name,Integer rno) {
		studentRepository.updateStudentName(name,rno);
	}

	
}
