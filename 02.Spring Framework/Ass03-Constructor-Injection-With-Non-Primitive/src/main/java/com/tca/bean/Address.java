package com.tca.bean;

public class Address
{
	private String city;
	private int pincode;
	
	public Address(String city,int pincode)
	{
		this.city=city;
		this.pincode=pincode;
	}

	public String getCity() {
		return city;
	}

	
	public int getPincode() {
		return pincode;
	}

	

	
	
}
