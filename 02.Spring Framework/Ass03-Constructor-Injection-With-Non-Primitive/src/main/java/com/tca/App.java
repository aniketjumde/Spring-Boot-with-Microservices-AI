package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tca.bean.Customer;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) 
    {

    	ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
    	
    	Customer customer=(Customer)context.getBean(Customer.class);
    	
    	System.out.println(customer.getCid());
    	System.out.println(customer.getName());
    	System.out.println(customer.getAddress().getCity());
    	System.out.println(customer.getAddress().getPincode());
    	

    	
    }
}
