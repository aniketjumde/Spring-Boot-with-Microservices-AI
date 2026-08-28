package com.tca.runners;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tca.entity.Student;
import com.tca.enums.Gender;
import com.tca.service.StudentService;

@Component
public class MyRunners implements ApplicationRunner
{
	@Autowired
	private StudentService studentService;

	private  static void printStudent(List<Student> studentList)
	{
		for(Student s:studentList)
		{
			System.out.println("Roll No    : "+s.getRno());
			System.out.println("Name       : "+s.getName());
			System.out.println("Percentage : "+s.getPer());
			System.out.println("Gender     : "+s.getGender());
			System.out.println("Birth Date : "+s.getBirthDate());
			System.out.println("===".repeat(10));
		}
	}
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

	
		//Query Named Approach Using Method Name
		//***** TEST CASE 01 - BY Gender *****
//		List<Student> students=studentService.fetchByGender(Gender.FEMALE);
//		
//		if(students.isEmpty())
//		{
//			System.out.println("No Student Found.!!!");
//		}
//		else
//		{
//			System.out.println("StudentS Information.!!");
//			MyRunners.printStudent(students);
//		}
//		
	
		
		//***** TEST CASE 02 - BY NAME *****

//		List<Student> students=studentService.fetchByName("Anita");
//		
//		if(students.isEmpty())
//		{
//			System.out.println("No Student Found.!!!");
//		}
//		else
//		{
//			System.out.println("StudentS Information.!!");
//			MyRunners.printStudent(students);
		
//		}
		
		
		
//		//***** TEST CASE 02 - BY Per *****
//
//		
//		List<Student> students=studentService.fetchByPer(90.0);
//		
//		if(students.isEmpty())
//		{
//			System.out.println("No Student Found.!!!");
//		}
//		else
//		{
//			System.out.println("StudentS Information.!!");
//			MyRunners.printStudent(students);
//		}
		
//		
//	//***** TEST CASE 03 - BY Birth DATE *****
//
//		
//		List<Student> students=studentService.fetchByBirthDate(LocalDate.of(2002, 2, 14));
//		
//		if(students.isEmpty())
//		{
//			System.out.println("No Student Found.!!!");
//		}
//		else
//		{
//			System.out.println("StudentS Information.!!");
//			MyRunners.printStudent(students);
//		}
		
		
//		
//		//***** TEST CASE 04 - AND *****
//
//			
//			List<Student> students=studentService.fetchByGenderAndName(Gender.FEMALE,"Pooja");
//			
//			if(students.isEmpty())
//			{
//				System.out.println("No Student Found.!!!");
//			}
//			else
//			{
//				System.out.println("StudentS Information.!!");
//				MyRunners.printStudent(students);
//	
//			}
			
			
			

//		//***** TEST CASE 05 - OR *****
//
//			
//			List<Student> students=studentService.fetchByNameOrPer("Pooja",81.0);
//			
//			if(students.isEmpty())
//			{
//				System.out.println("No Student Found.!!!");
//			}
//			else
//			{
//				System.out.println("StudentS Information.!!");
//				MyRunners.printStudent(students);
//	
//			}
		

//		//***** TEST CASE 06 - LESS THAN *****
//
//			
//			List<Student> students=studentService.fetchByPerLessThan(60.0);
//			
//			if(students.isEmpty())
//			{
//				System.out.println("No Student Found.!!!");
//			}
//			else
//			{
//				System.out.println("StudentS Information.!!");
//				MyRunners.printStudent(students);
//	
//			}
		
		
//		//***** TEST CASE 07 - Greater than Equal To *****
//
//		
//		List<Student> students=studentService.fetchByPerGreaterThanEqual(60.0);
//		
//		if(students.isEmpty())
//		{
//			System.out.println("No Student Found.!!!");
//		}
//		else
//		{
//			System.out.println("StudentS Information.!!");
//			MyRunners.printStudent(students);
//
//		}
		
		
//		//***** TEST CASE 09 - BETWEEN OR GIVEN RANGE *****
//
//		
//		List<Student> students=studentService.fetchByPerBetween(70.0,95.0);
//		
//		if(students.isEmpty())
//		{
//			System.out.println("No Student Found.!!!");
//		}
//		else
//		{
//			System.out.println("StudentS Information.!!");
//			MyRunners.printStudent(students);
//
//		}
			
			
			
		//***** TEST CASE 10 - String pattern *****

		
//				List<Student> students=studentService.fetchByNameLike("Amit");
//				
//				if(students.isEmpty())
//				{
//					System.out.println("No Student Found.!!!");
//				}
//				else
//				{
//					System.out.println("StudentS Information.!!");
//					MyRunners.printStudent(students);
//
//				}		
//				
			
		
//		//***** TEST CASE 11 - String pattern *****
//
//				
//				List<Student> students=studentService.fetchByNameContaining("ee");
//				
//				if(students.isEmpty())
//				{
//					System.out.println("No Student Found.!!!");
//				}
//				else
//				{
//					System.out.println("StudentS Information.!!");
//					MyRunners.printStudent(students);
//
//				}
				
				
//		//***** TEST CASE 12 - String pattern *****
//
//		
//		List<Student> students=studentService.fetchByNameStartWith("a");
//		
//		if(students.isEmpty())
//		{
//			System.out.println("No Student Found.!!!");
//		}
//		else
//		{
//			System.out.println("StudentS Information.!!");
//			MyRunners.printStudent(students);
//
//		}		
//			
//			
//			
		
		
		//***** TEST CASE 12 - String pattern *****

//		
//		List<Student> students=studentService.fetchByNameEndWith("a");
//		
//		if(students.isEmpty())
//		{
//			System.out.println("No Student Found.!!!");
//		}
//		else
//		{
//			System.out.println("StudentS Information.!!");
//			MyRunners.printStudent(students);
//
//		}		
//			
//			
//			
		
		
		//***** TEST CASE 10 - String pattern *****

		
		List<Student> students=studentService.fetchByNameIgnoreCase("Amit");
		
		if(students.isEmpty())
		{
			System.out.println("No Student Found.!!!");
		}
		else
		{
			System.out.println("StudentS Information.!!");
			MyRunners.printStudent(students);

		}		
		
			
	}
	
	
		
		
		
	

}
