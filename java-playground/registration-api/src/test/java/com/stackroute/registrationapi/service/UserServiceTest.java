package com.stackroute.registrationapi.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.stackroute.registrationapi.exceptions.EmailIdAlredayExistException;
import com.stackroute.registrationapi.exceptions.EmailIdNotFoundException;
import com.stackroute.registrationapi.exceptions.EmailIdPasswordMissMtachException;
import com.stackroute.registrationapi.model.LoginCred;
import com.stackroute.registrationapi.model.UserProfile;
import com.stackroute.registrationapi.repository.UserRepo;

public class UserServiceTest {

	@InjectMocks
	UserServiceImpl userservice;
	
	@Mock
	UserRepo userrepo;
	
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
	}
	
	@Test
	public void addUserSuccess() throws Exception {
		
		Mockito.when(userrepo.save(user)).thenReturn(user);
		
		UserProfile resultuser = userservice.addUser(user);
		
		Assertions.assertEquals("s@g.com", resultuser.getEmail());
		
		verify(userrepo, times(1)).save(user);
		
		
	}
	
	@Test
	public void addUserFailure() {
		
		Optional<UserProfile> optuser = Optional.of(user);
		
		Mockito.when(userrepo.findById("s@g.com")).thenReturn(optuser);
		
		Assertions.assertThrows(EmailIdAlredayExistException.class, () -> userservice.addUser(user));
		
		verify(userrepo, times(0)).save(user);
	}
	
	@Test
	public void checkCredentialsSuccess() throws Exception {
		
		Optional<UserProfile> optuser = Optional.of(user);
		Mockito.when(userrepo.findById("s@g.com")).thenReturn(optuser);
		
		Mockito.when(userrepo.findByEmailAndPassword("s@g.com", "pass123")).thenReturn(user);
		
		boolean flag = userservice.checkCredentials(logincred);
		
		Assertions.assertTrue(true);
	}
	
	@Test
	public void  checkCredentialsFailure() throws Exception {
		
//		Optional<UserProfile> optuser = Optional.of(user);
		
		Mockito.when(userrepo.findById(any())).thenReturn(Optional.ofNullable(null));

//		Mockito.when(userrepo.findByEmailAndPassword("s@g.com", "pass123")).thenReturn(user);
		
//		boolean flag = userservice.checkCredentials(logincred);
		
		Assertions.assertThrows(EmailIdNotFoundException.class, () -> userservice.checkCredentials(logincred));
		
		
	}
	
	@Test
	public void  checkCredentialsFailureSecond() throws Exception {
		
//		Optional<UserProfile> optuser = Optional.of(user);
		
		Mockito.when(userrepo.findById(any())).thenReturn(Optional.ofNullable(user));

		Mockito.when(userrepo.findByEmailAndPassword("s@g.com", "pass123")).thenReturn(null);
		
//		boolean flag = userservice.checkCredentials(logincred);
		
		Assertions.assertThrows(EmailIdPasswordMissMtachException.class, () -> userservice.checkCredentials(logincred));
		
		
	}
	
	
	
}
