package com.stackroute.librarymvcPractice.model;

public class Book {

	String bookid;
	String bookname;
	
	public Book() {}

	public Book(String bookid, String bookname) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
	}

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookname=" + bookname + "]";
	}
	
}
