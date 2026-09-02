package com.tca.runners;

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

		// Test case 01: Find By Greater than Per and Gender
		
//		List<Student> students=studentService.findAllByGreaterThanPerAndGenderUsingSQL(80.0,Gender.FEMALE);
//	
//		if(students.isEmpty())
//		{
//			System.out.println("Record is Not Found.!!!");
//		}
//		else
//		{
//			MyRunners.printStudent(students);
//		}
		
//		//Test Case 02 : Prints Students name and Per
//		
//		List<Object[]> obs=studentService.findAllNameAndPerUsingSQL();
//		
//		for(Object[] ob:obs)
//		{
//			System.out.println("Name : "+ob[0]);
//			System.out.println("per : "+ob[1]);
//			System.out.println("===".repeat(10));
//		}
		
//		//Test Case 03 : Find Gender Wise Count
//		
//				List<Object[]> obs=studentService.fetchGenderWiseCount();
//				
//				for(Object[] ob:obs)
//				{
//					System.out.println("Gender "+ob[0]);
//					System.out.println("Count "+ob[1]);
//					System.out.println("===".repeat(10));
//				}
//				
				
		// Test Case 4: Update the Name
		
		studentService.updateStudentName("Pavan",104);
		System.out.println("Record is Updated Successfully !!!");
				
				
				
	}
		
	

}
