package com.tca.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.tca.model.Employee;

import reactor.core.publisher.Mono;

@Component
public class MyRunners implements ApplicationRunner {

	@Autowired
	private WebClient webClient;
	@Override
	public void run(ApplicationArguments args) throws Exception {
	
	/*	
		//TEST Case 01:
		
		// Calling GET /employee/{id} 
		
		Mono<Employee> empMono=webClient.get()
												.uri("http://localhost:8082/employee/{id}", 1018)
												.retrieve()
												.bodyToMono(Employee.class);
		
//		empMono.subscribe(emp->System.out.println(emp),
//							ex->{
//									System.out.println("Employee is NOT Found !!!");
//							});
		
		empMono.subscribe(emp->System.out.println(emp),
				ex->{
						System.out.println("Employee is NOT Found !!!");
						
						if(ex instanceof WebClientResponseException)
				        {
				        	WebClientResponseException wex = (WebClientResponseException) ex;
				        	System.out.println("Status Code : " + wex.getStatusCode());
				        	System.out.println("Message     : " + wex.getResponseBodyAsString());
				        	
				        }
				});
		*/
		
		
		
		/*
		//Test 02 : GET ALl Employees
		
		// Calling GET /employees 
		Flux<Employee> empFlux=webClient.get()
										.uri("http://localhost:8082/employees")
										.accept(MediaType.APPLICATION_JSON)										
										.retrieve()
										.bodyToFlux(Employee.class);
		
		empFlux.subscribe(emp->{
				
			System.out.println(emp);
			System.out.println("-------------".repeat(10));
		});
		*/
		
		
		// Test 03 : POST 
		
		
		Employee employee=new Employee();
		employee.setEmpno(108);
		employee.setDeptNo(19);
		employee.setEname("Omkar");
		employee.setEsalary(98.8929);
		
		Mono<Employee> empMono = webClient.post()
											        .uri("http://localhost:8082/employee")
											        .contentType(MediaType.APPLICATION_JSON)
											        .accept(MediaType.APPLICATION_JSON)
											        .bodyValue(employee)
											        .retrieve()
											        .bodyToMono(Employee.class);
																				
		empMono.subscribe( e -> System.out.println(e),
						   ex-> System.out.println("Exception : Employee Aready Exits "));										
	}
}
