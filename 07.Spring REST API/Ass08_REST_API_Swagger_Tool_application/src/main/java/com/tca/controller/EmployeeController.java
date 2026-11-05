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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Employees",description="Employee REST API Documentations")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@ApiResponse(responseCode="400", description = "Invalid Employee ID is Given.")
	@ApiResponse(responseCode="200", description = "Fetched Employee Successfully.")
	@Operation(summary="Get Employe by ID", description = "Fetch one employee by Employee number")
	@GetMapping(value="/employee/{id}",
				produces={"application/json","application/json"}				
				)
	public ResponseEntity<Employee> getEmployeeById(@Parameter(description="Employee ID to fetch Details") @PathVariable Integer id)
	{
		 Employee employee = employeeService.fetchById(id);

		 if (employee != null) 
		 {
		    return new ResponseEntity<>(employee, HttpStatus.OK);
		 }

		 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@ApiResponse(responseCode="400", description = "Employee List is not Found")
	@ApiResponse(responseCode="200", description = "Fetched All Employee Successfully.")
	@Operation(summary="Get All Employees", description = "Fetch All Employees ")
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
	
	
	@ApiResponse(responseCode="200",description="Employee is CREATED Successfully.")
	@ApiResponse(responseCode="409",description="Employee is ALREADY Exits.")
	@Operation(summary = "Create an Employee",description = "Creates a new employee and saves the employee details in the database.")
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
	
	@Operation(
		    summary = "Delete Employee By ID",
		    description = "Deletes an employee from the database using the employee ID."
		)
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "200", description = "Employee deleted successfully"),
		    @ApiResponse(responseCode = "404", description = "Employee not found")
		})
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id)
	{
		 boolean status = employeeService.deleteById(id);

		 if(status)
		 {
		      return new ResponseEntity<>("Employee is Deleted !!!", HttpStatus.OK);
		 }
		 else
		 {
		      return new ResponseEntity<>("Employee does not exist !!!", HttpStatus.NOT_FOUND);
		  }
	}
	
	@Operation(
		    summary = "Update Employee",
		    description = "Updates the existing employee details using the employee information provided in the request body."
		)
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "200", description = "Employee updated successfully"),
		    @ApiResponse(responseCode = "404", description = "Employee not found")
		})
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
	{
		    Employee emp = employeeService.updateEmployee(employee);

		    if(emp == null)
		    {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		    else
		    {
		        return new ResponseEntity<>(emp, HttpStatus.OK);
		    }
	}
	
	@Operation(
		    summary = "Partially Update Employee By ID",
		    description = "Updates specific employee fields using the employee ID and the field values provided in the request body. Only the specified fields are updated."
		)
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "200", description = "Employee partially updated successfully"),
		    @ApiResponse(responseCode = "404", description = "Employee not found")
		})
	@PatchMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployeeById(
		        @RequestBody Map<String, Object> fieldMap,
		        @PathVariable Integer id)
	{
		    Employee updatedEmp = employeeService.updateEmployeeById(fieldMap, id);

		    if(updatedEmp == null)
		    {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		    else
		    {
		        return new ResponseEntity<>(updatedEmp, HttpStatus.OK);
		    }
	}
}
