package com.stackroute.sampleJavaMetaData.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stackroute.sampleJavaMetaData.Hotel;
import com.stackroute.sampleJavaMetaData.Item;

@Configuration
public class ItemConfig {
	
	@Bean("itembean")
	public Item createItem() {
		Item itemObj = new Item("cake",40);
		return itemObj;
	}
	
	@Bean("hotelbean")
	public Hotel createHotel() {
		
		Hotel hotelObj = new Hotel();
		hotelObj.setHotelName("Hayat");
		hotelObj.setAddr("Kolkata");
		return hotelObj;
	}
}
