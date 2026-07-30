package com.tca.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreedBean 
{
	@Autowired
	public WelcomeBean welcomeBean;
	
	public GreedBean()
	{
		System.out.println("GreadBean Constructor");
	}
	
	public void print()
	{
		welcomeBean.printMessage();
	}
}
