package com.tca.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceB 
{
	@Autowired
	private ServiceA serviceA;
	
	public ServiceB()
	{
		System.out.println("ServiceB Constructor");
	}
	
	public void print()
	{
		serviceA.printMessage();
	}
}
