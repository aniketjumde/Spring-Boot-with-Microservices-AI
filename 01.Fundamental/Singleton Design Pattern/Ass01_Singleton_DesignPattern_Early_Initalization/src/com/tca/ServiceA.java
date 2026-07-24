package com.tca;

public class ServiceA 
{
	private static ServiceA serviceA=new ServiceA();
	
	private ServiceA()
	{
		System.out.println("Constructor's of ServiceA");
	}
	
	public static ServiceA getServiceAInstance()
	{
		return serviceA;
	}

}
