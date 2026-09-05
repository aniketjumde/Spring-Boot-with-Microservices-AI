package com.tca.runner;

import java.time.LocalDate;
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
		
		
		Student student=new Student();
		student.setName("AAA");
		student.setPer(70.0);
		student.setBirthDate(LocalDate.now());
		student.setGender(Gender.MALE);
		studentService.addStudent(student);

		
		
		// If We Create AllocationSize 50  At a Time 50 Instance is Created and Give One by one id like 1 2 3 4 5 6 NOTE: Before Run After Run Cache is Clear
		/*Student s1=new Student();
		s1.setName("BBB");
		s1.setPer(80.0);
		s1.setBirthDate(LocalDate.now());
		s1.setGender(Gender.MALE);
		studentService.addStudent(s1);

		Student s2=new Student();
		s2.setName("CCC");
		s2.setPer(70.0);
		s2.setBirthDate(LocalDate.now());
		s2.setGender(Gender.MALE);
		
		studentService.addStudent(s2);
		

		Student s3=new Student();
		s3.setName("DDD");
		s3.setPer(70.0);
		s3.setBirthDate(LocalDate.now());
		s3.setGender(Gender.MALE);
		
		studentService.addStudent(s3);
		

		Student s4=new Student();
		s4.setName("EEE");
		s4.setPer(70.0);
		s4.setBirthDate(LocalDate.now());
		s4.setGender(Gender.MALE);
		
		studentService.addStudent(s4);
		
		

		Student s21=new Student();
		s21.setName("FFF");
		s21.setPer(70.0);
		s21.setBirthDate(LocalDate.now());
		s21.setGender(Gender.MALE);
		
		studentService.addStudent(s21);
		*/
		
		
		
		MyRunners.printStudent(studentService.findAllStudents());
	}

}
