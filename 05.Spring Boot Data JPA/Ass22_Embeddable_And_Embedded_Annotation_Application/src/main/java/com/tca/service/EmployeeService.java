package com.tca.service;

import com.tca.entity.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);
	public Employee findByEmployee(Long eid);
	public void deleteById(long eid);
}
