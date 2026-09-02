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

//		//Test Case 01 : Fetch All Student Records
//		List<Student> students=studentService.fetchAllStudent();
//		
//		System.out.println(students);
//		
		
//		//Test Case 02 : Fetch All Student Range Per
//		List<Student> students=studentService.fetchByPerBetweenStudent(60.0,90.0);
//				
//				System.out.println(students);
//				
		
//		//Test Case 02 : Fetch All Student gender,name, Per
//		List<Object[]> students=studentService.fetchByGenderAndPer(Gender.FEMALE,70.0);
//				
//		for(Object[] ob:students)
//		{
//			
//			System.out.println("Name   : "+ob[0]);
//			System.out.println("Per    : "+ob[1]);
//			System.out.println("Gender : "+ob[2]);
//			System.out.println("======".repeat(5));
//		}
		
		
//		
//		//Test Case 03 : Update Student Name
//		
//		studentService.updateByName("Pradeep",103);
//		System.out.println("Update Record Successfully !!!");
//	
		
		//Test Case 04 : Delete By rno
		studentService.deleteByRno(120);
		System.out.println("Record is Deleted Successfully");
					
	}
	
	
		
		
		
	

}
