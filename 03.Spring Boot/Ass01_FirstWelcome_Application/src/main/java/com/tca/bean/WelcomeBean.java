package com.tca.bean;

import org.springframework.stereotype.Component;

@Component
public class WelcomeBean
{
	public WelcomeBean()
	{
		System.out.println("WelcomeBean Constructir");
	}
	
	public void printMessage()
	{
		System.out.println("Welcome To All");
	}

}
