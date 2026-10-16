package com.tca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="emp")
public class Employee {
	
	@Id
	private Integer empno;
	
	private String ename;
	
	private Double esalary;
	
	private Integer deptNo;

}
