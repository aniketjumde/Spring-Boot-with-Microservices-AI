package com.tca.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.tca.entity.Student;
import com.tca.enums.Gender;

public interface StudentService {

	public Optional<Student> findById(int rno);
	public List<Student> fetchAllStudent();
	public List<Student> fetchByGender(Gender gender);
	public List<Student> fetchByName(String name);
	public List<Student> fetchByPer(Double per);
	public List<Student> fetchByBirthDate(LocalDate d);
	public List<Student> fetchByGenderAndName(Gender gender,String name);
	public List<Student> fetchByNameOrPer(String name,Double per);
	public List<Student> fetchByPerLessThan(Double per);
	public List<Student> fetchByPerGreaterThanEqual(Double per);
	public List<Student> fetchByPerBetween(Double startPer,Double endPer);
	public List<Student> fetchByNameLike(String name);
	public List<Student> fetchByNameContaining(String name);
	public List<Student> fetchByNameStartWith(String name);
	public List<Student> fetchByNameEndWith(String name);
	public List<Student> fetchByNameIgnoreCase(String name);


}
