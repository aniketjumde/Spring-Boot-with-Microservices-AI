package com.tca.bean;

public class Student 
{
	private int id;
	private String name;
	private Double fees;
	private String passportId;
	
	public Student(int id,String name,Double fees)
	{
		this.id=id;
		this.name=name;
		this.fees=fees;
	}

	public String getPassportId() {
		return passportId;
	}

	public void setPassportId(String passportId) {
		this.passportId = passportId;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getFees() {
		return fees;
	}
	
	
	
	

}
