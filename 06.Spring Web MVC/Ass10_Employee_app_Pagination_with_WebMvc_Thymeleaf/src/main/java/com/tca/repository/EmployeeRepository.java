package com.tca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tca.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
