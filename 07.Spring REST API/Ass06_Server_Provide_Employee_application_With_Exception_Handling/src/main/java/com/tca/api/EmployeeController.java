package com.tca.api;

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

import com.tca.Exception.EmployeeAlreadyExistException;
import com.tca.Exception.EmployeeNotFoundException;
import com.tca.model.Employee;
import com.tca.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id)
	{
		Employee employee=employeeService.fetchById(id);
		
		 if (employee == null) 
		 {
		        throw new EmployeeNotFoundException("Employee not found with id: " + id);
		 }

		return ResponseEntity.ok(employee);
		
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		List<Employee> empList=employeeService.fetchAllEmployees();
		
		if (empList == null || empList.isEmpty()) {
	        throw new EmployeeNotFoundException("Employees are not found!");
	    }

	    return ResponseEntity.ok(empList);
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) throws EmployeeAlreadyExistException
	{
		Employee updateEmp=employeeService.saveEmployee(employee);
		
		if(updateEmp==null)
		{
			throw new EmployeeAlreadyExistException("Employee with empno:" + employee.getEmpno() +" is already Present !!" );
		}
		else
		{
			return new ResponseEntity<>(updateEmp, HttpStatus.CREATED);
		}
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
	{
		Employee updateEmp=employeeService.updateEmployee(employee);
		
		if(updateEmp==null)
		{
			throw new EmployeeNotFoundException("Employee with empno :" + employee.getEmpno() + " is not present to Update ");
		}
		else
		{
			return new ResponseEntity<>(updateEmp, HttpStatus.OK);
		}
		
	
	}
	
	
	@PatchMapping("/update/{id}")
	public ResponseEntity<Employee> modifyEmployee(@RequestBody Map<String, Object> fieldMap, 
												  @PathVariable Integer id )
	{
		Employee updatedEmp = employeeService.updateEmployeeById(fieldMap, id);
		
		if(updatedEmp==null)
		{
			throw new EmployeeNotFoundException("Employee with empno :" + id + " is not present to Update ");
			//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<>(updatedEmp, HttpStatus.OK);
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeEmployee(@PathVariable Integer id)
	{
		
		boolean status = employeeService.deleteById(id);
		
		if(status)
		{
			return new ResponseEntity<>("Employe is Deleted !!!", HttpStatus.OK);
		}
		else
		{
			throw new EmployeeNotFoundException("Employee with empno :" + id + " is not present to Delete" );
			//return new ResponseEntity<>("Employe does not Exist !!!", HttpStatus.NOT_FOUND);
		}
	}
	
	
}
