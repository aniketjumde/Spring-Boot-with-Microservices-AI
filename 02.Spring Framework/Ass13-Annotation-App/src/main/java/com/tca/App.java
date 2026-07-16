package com.tca;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tca.config.AppConfig;
import com.tca.model.Student;
import com.tca.service.StudentService;

/**
 * Hello world!
 */
public class App
{
    public static void main(String[] args)
    {
    	ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
    	StudentService studentService=context.getBean(StudentService.class);
    	
    	Student student=studentService.getStudentId("SB-02");
    	if(student==null)
    	{
    		System.out.println("No Student Found");
    	}
    	else
    	{
    		System.out.println(student);

    	}
    	
    	Map<String,Student> map=studentService.getAllStudent();
    	
    	for(Entry<String, Student> entry:map.entrySet())
    	{
    		System.out.println(entry.getKey());
    	    System.out.println(entry.getValue());
    	}
    }
}
