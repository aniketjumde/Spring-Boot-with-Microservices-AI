package com.tca.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Lazy
//@Scope("singleton") //Default
@Scope("prototype")
public class ServiceA 
{
	public ServiceA()
	{
		System.out.println("Constructer ServiceA");
	}
}
