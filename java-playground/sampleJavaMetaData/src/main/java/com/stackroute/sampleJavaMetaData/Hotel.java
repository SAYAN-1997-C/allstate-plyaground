package com.stackroute.sampleJavaMetaData;

import org.springframework.beans.factory.annotation.Autowired;

public class Hotel {

	String hotelName;
	String addr;
	@Autowired
	Item item;
	
	public Hotel() {}
	@Autowired
	public Hotel(Item item) {
		this.item = item;
	}

	public Hotel(String hotalName, String addr, Item item) {
		super();
		this.hotelName = hotalName;
		this.addr = addr;
		this.item = item;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotalName) {
		this.hotelName = hotalName;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Hotel [hotalName=" + hotelName + ", addr=" + addr + ", item=" + item + "]";
	}
	
}
