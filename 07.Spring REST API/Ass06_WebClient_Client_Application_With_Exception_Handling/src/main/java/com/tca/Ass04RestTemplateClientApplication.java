package com.tca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class Ass04RestTemplateClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ass04RestTemplateClientApplication.class, args);
		
	}
	
	@Bean
	public WebClient getRestTemplate()
	{
		return WebClient.create();
	}

}
