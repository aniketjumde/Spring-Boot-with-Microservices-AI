package com.tca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.model.Employee;
import com.tca.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeRepository employeeRepository;	
	
	@Override
	public List<Employee> fetchAllEmployees() {

		
		return employeeRepository.findAll();
	}

}
