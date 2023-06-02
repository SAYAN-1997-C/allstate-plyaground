package com.stackroute.playlistapi.controller;

import org.junit.jupiter.api.BeforeEach;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.playlistapi.exceptions.EmailIdIsNotValidException;
import com.stackroute.playlistapi.exceptions.PlaylistIdAlreadyexistException;
import com.stackroute.playlistapi.model.Userplaylist;
import com.stackroute.playlistapi.service.UserplaylistService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserplaylistControllerTest {

	@InjectMocks
	UserplaylistController playlistcontroller;
	
	@MockBean
	UserplaylistService playlistservice;
	
	MockMvc mockmvc;
	
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
		mockmvc = MockMvcBuilders.standaloneSetup(playlistcontroller).build();

	}
	
	private String convertToJson(Object obj) throws JsonProcessingException{
		ObjectMapper objmapper = new ObjectMapper();
		String result = objmapper.writeValueAsString(obj);
		return result;
	}
	
	@Test
	public void addintoplaylistSuccessTest() throws Exception {
		Mockito.when(playlistservice.addIntoPlaylist(userplaylist)).thenReturn(userplaylist);
		mockmvc.perform(MockMvcRequestBuilders.post("/playlist/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(convertToJson(userplaylist)))
			.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
//	@Test
//	public void addintoplaylistFailureTest() throws Exception {
//		Mockito.when(playlistservice.addIntoPlaylist(userplaylist)).thenThrow(PlaylistIdAlreadyexistException.class);
//		mockmvc.perform(MockMvcRequestBuilders.post("/playlist/add")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(convertToJson(any())))
//			.andExpect(MockMvcResultMatchers.status().isConflict());
//	}
	
	@Test
	public void viewplaylistbyemailSuccessTest() throws Exception {
		List<Userplaylist> list =  new ArrayList<Userplaylist>();
		list.add(userplaylist);
		Mockito.when(playlistservice.viewPlaylistByemail("s@g.com")).thenReturn(list);
		mockmvc.perform(MockMvcRequestBuilders.get("/playlist/view/s@g.com")
				.contentType(MediaType.APPLICATION_JSON)
				.content(convertToJson(userplaylist)))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void viewplaylistbyemailFailureTest() throws Exception {
		
		Mockito.when(playlistservice.viewPlaylistByemail(any())).thenThrow(EmailIdIsNotValidException.class);
		mockmvc.perform(MockMvcRequestBuilders.get("/playlist/view/s@g.com")
				.contentType(MediaType.APPLICATION_JSON)
				.content(convertToJson(any())))
			.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	
	@Test
	public void deletefromplaylistSucessTest() throws Exception {
		
		Mockito.when(playlistservice.deleteFromPlaylist(any())).thenReturn(true);
		mockmvc.perform(MockMvcRequestBuilders.delete("/playlist/delete/p1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(convertToJson(any())))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void deletefromplaylistFailureTest() throws Exception {
		
		Mockito.when(playlistservice.deleteFromPlaylist(any())).thenReturn(true);
		mockmvc.perform(MockMvcRequestBuilders.delete("/playlist/delete/p1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(convertToJson(any())))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	
	
	
}
