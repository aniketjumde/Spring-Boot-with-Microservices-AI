package com.tca.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A
{
	//@Autowired
	//private static B b;
	
	//private static final B b;
	//private static can not Inject By Autowired Beacause you can not Change the Reference in Static can not access
	
	final B b; // This can Be Executed Only throw Constructer Injection
	
	
	@Autowired
	public A(B b)
	{
		this.b=b;
		System.out.println("A's Constructor using Autowired");
	}
	
	//@Autowired
//	public void  setA(B b)
//	{
//		this.b=b;
//		System.out.println("A's Stter Injection");
//	}
	
	public void methodA()
	{
		b.methodB();
	}
}
