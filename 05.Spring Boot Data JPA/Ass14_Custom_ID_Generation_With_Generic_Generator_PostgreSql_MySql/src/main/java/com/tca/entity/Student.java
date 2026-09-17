package com.tca.entity;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;

import com.tca.enums.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
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
	@GenericGenerator(name="rno-gen",strategy="com.tca.generator.IdGenerator")
	@GeneratedValue(generator="rno-gen")
	private String rno;
	private String name;
	private Double per;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private LocalDate birthDate;
}
