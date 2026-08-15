package com.tca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.tca.repository.StudentRepository;

@SpringBootApplication
public class Ass03SpringJdbcIntegrationWithFlywayApplication {

	public static void main(String[] args) {
		
		ApplicationContext context= SpringApplication.run(Ass03SpringJdbcIntegrationWithFlywayApplication.class, args);
		
		StudentRepository repo=context.getBean(StudentRepository.class);
		
		System.out.println(repo.getAllRecords());
	}

}
