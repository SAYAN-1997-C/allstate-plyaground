package com.stackroute.playlistapi.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.stackroute.playlistapi.exceptions.EmailIdIsNotValidException;
import com.stackroute.playlistapi.exceptions.PlaylistIdAlreadyexistException;
import com.stackroute.playlistapi.exceptions.PlaylistIdIsNotFoundException;
import com.stackroute.playlistapi.model.Userplaylist;
import com.stackroute.playlistapi.repository.UserplaylistRepo;

public class UserPlaylistServiceTest {

	@InjectMocks
	UserplaylistServiceImpl playlistservice;
	
	@Mock
	UserplaylistRepo playlistrepo;
	
	Userplaylist userplaylist;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		userplaylist = new Userplaylist();
		userplaylist.setPlaylistid("p1");
		userplaylist.setSongname("Sadda haq");
		userplaylist.setAlbumid("A111");
		userplaylist.setAlbumname("Rcokstar");
		userplaylist.setArtistname("Ranbir kapur");
		userplaylist.setEmail("s@g.c");
		userplaylist.setHref("http//abc.com");
	}
	
	@Test
	public void addIntoPlaylistSuccess() throws Exception{
		
		Mockito.when(playlistrepo.save(userplaylist)).thenReturn(userplaylist);
		
		Userplaylist result = playlistservice.addIntoPlaylist(userplaylist);
		
		Assertions.assertEquals("p1", result.getPlaylistid());
		
		verify(playlistrepo , times(1)).save(userplaylist);
		
	}
	
	@Test
	public void addIntoPlaylistFailure() throws Exception{
		
		Optional<Userplaylist> opt = Optional.of(userplaylist);
		
		Mockito.when(playlistrepo.findById("p1")).thenReturn(opt);
		
		Assertions.assertThrows(PlaylistIdAlreadyexistException.class, () -> playlistservice.addIntoPlaylist(userplaylist));
		
		verify(playlistrepo, times(0)).save(userplaylist);
	}
	
	@Test
	public void deleteFromPlaylistSuccess() throws Exception {
		
		Optional<Userplaylist> opt = Optional.of(userplaylist);
		
		Mockito.when(playlistrepo.findById("p1")).thenReturn(opt);
		
		boolean flag = playlistservice.deleteFromPlaylist("p1");
		
		Assertions.assertTrue(flag);
		
	}
	
	@Test
	public void deleteFromPlaylistFailure() throws Exception {
			
		Mockito.when(playlistrepo.findById("p1")).thenReturn(Optional.empty());
		
		Assertions.assertThrows(PlaylistIdIsNotFoundException.class, () -> playlistservice.deleteFromPlaylist("p1"));
		
	}
	
	@Test
	public void viewPlaylistByemailSuccess() throws Exception {
		
		List<Userplaylist> list = new ArrayList<Userplaylist>();
		list.add(userplaylist);
		Mockito.when(playlistrepo.findByEmail("s@g.com")).thenReturn(list);
		Assertions.assertTrue(userplaylist!=null);
	}
	
	@Test
	public void viewPlaylistByemailFailure() throws Exception {
		List<Userplaylist> list =  new ArrayList<Userplaylist>() ;
		Mockito.when(playlistrepo.findByEmail("s@g.com")).thenReturn(list);
		Assertions.assertThrows(EmailIdIsNotValidException.class, () -> playlistservice.viewPlaylistByemail("s@g.com"));
		
	}
	
	
}
