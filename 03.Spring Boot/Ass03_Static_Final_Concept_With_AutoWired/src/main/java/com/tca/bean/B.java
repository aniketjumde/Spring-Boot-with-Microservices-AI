package com.tca.bean;

import org.springframework.stereotype.Component;

@Component
public class B
{
	
	public B()
	{
		System.out.println("B's Constructor !!!");
	}
	
	public void methodB()
	{
		System.out.println("B's Method ");
	}
}
