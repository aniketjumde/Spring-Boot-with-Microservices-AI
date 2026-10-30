package com.tca.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.tca.model.Employee;

@Component
public class MyRunners implements ApplicationRunner {

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		/*
		// TEST Case 01: find  By Id
		try {
            ResponseEntity<Employee> responseEntity =restTemplate.exchange(
													                    "http://localhost:8082/employee/{id}",
													                    HttpMethod.GET,
													                    null,
													                    Employee.class,
													                    102
													                );

            Employee emp = (Employee)responseEntity.getBody();

            if (emp != null) {
                System.out.println("Employee Data: " + emp);
            } else {
                System.out.println("No Data Found");
            }

        } 
		catch (HttpClientErrorException.NotFound ex) {
            System.out.println("Employee not found: "
                    + ex.getResponseBodyAsString());

        } 
		catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    */
		
		
		
	/*	
		//Test 2 : POST
		
		// POST /add : Calling via exchange()
		
		ResponseEntity<?> responseEntity=null;
		
		try
		{
			Employee emp = new Employee();
			emp.setEmpno(107);
			emp.setEname("Pradeep");
			emp.setEsalary(45000.0);
			emp.setDeptNo(15);
			
			HttpHeaders requestHeader=new HttpHeaders();
			requestHeader.setContentType(MediaType.APPLICATION_JSON);
			requestHeader.setAccept( List.of(MediaType.APPLICATION_JSON));
		
			HttpEntity<Employee> requestEntity = new HttpEntity<Employee>(emp,   requestHeader);
			
			responseEntity =restTemplate.exchange(
													"http://localhost:8082/employee",
									                 HttpMethod.POST,
									                 requestEntity,
													 Employee.class
												 );
		}
		catch(HttpClientErrorException | HttpServerErrorException ex)
		{
			responseEntity = new ResponseEntity<>(ex.getResponseBodyAsString(), ex.getStatusCode());
			System.out.println("Error Response : ");
			System.out.println("Body        :" + responseEntity.getBody());
			System.out.println("Status Code : " + responseEntity.getStatusCode());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	*/
		
		
	}
}
