package com.tca.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Map<String,Object>> getAllRecords()
	{
		String sql="SELECT * FROM student";
		return jdbcTemplate.queryForList(sql);
	}

}
