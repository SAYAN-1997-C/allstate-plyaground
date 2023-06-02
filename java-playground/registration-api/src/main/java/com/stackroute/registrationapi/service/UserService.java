package com.stackroute.registrationapi.service;

import com.stackroute.registrationapi.exceptions.EmailIdAlredayExistException;
import com.stackroute.registrationapi.exceptions.EmailIdNotFoundException;
import com.stackroute.registrationapi.model.LoginCred;
import com.stackroute.registrationapi.model.UserProfile;

public interface UserService {

	UserProfile addUser(UserProfile newUser) throws EmailIdAlredayExistException;
	
	boolean checkCredentials(LoginCred credential) throws Exception ;
	
}
