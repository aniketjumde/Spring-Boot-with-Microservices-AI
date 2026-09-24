package com.tca.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tca.entity.Student;
import com.tca.service.StudentService;

@Component
public class MyRunners implements ApplicationRunner
{
	@Autowired
	private StudentService studentService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		/*
		//TEST CASE 01: Save Student
		Student student=new Student();
		student.setName("kaushal");
		student.setMarks(82);
		student.setResult("PASS");
		
		studentService.save(student);
		
		*/
		
		// TEST CASE : Fetched The Result
		
		Student student=studentService.fetchStudent(4L);
		System.out.println("Student Id :"+student.getRno());
		System.out.println("Student Name :"+student.getName());
		System.out.println("Student Marks :"+student.getMarks());
		System.out.println("Student Result :"+student.getResult());
		
	}

}
