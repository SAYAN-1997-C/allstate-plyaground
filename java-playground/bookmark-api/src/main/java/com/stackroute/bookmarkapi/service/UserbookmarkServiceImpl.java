package com.stackroute.bookmarkapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.bookmarkapi.exceptions.BookmarkIdIsAlreadyExistException;
import com.stackroute.bookmarkapi.exceptions.BookmarkIdNotFoundException;
import com.stackroute.bookmarkapi.exceptions.EmailIdIsNotValidException;
import com.stackroute.bookmarkapi.model.Userbookmark;
import com.stackroute.bookmarkapi.repository.UserbookmarkRepo;

@Service
public class UserbookmarkServiceImpl implements UserbookmarkService {

	@Autowired
	UserbookmarkRepo urepo;

	@Override
	public Userbookmark addIntoBookmark(Userbookmark ubook) throws BookmarkIdIsAlreadyExistException {
		
		Optional<Userbookmark> opt = urepo.findById(ubook.getBookmarkid());
		if(opt.isPresent()) {
			throw new BookmarkIdIsAlreadyExistException("BookmarkId already exist. This song is already in Bookmark");
		}
		Userbookmark res = urepo.save(ubook);
		return res;
	}

	@Override
	public boolean deleteFromBookmark(String bookmarkId) throws BookmarkIdNotFoundException {
		
		Optional<Userbookmark> opt = urepo.findById(bookmarkId);
		if(opt.isEmpty()) {
			throw new BookmarkIdNotFoundException("Bookmark id is invalid. Kindly check");
		}
		urepo.deleteById(bookmarkId);
		return true;
	}

	@Override
	public List<Userbookmark> viewBookmarkByemail(String email) throws EmailIdIsNotValidException {
		List<Userbookmark> bookmarkbymail = urepo.findByEmail(email);
		if(bookmarkbymail.isEmpty()) {
			throw new EmailIdIsNotValidException("Email id not valid");
		}
		return bookmarkbymail;
	}
	
}
