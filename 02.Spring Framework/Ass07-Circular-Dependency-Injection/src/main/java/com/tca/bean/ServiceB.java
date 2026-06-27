package com.tca.bean;

public class ServiceB 
{
	private ServiceA serviceA;

	public ServiceA getServiceA() {
		return serviceA;
	}

	public void setServiceA(ServiceA serviceA) {
		this.serviceA = serviceA;
	}
	
	public void show()
	{
		//serviceA.display();
		System.out.println("Show : B");
	}

}
