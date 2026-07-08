package com.tca.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ServiceA implements BeanNameAware,ApplicationContextAware
{
	private String message;
	private String myBeanName;
	private ApplicationContext myContainer;
	
	public ServiceA()
	{
		System.out.println("Creation of Bean");
	}

	public void setMessage(String message)
	{
		this.message = message;
		System.out.println("Injection of Bean");
	}
	
	public void printMessage()
	{
		System.out.println("Print Message -->"+message);
	}

	@Override
	public void setBeanName(String name) 
	{
		this.myBeanName=name;
		System.out.println("Bean Name : "+myBeanName);
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException 
	{
		this.myContainer=applicationContext;
		System.out.println("Spring Bean Contener");
		/*
		 * 
		ServiceA ob=myContainer.getBean(ServiceA.class);
		ob.printMessage();
		 */
	}
	
	
}
