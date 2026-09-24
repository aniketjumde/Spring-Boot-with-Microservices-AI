package com.tca.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long rno;
	
	private String name;
	
	private Integer marks;
	
	@Transient	//"I need this field in Java, but I don't need a database column for it."
	private String result;// Partial Entity-Table Mapping
	
	public String getResult() {
	    return marks >= 40 ? "PASS" : "FAIL";
	}
	
}
