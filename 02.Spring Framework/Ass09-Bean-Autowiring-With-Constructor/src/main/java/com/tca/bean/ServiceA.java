package com.tca.bean;

public class ServiceA 
{
	private ServiceB serviceB;

	public ServiceA(ServiceB serviceB) 
	{
		this.serviceB = serviceB;
		System.out.println("Constructor Injection");
	}

	
	
	
	
}
