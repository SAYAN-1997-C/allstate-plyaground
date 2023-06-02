package com.stackroute.bookmarkapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.bookmarkapi.exceptions.BookmarkIdIsAlreadyExistException;
import com.stackroute.bookmarkapi.exceptions.BookmarkIdNotFoundException;
import com.stackroute.bookmarkapi.exceptions.EmailIdIsNotValidException;
import com.stackroute.bookmarkapi.model.Userbookmark;
import com.stackroute.bookmarkapi.service.UserbookmarkService;

@RestController
@RequestMapping("/bookmark/")
public class UserbookmarkController {
	
	@Autowired
	UserbookmarkService uService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addintobookmark(@RequestBody Userbookmark newUserSong) {
		
		try {
			Userbookmark res = uService.addIntoBookmark(newUserSong);
			return new ResponseEntity<Userbookmark>(res,HttpStatus.CREATED);
		} catch (BookmarkIdIsAlreadyExistException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/view/{email}")
	public ResponseEntity<?> viewbookmarkbyemail(@PathVariable("email") String email){
		
		try {
			List<Userbookmark> resList = uService.viewBookmarkByemail(email);
			return new ResponseEntity<List>(resList,HttpStatus.OK);
		} catch (EmailIdIsNotValidException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{bookmarkid}")
	public ResponseEntity<?> deletefrombookmark(@PathVariable("bookmarkid") String bookmarkid) {
		
		try {
			uService.deleteFromBookmark(bookmarkid);
			return new ResponseEntity<String>("Song is successfully deleted from bookmark",HttpStatus.OK);
			
		} catch (BookmarkIdNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

}
