package com.tca.entity;

import java.time.LocalDate;

import com.tca.enums.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Student {

	@Id
//	@SequenceGenerator(name="rno_gen",
//					   sequenceName="stud_seq",
//					   allocationSize=50
//					   )
	
	@SequenceGenerator(name="rno_gen",
	   sequenceName="student_seq",
	   allocationSize=1
	   )
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
					generator="rno_gen"
					)
	private Long rno;
	
	private String name;
	
	private Double per;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private LocalDate birthDate;
	
	
}
