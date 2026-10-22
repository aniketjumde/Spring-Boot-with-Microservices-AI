package com.tca.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.tca.model.Employee;

@Component
public class MyRunners implements ApplicationRunner {

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		
//		Employee e=restTemplate.getForObject("http://localhost:8080/employee/{id}", Employee.class, 101);
//		System.out.println(e);
		
		ResponseEntity<Employee> response=restTemplate.getForEntity("http://localhost:8080/employee/{id}", Employee.class, 101);
	    Employee employee = response.getBody();

		
		if(response.getStatusCode().is2xxSuccessful() && response.getBody() != null)
		{
			System.out.println(employee);
		}
		else
		{
			System.out.println("No Data Found");
		}
	}

}
