package com.tca.repository;

import java.util.List;
import java.util.Map;

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
	

	public Map<String, Object> getSpecificRecord(int rno) 
	{
		
	    String sql = "SELECT * FROM student WHERE rno = ?";

	    return jdbcTemplate.queryForMap(sql, rno);
	}
	
	public List<Map<String, Object>> getAllRecord()
	{
	    String sql = "SELECT * FROM student";
	    return jdbcTemplate.queryForList(sql);
	}
	
	public List<Map<String, Object>> getAllRecordCityWise(String city)
	{
		return jdbcTemplate.queryForList("SELECT * FROM student WHERE city=?",city);
	}



}