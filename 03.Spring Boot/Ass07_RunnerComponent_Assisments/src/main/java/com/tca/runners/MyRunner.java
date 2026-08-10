package com.tca.runners;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception 
	{
		
		String theme="light";
		
		if(args.containsOption("theme-mode"))
		{
			theme=args.getOptionValues("theme-mode").get(0);
		}
		
		if(theme.equalsIgnoreCase("dark"))
		{
			System.out.println("Dark Mode Activated.!!");
		}
		else
		{
			System.out.println("Light Mode  Activated.!!");
		}
		
		
		
		List<String> list=args.getNonOptionArgs();
		System.out.println("Un-Named Arguments :");
		for(String s :list)
		{
			System.out.print(s+" ");
		}
		
	
	}

}
