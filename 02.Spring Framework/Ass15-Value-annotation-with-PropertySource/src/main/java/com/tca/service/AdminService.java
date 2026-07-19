package com.tca.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AdminService 
{
	@Value("${admin.url}")
	private String adminURL;
	
	@Value("${admin.port}")
	private int port;
	
	@Value("${admin.user}")
	private String userName;
	
	@Value("${admin.password}")
	private String password;
	
	public void printInformation()
	{
		System.out.println("Admin URL :"+adminURL);
		System.out.println("Port      :"+port);
		System.out.println("UserName  :"+userName);
		System.out.println("password  :"+password);
		
	}
}
