package com.tca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="emp")
@Data
public class Employee {

	@Id
	private Integer empno;
	
	private String ename;
	
	private Double esalary;
	
	private Integer deptNo;
}
