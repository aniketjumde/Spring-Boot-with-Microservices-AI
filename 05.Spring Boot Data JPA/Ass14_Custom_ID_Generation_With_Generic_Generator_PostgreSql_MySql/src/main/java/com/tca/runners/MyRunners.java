package com.tca.runners;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tca.entity.Student;
import com.tca.enums.Gender;
import com.tca.service.StudentService;

@Component
public class MyRunners implements ApplicationRunner {

	@Autowired
	private StudentService studentService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Student s=new Student();
		s.setName("Aniket");
		s.setPer(89.0);
		s.setGender(Gender.MALE);
		s.setBirthDate(LocalDate.now());
		studentService.saveStudent(s);
	}

}
