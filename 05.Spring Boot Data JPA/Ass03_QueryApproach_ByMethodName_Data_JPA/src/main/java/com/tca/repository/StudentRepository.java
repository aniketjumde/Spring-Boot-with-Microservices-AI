package com.tca.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tca.entity.Student;
import com.tca.enums.Gender;

public interface StudentRepository extends CrudRepository<Student,Integer> {
	
	public List<Student> findByGender(Gender gender);
	public List<Student> findByName(String name);
	public List<Student> findByPer(Double per);
	public List<Student> findByBirthDate(LocalDate d);
	public List<Student> findByGenderAndName(Gender gender,String name);
	public List<Student> findByNameOrPer(String name,Double per);
	public List<Student> findByPerLessThan(Double per);
	public List<Student> findByPerGreaterThanEqual(Double per);
	public List<Student> findByPerBetween(Double startPer,Double endPer);
	public List<Student> findByNameLike(String name);
	public List<Student> findByNameContaining(String name);
	public List<Student> findByNameStartsWith(String name);
	public List<Student> findByNameEndsWith(String name);
	public List<Student> findByNameIgnoreCase(String name);
}
