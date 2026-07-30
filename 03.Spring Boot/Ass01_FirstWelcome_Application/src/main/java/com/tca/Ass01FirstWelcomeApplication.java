package com.tca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tca.bean.GreedBean;
import com.tca.bean.WelcomeBean;

@SpringBootApplication //= componentScan + EnableConfiguration + Configuration
public class Ass01FirstWelcomeApplication 
{

	private final WelcomeBean welcomeBean;

	Ass01FirstWelcomeApplication(WelcomeBean welcomeBean) {
		this.welcomeBean = welcomeBean;
	}

	public static void main(String[] args)
	{
		ConfigurableApplicationContext context=SpringApplication.run(Ass01FirstWelcomeApplication.class, args);
		
		
		//System.out.println(context.getClass().getName());
		
		//WelcomeBean welcomeBean=context.getBean(WelcomeBean.class);
		//welcomeBean.printMessage();
		
		GreedBean greed=context.getBean(GreedBean.class);
		greed.print();
		
	}

}
