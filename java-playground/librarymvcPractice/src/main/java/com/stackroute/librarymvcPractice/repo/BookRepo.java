package com.stackroute.librarymvcPractice.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.stackroute.librarymvcPractice.model.Book;

public class BookRepo {
	
	List<Book> books = new ArrayList<Book>();
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
	public void deleteBook(String bookid) {
		Predicate<Book> prebook = (bk) -> bk.getBookid().equals(bookid);
		books.removeIf(prebook);
	}

}
