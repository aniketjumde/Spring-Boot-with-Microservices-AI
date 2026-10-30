package com.tca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.tca.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	@Modifying
	@Transactional
	@Query(value="Update Employee e SET s.sal=:sal,s.deptNo=:deptNo WHERE e.empno=:id",nativeQuery=true)
	void updateEmployeeById(Double sal, Integer deptNo, Integer id);
	


}
