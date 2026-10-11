package com.tca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	@Override
	public Page<Employee> findAll(int pageNumber, int pageSize) {

		Pageable pageable=PageRequest.of(pageNumber, pageSize,Sort.by("esalary").descending());
				
		return employeeRepository.findAll(pageable);
	}

}
