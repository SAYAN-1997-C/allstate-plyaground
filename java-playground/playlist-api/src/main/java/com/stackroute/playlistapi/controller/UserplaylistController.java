package com.stackroute.playlistapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.playlistapi.exceptions.EmailIdIsNotValidException;
import com.stackroute.playlistapi.exceptions.PlaylistIdAlreadyexistException;
import com.stackroute.playlistapi.exceptions.PlaylistIdIsNotFoundException;
import com.stackroute.playlistapi.model.Userplaylist;
import com.stackroute.playlistapi.service.UserplaylistService;

@RestController
@RequestMapping("/playlist/")
@CrossOrigin
public class UserplaylistController {
	
	@Autowired
	UserplaylistService pService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addintoplaylist(@RequestBody Userplaylist newUserSong) {
		
		try {
			Userplaylist res = pService.addIntoPlaylist(newUserSong);
			return new ResponseEntity<Userplaylist>(res,HttpStatus.CREATED);
		} catch (PlaylistIdAlreadyexistException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		
	}
	
	@GetMapping("/view/{email}")
	public ResponseEntity<?> viewplaylistbyemail(@PathVariable("email") String email) {
		
		try {
			List<Userplaylist> resList = pService.viewPlaylistByemail(email);
			return new ResponseEntity<List>(resList,HttpStatus.OK);
		} catch (EmailIdIsNotValidException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{playlistid}")
	public ResponseEntity<?> deletefromplaylist(@PathVariable("playlistid") String playlistid) {
		
		try {
			pService.deleteFromPlaylist(playlistid);
			return new ResponseEntity<String>("Song is successfully deleted from playlist",HttpStatus.OK);
		} catch (PlaylistIdIsNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	

}
