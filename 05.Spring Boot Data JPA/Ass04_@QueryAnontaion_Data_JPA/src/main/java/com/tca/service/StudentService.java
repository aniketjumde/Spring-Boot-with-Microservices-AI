package com.tca.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.tca.entity.Student;
import com.tca.enums.Gender;

public interface StudentService {

	public List<Student> fetchAllStudent();
	public List<Student> fetchByPerBetweenStudent(Double start,Double end);
	public List<Object[]> fetchByGenderAndPer(Gender gender,Double per);
	public void updateByName(String name,int rno);
	public void deleteByRno(Integer rno);
	


}
