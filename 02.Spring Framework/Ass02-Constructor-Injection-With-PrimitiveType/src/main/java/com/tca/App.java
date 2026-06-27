package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tca.bean.WelcomeBean;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) 
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
    	
    	WelcomeBean welcomeBean=(WelcomeBean)context.getBean(WelcomeBean.class);
    	System.out.println(welcomeBean.getId());
    	System.out.println(welcomeBean.getName());

    }
}
