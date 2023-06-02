package com.stackroute.sanpleAutoWire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext appcontext = new ClassPathXmlApplicationContext("mybean.xml");
       
       Hotel hotelObj = appcontext.getBean("hotelbean",Hotel.class);
       
       System.out.println(hotelObj);
       
       ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
       
       Samsung sam = appContext.getBean(Samsung.class);
       
       sam.config();
       
    }
}
