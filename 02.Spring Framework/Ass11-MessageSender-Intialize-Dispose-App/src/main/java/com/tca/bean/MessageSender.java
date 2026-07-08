package com.tca.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageSender implements InitializingBean,DisposableBean
{
	private String serverIp;
	private int port;
	
	
	
	public void setServerIp(String serverIp) 
	{
		this.serverIp = serverIp;
		System.out.println("Setter Injection");
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void Connection()
	{
		System.out.println("Connected to the "+serverIp+"Port is "+port);
	}
	@Override
	public void destroy() throws Exception 
	{
		System.out.println(" Bean Destroy ");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception
	{
		System.out.println(" Bean Intializing ");
	}
	
	public void myinit()
	{
		System.out.println("Custom- Bean Intializing ");

	}
	
	public void mydestroy()
	{
		System.out.println("Custom- Bean Destroy ");
	}
}
