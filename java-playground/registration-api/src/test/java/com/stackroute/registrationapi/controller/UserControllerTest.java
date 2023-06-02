package com.stackroute.registrationapi.controller;

import org.junit.jupiter.api.BeforeEach;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.registrationapi.exceptions.EmailIdAlredayExistException;
import com.stackroute.registrationapi.exceptions.EmailIdNotFoundException;
import com.stackroute.registrationapi.model.LoginCred;
import com.stackroute.registrationapi.model.UserProfile;
import com.stackroute.registrationapi.service.UserService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@InjectMocks
	UserController usercontroller;
	
	@MockBean
	UserService userservice;
	
	MockMvc mockmvc;
	
	UserProfile user;
	LoginCred logincred;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		user = new UserProfile();
		user.setEmail("s@g.com");
		user.setFirstname("Sayan");
		user.setLastname("Jashu");
		user.setPassword("pass123");
		
		logincred = new LoginCred();
		logincred.setEmail("s@g.com");
		logincred.setPassword("pass123");
		
		mockmvc = MockMvcBuilders.standaloneSetup(usercontroller).build();
	}
	
	private String convertToJson(Object obj) throws JsonProcessingException{
		ObjectMapper objmapper = new ObjectMapper();
		String result = objmapper.writeValueAsString(obj);
		return result;
	}
	
	@Test
	public void registerSuccessTest() throws Exception {
		
		Mockito.when(userservice.addUser(user)).thenReturn(user);
		mockmvc.perform(MockMvcRequestBuilders.post("/user/register")
				.contentType(MediaType.APPLICATION_JSON)
				.content(convertToJson(user)))
			.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	@Test
	public void resgisterFailureTest() throws Exception {
		
		Mockito.when(userservice.addUser(any())).thenThrow(EmailIdAlredayExistException.class);
		
		mockmvc.perform(MockMvcRequestBuilders.post("/user/register")
				.contentType(MediaType.APPLICATION_JSON)
				.content(convertToJson(user)))
			.andExpect(MockMvcResultMatchers.status().isConflict());
	}
	
	@Test
	public void loginCheckSuccessTest() throws Exception {
		
		Mockito.when(userservice.checkCredentials(logincred)).thenReturn(true);
		mockmvc.perform(MockMvcRequestBuilders.post("/user/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(convertToJson(logincred)))
			.andExpect(MockMvcResultMatchers.status().isOk());

		
	}

	@Test
	public void loginCheckFailureTest() throws Exception {
		
//		doThrow(EmailIdNotFoundException.class).when(userservice).checkCredentials(logincred);
		Mockito.when(userservice.checkCredentials(any())).thenThrow(Exception.class);
		mockmvc.perform(MockMvcRequestBuilders.post("/user/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(convertToJson(logincred)))
			.andExpect(MockMvcResultMatchers.status().isUnauthorized());

		
	}
}
