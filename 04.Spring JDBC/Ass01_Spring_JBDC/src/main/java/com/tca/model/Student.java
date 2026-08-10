package com.tca.model;

public class Student
{
	private int rno;
	private String name;
	private double per;
	private String city;
	
	public Student() 
	{ 
		
	}
	
	public Student(int id, String name, double per, String city) {
		super();
		this.rno = id;
		this.name = name;
		this.per = per;
		this.city = city;
	}



	

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPer() {
		return per;
	}

	public void setPer(double per) {
		this.per = per;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
		
}
