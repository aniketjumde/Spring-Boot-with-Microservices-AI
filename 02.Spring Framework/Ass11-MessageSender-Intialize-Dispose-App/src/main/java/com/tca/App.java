package com.tca;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tca.bean.MessageSender;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
    	
    	 MessageSender messageSender = context.getBean(MessageSender.class);
         messageSender.Connection();  	
    	
    	
    	((ClassPathXmlApplicationContext) context).close();
    	
    	System.out.println("Byy");
    	
    }
}
