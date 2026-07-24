package com.tca;

public class ServiceA 
{
	private static ServiceA serviceA=null;
	
	private ServiceA()
	{
		System.out.println("Constructor's of ServiceA");
	}
	
	public static ServiceA getServiceAInstance()
	{
		if(serviceA==null)
		{
			serviceA=new ServiceA();
		}
		return serviceA;
	}

}
