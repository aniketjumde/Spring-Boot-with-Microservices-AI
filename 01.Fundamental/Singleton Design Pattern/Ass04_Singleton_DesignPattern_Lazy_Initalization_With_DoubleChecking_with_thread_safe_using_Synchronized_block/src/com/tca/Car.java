package com.tca;

public class Car 
{
	private static Car car=null;
	
	private Car()
	{
		System.out.println("Constructor's Car");
	}
	
	public static Car getIntance()
	{
		if(car==null)
		{
			synchronized(Car.class)
			{
				car=new Car();
			}
						
		}
		
		return car;

	}
}
