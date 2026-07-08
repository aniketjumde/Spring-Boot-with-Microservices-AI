package com.tca.bean;

public class ServiceA 
{
	private ServiceB serviceB;

	
	public void setServiceB(ServiceB serviceB) 
	{
		this.serviceB = serviceB;
		System.out.println("Setter Injection");
	}
	
	
}
