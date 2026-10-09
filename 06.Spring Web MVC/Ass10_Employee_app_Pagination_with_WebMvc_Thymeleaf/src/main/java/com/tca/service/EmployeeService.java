package com.tca.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tca.model.Employee;

public interface EmployeeService {

	public List<Employee> fetchAllEmployees();
	
	public Page<Employee> findAll(int pageNumber,int pageSize);
}
