package com.stackroute.sampleJavaMetaData;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stackroute.sampleJavaMetaData.config.ItemConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext appcotext = new AnnotationConfigApplicationContext(ItemConfig.class);
        Hotel hotel = appcotext.getBean("hotelbean",Hotel.class);
        System.out.println(hotel);
    }
}
