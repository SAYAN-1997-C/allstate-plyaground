package com.stackroute.bookmarkapi.service;

import java.util.List;

import com.stackroute.bookmarkapi.exceptions.BookmarkIdIsAlreadyExistException;
import com.stackroute.bookmarkapi.exceptions.BookmarkIdNotFoundException;
import com.stackroute.bookmarkapi.exceptions.EmailIdIsNotValidException;
import com.stackroute.bookmarkapi.model.Userbookmark;

public interface UserbookmarkService {
	
	Userbookmark addIntoBookmark(Userbookmark ubook) throws BookmarkIdIsAlreadyExistException;
	
	boolean deleteFromBookmark(String bookmarkId) throws BookmarkIdNotFoundException;
	
	List<Userbookmark> viewBookmarkByemail(String email) throws EmailIdIsNotValidException;

}
