package com.stackroute.authenticationapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Userprofile {

	@Id
	String mailid;
	String password;
	String name;
	String addr;
	
	public Userprofile() {}
	
	public Userprofile(String mailid, String password, String name, String addr) {
		super();
		this.mailid = mailid;
		this.password = password;
		this.name = name;
		this.addr = addr;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Userprofile [mailid=" + mailid + ", password=" + password + ", name=" + name + ", addr=" + addr + "]";
	}
	
}
