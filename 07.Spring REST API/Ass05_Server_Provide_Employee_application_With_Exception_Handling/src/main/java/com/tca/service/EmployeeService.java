package com.tca.service;

import java.util.List;
import java.util.Map;

import com.tca.model.Employee;

public interface EmployeeService 
{

	public Employee fetchById(Integer empno);
	public List<Employee> fetchAllEmployees();
	public Employee saveEmployee(Employee employee);
	public Boolean deleteById(Integer id);
	public Employee updateEmployee(Employee employee);
	
	public Employee updateEmployeeById(Map<String,Object> fieldMap,Integer Id);

	
}
