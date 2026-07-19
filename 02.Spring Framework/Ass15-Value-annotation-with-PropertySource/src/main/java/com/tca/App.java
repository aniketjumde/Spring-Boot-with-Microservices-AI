package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tca.config.AppConfig;
import com.tca.service.AdminService;
import com.tca.service.EmailService;

/**
 * Hello world!
 */
public class App 
{
    public static void main(String[] args) 
    {
    	ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	AdminService adminService=context.getBean(AdminService.class);
    	adminService.printInformation();

		System.out.println();
	
    	EmailService emailService=context.getBean(EmailService.class);
    	emailService.sendMail();
    }
}
