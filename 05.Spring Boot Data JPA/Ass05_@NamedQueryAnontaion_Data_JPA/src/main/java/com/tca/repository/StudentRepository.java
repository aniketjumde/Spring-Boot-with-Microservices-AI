package com.tca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tca.entity.Student;
import com.tca.enums.Gender;

import jakarta.transaction.Transactional;

public interface StudentRepository extends CrudRepository<Student,Integer> {
	
	public List<Student> findAllByGreaterThanPerAndGender(@Param("per") Double per,@Param("Gender") Gender gender);
	
	public List<Student> findAllByGreaterThanPerAndGenderUsingSQL(@Param("per") Double per,@Param("Gender") Gender gender);
	
	public List<Object[]> findAllNameAndPer();
	
	public List<Object[]> findAllNameAndPerUsingSQL();
	
	public List<Object[]>  findGenderWiseCount();
	
	@Modifying
	@Transactional
	public void updateStudentName(@Param("name") String name,@Param("rno") Integer rno);
}
