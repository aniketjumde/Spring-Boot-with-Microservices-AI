package com.tca.bean;

import org.springframework.stereotype.Component;

@Component
public class ServiceA 
{
	public ServiceA()
	{
		System.out.println("ServiceA Constructor");
	}
	
	public void printMessage()
	{
		System.out.println("Service'A Info");
	}
}
