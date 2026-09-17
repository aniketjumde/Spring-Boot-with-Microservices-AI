package com.tca.entity;

import java.time.LocalDate;

import com.tca.annotation.RbtId;
import com.tca.enums.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student 
{
	@Id
	@RbtId
	private String rno;
	private String name;
	private Double per;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private LocalDate birthDate;
}
