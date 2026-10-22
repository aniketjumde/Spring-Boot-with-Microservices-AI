package com.tca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tca.model.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	
	@Query("Update Employee e SET e.esalary=:sal , e.deptNo=:deptNo WHERE empno=:empno")
	@Modifying
	@Transactional
	public void updateEmployeeById(@Param("sal") Double salary,@Param("deptNo") Integer deptNo,@Param("empno") Integer id);
}
