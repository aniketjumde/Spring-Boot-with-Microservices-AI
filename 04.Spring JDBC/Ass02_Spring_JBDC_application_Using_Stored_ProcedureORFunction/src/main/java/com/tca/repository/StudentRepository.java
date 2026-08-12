package com.tca.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository 
{
	@Autowired
	private SimpleJdbcCall jdbcCall;
	
	/*
	public Map<String,Object> getStudentGrade(int rno)
	{
		Map<String,Object> ob=jdbcCall.execute(rno);
		
		return ob;
	}
	*/
	
	public String getStudentGrade(int rno)
	{
		jdbcCall.withFunctionName("get_grade");
		Map<String,Object> map= jdbcCall.execute(rno);
		
		return map.get("return").toString();
	}
}
