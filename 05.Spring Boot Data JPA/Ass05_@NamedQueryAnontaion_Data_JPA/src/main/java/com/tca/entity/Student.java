package com.tca.entity;

import java.time.LocalDate;

import com.tca.enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="STUDENT")
@NoArgsConstructor
@AllArgsConstructor
@Data
@NamedQuery(name="Student.findAllByGreaterThanPerAndGender",query="SELECT s FROM Student s WHERE s.per>:per AND s.gender=:gender")
@NamedNativeQuery(name="Student.findAllByGreaterThanPerAndGenderUsingSQL",
				  query="SELECT * FROM student WHERE per>:per AND gender=:gender",
				  resultClass=Student.class) /// ResultClass can Convert Into List<Students>
@NamedQuery(name="Student.findAllNameAndPer",
			query="SELECT s.name,s.per FROM Student s")
@NamedNativeQuery(name="Student.findAllNameAndPerUsingSQL",
				  query="SELECT name,per FROM student") // By Default List<Object[]>
@NamedQuery(name="Student.findGenderWiseCount",
			query="SELECT s.gender,COUNT(s.gender) FROM Student s GROUP BY s.gender")
@NamedQuery(name="Student.updateStudentName",
			query="Update Student s SET s.name=:name WHERE s.rno=:rno")	
public class Student 
{

	@Id
	@Column(name="RNO")
	private Integer rno;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="PER")
	private Double per;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name="BIRTH_DATE")
	private LocalDate birthDate;
}
