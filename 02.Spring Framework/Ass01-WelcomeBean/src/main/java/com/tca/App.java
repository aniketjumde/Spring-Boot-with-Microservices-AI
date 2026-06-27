package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tca.bean.Welcome;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        /*
        Welcome welcome=(Welcome)context.getBean("welcome");
        */
        
        Object ob=context.getBean(Welcome.class);
        Welcome welcome=(Welcome)ob;
        String str=welcome.getMessage();
        
        System.out.println(str);
    }
}
