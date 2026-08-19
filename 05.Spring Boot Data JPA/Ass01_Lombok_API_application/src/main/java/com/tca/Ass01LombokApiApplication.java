package com.tca;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tca.model.Student;

@SpringBootApplication
public class Ass01LombokApiApplication {

	public static void main(String[] args) 
	{
		//SpringApplication.run(Ass01LombokApiApplication.class, args);
		
		Student ob1=new Student();
		Student ob2 = new Student(101,"AAA",89.3,"Pune");	
		
		
		System.out.println(ob1);
		System.out.println(ob2);
		
		Student ob3=new Student();
		ob3.setRollNo(111);
		ob3.setName("BBB");
		ob3.setPercentage(90);
		ob3.setCity("Nashik");
		
		System.out.println("Ob 3-->"+ob3.getRollNo()+" "+ob3.getName()+" "+ob3.getPercentage()+" "+ob3.getCity());
		
		Student ob4 = new Student(101,"AAA",89.3,"Pune");	
		
		System.out.println("Ob2 is Equals to Ob4 : "+ob2.equals(ob4));

		
	}

}
