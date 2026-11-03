package com.tca.api;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger log=LoggerFactory.getLogger(EmployeeController.class);
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id)
	{
		log.info("GET /employee/{} - Request Received",id); // GET /employee/101 - Request Received"
		
		log.debug("GET /employee/{} - Calling EmployeeService",id);
		
		Employee employee=employeeService.fetchById(id);
		
		 if (employee == null) 
		 {
			 	log.warn("GET /employee/{} - Employee Not Found",id);
		        throw new EmployeeNotFoundException("Employee not found with id: " + id);
		 }

		log.info("GET /employee/{} - Employee found: {}", id, employee.getEname());
		return ResponseEntity.ok(employee);
		
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		log.info("GET /employees - Request Recevied to Fetched All Employees !!!");
		
        log.debug("GET /employees - Calling EmployeeService");
		
		List<Employee> empList=employeeService.fetchAllEmployees();
		
		if (empList == null || empList.isEmpty()) {
			
			log.warn("GET /employees - No Employees Record are Founds in Database ");
			
	        throw new EmployeeNotFoundException("Employees are not found!");
	    }

		log.info("GET /employees - Successfully fetched {} employees",empList.size());
        log.debug("GET /employees - Employee records: {}", empList);
	    return ResponseEntity.ok(empList);
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) throws EmployeeAlreadyExistException
	{
		log.info("POST /employee - Request receved to create new Employee");
        log.debug("POST /add - Employee number: {}", employee.getEmpno());
		
		Employee updateEmp=employeeService.saveEmployee(employee);
		
		if(updateEmp==null)
		{
			log.warn("POST /employee - Employee creation failed - Employee is already exits : empo {}",employee.getEmpno());
			throw new EmployeeAlreadyExistException("Employee with empno:" + employee.getEmpno() +" is already Present !!" );
		}
		else
		{
			log.info("POST /add - Employee created successfully: empno={}",updateEmp.getEmpno());
			return new ResponseEntity<>(updateEmp, HttpStatus.CREATED);
		}
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
	{
		log.info("PUT /update - Request received to update employee: empno={}",employee.getEmpno());
		
		log.debug("PUT /update - Calling EmployeeService for empno={}",employee.getEmpno());
		
		Employee updateEmp=employeeService.updateEmployee(employee);
		
		if(updateEmp==null)
		{
			log.warn("PUT /update - Employee not found. Update failed: empno={}",employee.getEmpno());
			throw new EmployeeNotFoundException("Employee with empno :" + employee.getEmpno() + " is not present to Update ");
		}
		else
		{
			 log.info("PUT /update - Employee updated successfully: empno={}",updateEmp.getEmpno());

	         log.debug("PUT /update - Updated employee details: {}", updateEmp);
			
			return new ResponseEntity<>(updateEmp, HttpStatus.OK);
		}
		
	
	}
	
	
	@PatchMapping("/update/{id}")
	public ResponseEntity<Employee> modifyEmployee(@RequestBody Map<String, Object> fieldMap, 
												  @PathVariable Integer id )
	{
		log.info("PATCH /update/{} - Requeste receved for partial employee update",id);
		

        log.debug("PATCH /update/{} - Fields requested for update: {}",
                id, fieldMap.keySet());		
		Employee updatedEmp = employeeService.updateEmployeeById(fieldMap, id);
		
		if(updatedEmp==null)
		{
			log.warn("PATCH /update/{} - Employee not found. Partial update failed", id);
			
			throw new EmployeeNotFoundException("Employee with empno :" + id + " is not present to Update ");
			//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else
		{

            log.info("PATCH /update/{} - Employee partially updated successfully", id);

            log.debug("PATCH /update/{} - Updated employee details: {}", id, updatedEmp);
			
			return new ResponseEntity<>(updatedEmp, HttpStatus.OK);
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeEmployee(@PathVariable Integer id)
	{

        log.info("DELETE /delete/{} - Request received to delete employee", id);
        
        log.debug("DELETE /delete/{} - Calling EmployeeService", id);

		boolean status = employeeService.deleteById(id);
		
		if(status)
		{
			log.info("DELETE /delete/{} - Employee deleted successfully", id);
			return new ResponseEntity<>("Employe is Deleted !!!", HttpStatus.OK);
		}
		else
		{
			log.warn("DELETE /delete/{} - Employee not found. Deletion failed", id);
			throw new EmployeeNotFoundException("Employee with empno :" + id + " is not present to Delete" );
			//return new ResponseEntity<>("Employe does not Exist !!!", HttpStatus.NOT_FOUND);
		}
	}
	
	
}
