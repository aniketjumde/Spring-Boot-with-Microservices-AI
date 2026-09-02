package com.tca.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.tca.entity.Student;
import com.tca.enums.Gender;

public interface StudentService {

	public List<Student> findAllByGreaterThanPerAndGender(Double per,Gender gender);
	public List<Student> findAllByGreaterThanPerAndGenderUsingSQL(Double per,Gender gender);
	public List<Object[]> findAllNameAndPer();
	public List<Object[]> findAllNameAndPerUsingSQL();
	public List<Object[]> fetchGenderWiseCount();
	public void updateStudentName(String name,Integer rno);

}
