package com.tca.enums;

public enum Gender 
{
	MALE("M"),
	FEMALE("F"),
	OTHER("O");
	
	private final String value; 
	
	private Gender(String value)
	{
		this.value=value;
	}
	
	public String getValue()
	{
		return value;	
	}
}
