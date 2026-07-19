package com.tca.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.tca")
@PropertySource("adminConfig.properties")
@PropertySource("emailConfig.properties")
public class AppConfig 
{

}
