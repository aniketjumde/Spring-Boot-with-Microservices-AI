package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tca.bean.ServiceA;
import com.tca.config.AppConfig;

public class App 
{
    public static void main(String[] args) 
    {
    	ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	ServiceA ob1=context.getBean(ServiceA.class);
    	ServiceA ob2=context.getBean(ServiceA.class);

    	System.out.println(ob1);
    	System.out.println(ob2);
    }
}
