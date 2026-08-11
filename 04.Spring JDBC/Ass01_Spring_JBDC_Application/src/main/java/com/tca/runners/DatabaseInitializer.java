package com.tca.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements ApplicationRunner 
{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception 
	{

		System.out.println("DROP TABLE IF EXITS !!!");
		jdbcTemplate.execute("DROP TABLE IF EXISTS student");		
		
		jdbcTemplate.execute("CREATE TABLE student(rno int PRIMARY KEY,name VARCHAR(20),per Double,city VARCHAR(20))");
		System.out.println("Table is Created Successfully");

		jdbcTemplate.execute("INSERT INTO student VALUES (101, 'Pradeep', 83.34, 'Beed')");

		jdbcTemplate.execute("INSERT INTO student VALUES (102, 'BBB', 67.3, 'Pune')");

		jdbcTemplate.execute("INSERT INTO student VALUES (103, 'CCC', 67.3, 'Nashik')");

		jdbcTemplate.execute("INSERT INTO student VALUES (104, 'DDD', 81.3, 'Pune')");
		


		
	}

}
