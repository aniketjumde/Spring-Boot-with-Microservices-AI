package com.tca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.tca.model.Student;
import com.tca.repository.StudentRepository;

@SpringBootApplication
public class Ass01SpringJbdcApplication 
{
	

	public static void main(String[] args) 
	{
		
		ApplicationContext context=SpringApplication.run(Ass01SpringJbdcApplication.class, args);
		StudentRepository studentRepository=context.getBean(StudentRepository.class);
		Student student=new Student(101,"AAA",89.23,"Pune");
		
		
		/*
		int status=studentRepository.save(student);
		//Save
		if(status==0)
		{
			System.out.println("Record is Failed to Insert !!!");
		}
		else
		{
			System.out.println("Record is Inserted Successfully !!!");
			
		}
		
		
		
		//DELETE
		
		int status=studentRepository.delete(101);
		if(status==0)
		{
			System.out.println("Record is NOT Found !!!");
		}
		else
		{
			System.out.println("Record is DELETED Successfully !!!");
			
		}
		
		*/
		
		//Update
		
		int status=studentRepository.updateRecord(student);
		if(status==0)
		{
			System.out.println("Record is NOT Found !!!");
		}
		else
		{
			System.out.println("Record is Updated Successfully !!!");
			
		}
	}

}
