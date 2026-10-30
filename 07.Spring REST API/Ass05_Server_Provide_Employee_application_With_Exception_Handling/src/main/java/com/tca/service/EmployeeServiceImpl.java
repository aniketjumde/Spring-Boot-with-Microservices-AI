package com.tca.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.model.Employee;
import com.tca.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee fetchById(Integer empno) {

	    return employeeRepository.findById(empno).orElse(null);
	}

	@Override
	public List<Employee> fetchAllEmployees() {
		
		List<Employee> empList=employeeRepository.findAll();
		
		if(empList!=null)
		{
			return empList;
		}
		
		return null;
	}

	@Override
	public Employee saveEmployee(Employee employee) {

		if(employeeRepository.existsById(employee.getEmpno()))
		{
			return null;
		}
		else
		{
			return employeeRepository.save(employee);
		}
		
	}

	@Override
	public Boolean deleteById(Integer id) {

		if(employeeRepository.existsById(id))
		{
			employeeRepository.deleteById(id);
			return true;
		}
		else
		{
			return false;
		}
		
	}

	@Override
	public Employee updateEmployee(Employee employee) 
	{
		if(employeeRepository.existsById(employee.getEmpno()))
		{
			return employeeRepository.save(employee);
		}
		else
		{
			return null;
		}
	}

	@Override
	public Employee updateEmployeeById(Map<String, Object> fieldMap, Integer Id) {
		
		if(employeeRepository.existsById(Id))
		{
			Double sal=(Double) fieldMap.get("esalary");
			Integer deptNo=(Integer) fieldMap.get("deptNo");
			
			employeeRepository.updateEmployeeById(sal,deptNo,Id);
			
			return employeeRepository.findById(Id).get();
		}
		else
		{
			return null;
		}
	}

}
