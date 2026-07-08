package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tca.bean.ReportManager;

/**
 * Hello world!
 */
public class App
{
    public static void main(String[] args) 
    {
    	
    	ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
    	
    	ReportManager report=context.getBean(ReportManager.class);
    	report.printReport();
    }
}
