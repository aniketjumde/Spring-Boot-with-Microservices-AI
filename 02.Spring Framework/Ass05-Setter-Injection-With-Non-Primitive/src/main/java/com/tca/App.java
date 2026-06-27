package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tca.bean.Address;
import com.tca.bean.Customer;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) 
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");

    	Address address=(Address)context.getBean(Address.class);
    	System.out.println(address.getCity());
    	System.out.println(address.getPincode());
    	System.out.println("----------------");


    	Customer customer=(Customer)context.getBean(Customer.class);
    	
    	System.out.println(customer.getCid());
    	System.out.println(customer.getName());
    	System.out.println(customer.getAddress().getCity());
    	System.out.println(customer.getAddress().getPincode());
    	
    }
}
