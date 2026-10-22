package com.tca.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tca.model.Employee;
import com.tca.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value="/employee/{id}",
				produces={"application/xml","application/json"}				
				)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id)
	{
		 Employee employee = employeeService.fetchById(id);

		 if (employee != null) 
		 {
		    return new ResponseEntity<>(employee, HttpStatus.OK);
		 }

		 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		List<Employee> empList=employeeService.fetchAllEmployees();
		
		if(empList!=null)
		{
			return new ResponseEntity<>(empList, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping(value="/employee",
				 produces={"application/xml","application/json"},
				 consumes={"application/xml","application/json"}
				)
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	{
		Employee emp=employeeService.saveStudent(employee);
		
		if (emp != null) 
		 {
		    return new ResponseEntity<>(emp, HttpStatus.OK);
		 }

		 return new ResponseEntity<>(HttpStatus.CONFLICT);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id)
	{
		
		boolean status=employeeService.deleteById(id);
		
		if(status)
		{
			return new ResponseEntity<>("Employee is Deleted !!!",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("Employee does not exits !!!",HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
	{
		Employee emp=employeeService.updateEmployee(employee);
		
		if(emp==null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		else
		{
			return new ResponseEntity<>(emp,HttpStatus.CREATED);
		}
	}
	
	
	@PatchMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@RequestBody Map<String,Object> fieldMap,@PathVariable Integer id)
	{
		Employee updatedEmp = employeeService.updateEmployeeById(fieldMap, id);
		
		if(updatedEmp==null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<>(updatedEmp, HttpStatus.OK);
		}
	}
}
