package com.tca.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.tca.model.Student;

@Configuration
@ComponentScan("com.tca")
public class AppConfig 
{
	@Bean
	Map<String,Student> getStudentStore()
	{
		Student s1=new Student("Aniket","Pune",87.98);
		Student s2=new Student("Prdeeep","Beed",77.42);

		HashMap<String,Student> hmap=new HashMap<>();
		hmap.put("SB-01",s1);
		hmap.put("SB-02",s2);

		return hmap;
	}
}
