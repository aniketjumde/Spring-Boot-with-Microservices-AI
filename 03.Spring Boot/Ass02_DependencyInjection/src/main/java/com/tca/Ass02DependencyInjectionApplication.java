package com.tca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.tca.bean.ServiceA;
import com.tca.bean.ServiceB;

@SpringBootApplication
public class Ass02DependencyInjectionApplication {

	public static void main(String[] args) 
	{
		ApplicationContext context=SpringApplication.run(Ass02DependencyInjectionApplication.class, args);
		
		ServiceB serviceB=context.getBean(ServiceB.class);
		serviceB.print();
	}

}
