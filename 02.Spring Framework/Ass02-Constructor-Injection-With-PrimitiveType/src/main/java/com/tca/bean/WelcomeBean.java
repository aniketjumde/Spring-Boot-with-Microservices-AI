package com.tca.bean;

public class WelcomeBean
{
	private int id;
	private String name;
	
	public WelcomeBean(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
}
