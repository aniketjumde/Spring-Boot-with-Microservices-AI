package com.tca;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.tca.repository.StudentRepository;

@SpringBootApplication
public class Ass02SpringJbdcApplicationUsingStoredProcedureOrFunctionApplication {

	public static void main(String[] args) 
	{
		
		ApplicationContext context=SpringApplication.run(Ass02SpringJbdcApplicationUsingStoredProcedureOrFunctionApplication.class, args);
		
		StudentRepository repo=context.getBean(StudentRepository.class);
		
		
		//Map<String,Object> grade=repo.getStudentGrade(1);
		//System.out.println("GRADE :"+grade);
		String grade=repo.getStudentGrade(2);
		
		System.out.println("Grade :"+grade);
	}

	@Bean
	public SimpleJdbcCall getSimpleJdbcCall(DataSource dataSource)
	{
		return new SimpleJdbcCall(dataSource);
	}
}
