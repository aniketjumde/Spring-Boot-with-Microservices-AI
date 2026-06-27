package com.tca.bean;

public class Customer 
{
	private int cid;
	private String name;
	
	private Address address;
	
	public Customer(int cid,String name,Address address)
	{
		this.cid=cid;
		this.name=name;
		this.address=address;
	}

	public int getCid() {
		return cid;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}
	
	
}
