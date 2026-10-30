package com.tca.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tca.Exception.EmployeeAlreadyExistException;
import com.tca.Exception.EmployeeNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> handleEmployeeNotFound(EmployeeNotFoundException ex)
	{
		//return new ResponseEntity<String>("Error : " + ex.getMessage(), HttpStatus.NOT_FOUND);
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	
	@ExceptionHandler(EmployeeAlreadyExistException.class)
	public ResponseEntity<String> handleEmployeeAlreadyExits(EmployeeAlreadyExistException ex)
	{
		
		//return ResponseEntity<String>("Error : "+ex.getMessage(), HttpStatus.CONFLICT);
		 return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());

	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex)
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}
}


