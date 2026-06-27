package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tca.bean.Student;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args)
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
    	Student student=(Student)context.getBean(Student.class);
    	
    	System.out.println(student.getId());
    	System.out.println(student.getName());
    	System.out.println(student.getFees());
    	System.out.println(student.getPassportId());

    	
    }
}
