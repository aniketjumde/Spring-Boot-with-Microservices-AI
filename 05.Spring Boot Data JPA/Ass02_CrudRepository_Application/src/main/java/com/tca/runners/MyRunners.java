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

		
		// TEST CASE 01 : Save Student Details in DataBase
		//Student s=new Student(101,"AAA",89.23,Gender.MALE,LocalDate.of(2026,8,26));
		//Student s=new Student(102,"BBB",79.23,Gender.FEMALE,LocalDate.of(2026,8,24));
		//Student s=new Student(103,"CCC",69.23,Gender.OTHER,LocalDate.of(2026,8,24));
		//Student s=new Student(104,"DDD",29.2,Gender.MALE,LocalDate.of(2026,8,25));
//		studentService.saveStudent(s);
//		System.out.println("Record saved Successfully.!!!");

//		TEST CASE 02: Update Student Details
//		Student s=new Student(101,"Pradeep",89.23,Gender.MALE,LocalDate.of(2026,8,26));
//		studentService.updateStudent(s);
//		System.out.println("Record Update Successfully");
		
////		TEST CASE 03: FIND BY ID
//		
//		Optional<Student> s=studentService.findById(102);
//		if(s.isPresent())
//		{
//			System.out.println("Record is Found !!!");
//			System.out.println(s);
//		}
//		else
//		{
//			System.out.println("Record is Not Found.!!!");
//		}
		
		
//		TEST CASE 04: Find LIST BY ID
//		
//		List<Integer> Ids=new ArrayList<>();
//		Ids.add(101);
//		Ids.add(103);
//		
//		List<Student> listStudent=studentService.findAllById(Ids);
//		if(listStudent.isEmpty())
//		{
//			System.out.println("Records Not Found.!!!");
//		}
//		else
//		{
//			System.out.println("Record is Found Successfully.!!!");
//			MyRunners.printStudent(listStudent);
//		}
		
//		TEST CASE 05 :findAll()
//		
//		List<Student> studentsList = studentService.fetchAllStudent();
//		
//		if(studentsList.isEmpty())
//		{
//			System.out.println("No Student is Present !!!");
//		}
//		else
//		{
//			System.out.println("************** Student Information *********************");
//			MyRunners.printStudent(studentsList);
//		}
		
		
//		TEST CASE 06: Delete Student Information
//		
//		if(studentService.deleteStudent(104))
//		{
//			System.out.println("Record is Deleted Successfully !!!");
//		}
//		else
//		{
//			System.out.println("Record is Not Found");
//		}
		
//		TEST CASE 07 : SAVE ALL STUDENTS
		
		Student s=new Student(104,"DDD",59.23,Gender.MALE,LocalDate.of(2026,8,22));
		Student s1=new Student(105,"EEE",49.23,Gender.FEMALE,LocalDate.of(2026,8,20));
		Student s2=new Student(106,"FFF",39.23,Gender.OTHER,LocalDate.of(2026,8,18));

		List<Student> studentlist=new ArrayList<>();
		studentlist.add(s);
		studentlist.add(s1);
		studentlist.add(s2);
		
		if(studentService.saveAll(studentlist).isEmpty())
		{
			System.out.println("Record is saved to failed !!!!");
		}
		else
		{
			System.out.println("Record is saved Successfuly");
		}
		
		
	}

}
