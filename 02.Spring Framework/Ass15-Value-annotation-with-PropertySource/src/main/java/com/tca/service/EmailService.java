package com.tca.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService
{
	@Value("${smtp.url}")
	private String smtpURL;
	
	@Value("${smtp.port}")
	private int smtPort;
	
	@Value("${to.address}")
	private String toAddress;

	@Value("${from.address}")
	private String fromAddress;
	
	public void sendMail()
	{
		System.out.println("Sending email from "+fromAddress+" to "+toAddress+" throw "+smtpURL+" port "+smtPort);
	}
}
