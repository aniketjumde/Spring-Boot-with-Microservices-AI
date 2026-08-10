package com.tca;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ass05CommadLineArgumentsApplication 
{
	
	public static void main(String[] args) 
	{
		
		
		SpringApplication.run(Ass05CommadLineArgumentsApplication.class, args);
		
		System.out.println("Args :"+ Arrays.toString(args));
	}

}
