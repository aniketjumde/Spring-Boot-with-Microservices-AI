package com.tca.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value=1)
public class MyRunner2	implements ApplicationRunner
{


	@Override
	public void run(ApplicationArguments args) throws Exception 
	{
		
		// TODO Auto-generated method stub
		System.out.println("MyRunner 2 started ");

	}

}
