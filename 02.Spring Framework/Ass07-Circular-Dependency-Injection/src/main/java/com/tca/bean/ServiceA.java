package com.tca.bean;

public class ServiceA 
{
	
	private ServiceB serviceB;

	public ServiceA(ServiceB serviceB) 
	{
		this.serviceB = serviceB;
	}
	
	
	public void display()
	{
		System.out.println("Display : A");
	    serviceB.show();
	}
}
