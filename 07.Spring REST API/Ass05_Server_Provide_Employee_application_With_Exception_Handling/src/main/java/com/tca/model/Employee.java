package com.tca.model;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="emp")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	private Integer empno;
	
	private String ename;
	
	private Double esalary;
	
	private Integer deptNo;

	
}
