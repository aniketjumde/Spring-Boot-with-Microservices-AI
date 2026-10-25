package com.tca.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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

		//TEST CASE 01: getForObject() for GET
		
//		Employee e=restTemplate.getForObject("http://localhost:8080/employee/{id}", Employee.class, 101);
//		System.out.println(e);
		
		
		//TEST CASE 02: getForObject() for GET
		
//		ResponseEntity<Employee> response=restTemplate.getForEntity("http://localhost:8080/employee/{id}", Employee.class, 101);
//	    Employee employee = response.getBody();
//
//		
//		if(response.getStatusCode().is2xxSuccessful() && response.getBody() != null)
//		{
//			System.out.println(employee);
//		}
//		else
//		{
//			System.out.println("No Data Found");
//		}
		
		
		//TEST CASE 03: exchange() for GET
	/*	
		ResponseEntity<Employee> responseEntity=restTemplate.exchange("http://localhost:8082/employee/{id}",HttpMethod.GET, null, Employee.class, 101);

		if(responseEntity.getStatusCode().is2xxSuccessful() && responseEntity.getBody() != null)
		{
		    Employee employee = responseEntity.getBody();

				System.out.println(employee);
		}
		else
		{
				System.out.println("No Data Found");
		}
		
		*/
		
		
		//TEST CASE 04: Post for exchange()

		
		Employee employee=new Employee();
		employee.setEmpno(6);
		employee.setEname("Pradeep");
		employee.setEsalary(700.0);
		employee.setDeptNo(104);
		
		HttpHeaders httpHeaders=new HttpHeaders();
		//httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		//httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
		httpHeaders.add("Content-Type", "application/json");
		httpHeaders.add("Accept", "application/json");
		
		HttpEntity<Employee> requestEntity=new HttpEntity<Employee>(employee,httpHeaders);
		
		ResponseEntity<Employee> responseEntity=restTemplate.exchange("http://localhost:8082/employee",HttpMethod.POST, requestEntity, Employee.class);
		
		if(responseEntity.getStatusCode().is2xxSuccessful() && responseEntity.getBody() != null)
		{
		    Employee emp = responseEntity.getBody();

				System.out.println(emp);
		}
		else
		{
				System.out.println("No Data Found");
		}
	}

}
