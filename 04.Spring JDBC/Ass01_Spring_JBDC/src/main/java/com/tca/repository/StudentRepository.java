package com.tca.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tca.model.Student;

@Repository
public class StudentRepository 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public StudentRepository() {}
	
	public int save(Student student)
	{
		
		return jdbcTemplate.update("INSERT INTO student VALUES(?,?,?,?)",student.getRno(),student.getName(),student.getPer(),student.getCity());
	}
	
	public int delete(int rno)
	{
		return jdbcTemplate.update("DELETE FROM student Where rno=?",rno);
	}
	
	public int updateRecord(Student ob)
	{
		return jdbcTemplate.update("Update student set name=?,per=?,city=? Where rno=?",ob.getName(),ob.getPer(),ob.getCity(),ob.getRno());
	}
}