package com.tca.Exception;

public class EmployeeNotFoundException extends RuntimeException{
	
	public EmployeeNotFoundException(String msg)
	{
		super(msg);
	}

}
