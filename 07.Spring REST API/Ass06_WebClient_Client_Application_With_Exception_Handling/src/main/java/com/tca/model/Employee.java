package com.tca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor	
public class Employee {


	private Integer empno;
	
	private String ename;
	
	private Double esalary;
	
	private Integer deptNo;

	
}
