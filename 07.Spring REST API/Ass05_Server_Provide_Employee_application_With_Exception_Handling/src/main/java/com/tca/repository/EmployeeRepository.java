package com.tca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.tca.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	@Modifying
	@Transactional
	@Query("UPDATE Employee e SET e.esalary = :sal, e.deptNo = :deptNo WHERE e.empno = :id")
	void updateEmployeeById(@Param("sal") Double sal,
	                       @Param("deptNo") Integer deptNo,
	                       @Param("id") Integer id);
	


}
