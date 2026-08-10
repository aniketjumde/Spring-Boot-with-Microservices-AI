package com.tca.runners;

import java.util.List;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements ApplicationRunner
{

	@Override
	public void run(ApplicationArguments args) throws Exception 
	{
		// TODO Auto-generated method stub
		
		List<String> list1=args.getNonOptionArgs();
		//System.out.println(list1);
		List<String> list2=args.getOptionValues("admin.user");

		
		if(list1.isEmpty())
		{
			System.out.println("No Named Arguments Found.!!");
		}
		else
		{
			System.out.println("Named Args--->"+list1);

		}
		
		if(args.containsOption("admin.user"))
		{
			System.out.println("Unamed Arguments : "+list2);

		}
		else
		{
			System.out.println("No UnNamed arguments Found.!!");
		}
		
		Set<String> set=args.getOptionNames();
		for(String key : set)
		{

			System.out.println(key+" ---> "+args.getOptionValues(key));
			
		}

	}
	
	

}
