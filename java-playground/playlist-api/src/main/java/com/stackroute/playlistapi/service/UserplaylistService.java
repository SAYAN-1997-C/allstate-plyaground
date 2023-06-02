package com.stackroute.playlistapi.service;

import java.util.List;

import com.stackroute.playlistapi.exceptions.EmailIdIsNotValidException;
import com.stackroute.playlistapi.exceptions.PlaylistIdAlreadyexistException;
import com.stackroute.playlistapi.exceptions.PlaylistIdIsNotFoundException;
import com.stackroute.playlistapi.model.Userplaylist;

public interface UserplaylistService {

	Userplaylist addIntoPlaylist(Userplaylist uplay) throws PlaylistIdAlreadyexistException;
	
	boolean deleteFromPlaylist(String playlistId) throws PlaylistIdIsNotFoundException;
	
	List<Userplaylist> viewPlaylistByemail(String email) throws EmailIdIsNotValidException;
}
