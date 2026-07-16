package com.tca.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AdminService
{
	@Value("https:/admin.com")
	private String adminURL;
	
	@Value("7070")
	private int port;
	
	@Value("admin")
	private String userName;
	
	@Value("admin@123")
	private String password;
	
	public void printInformation()
	{
		System.out.println("Admin URL :"+adminURL);
		System.out.println("Port      :"+port);
		System.out.println("UserName  :"+userName);
		System.out.println("password  :"+password);
		
	}
}
