package com.stackroute.playlistapi.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.playlistapi.exceptions.EmailIdIsNotValidException;
import com.stackroute.playlistapi.exceptions.PlaylistIdAlreadyexistException;
import com.stackroute.playlistapi.exceptions.PlaylistIdIsNotFoundException;
import com.stackroute.playlistapi.model.Userplaylist;
import com.stackroute.playlistapi.repository.UserplaylistRepo;

@Service
public class UserplaylistServiceImpl implements UserplaylistService {
	
	@Autowired
	UserplaylistRepo urepo;

	@Override
	public Userplaylist addIntoPlaylist(Userplaylist uplay) throws PlaylistIdAlreadyexistException {
		Optional<Userplaylist> opt = urepo.findById(uplay.getPlaylistid());
		if(opt.isPresent()) {
			throw new PlaylistIdAlreadyexistException("Playlistid already exist. This song is already in playlist");
		}
		Userplaylist res = urepo.save(uplay);
		return res;
	}

	@Override
	public boolean deleteFromPlaylist(String playlistId) throws PlaylistIdIsNotFoundException {
		
		Optional<Userplaylist> opt = urepo.findById(playlistId);
		if(opt.isEmpty()) {
			throw new PlaylistIdIsNotFoundException("Playlist id is invalid. kindly check");
		}
		urepo.deleteById(playlistId);
		return true;
	}

	@Override
	public List<Userplaylist> viewPlaylistByemail(String email) throws EmailIdIsNotValidException {
	
		List<Userplaylist> playlistByEmail = urepo.findByEmail(email);
		if(playlistByEmail.isEmpty()) {
			throw new EmailIdIsNotValidException("Email id not valid.");
		}
		return playlistByEmail;
	}

}
