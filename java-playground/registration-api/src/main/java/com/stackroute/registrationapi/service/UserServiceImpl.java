package com.stackroute.registrationapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.registrationapi.exceptions.EmailIdAlredayExistException;
import com.stackroute.registrationapi.exceptions.EmailIdNotFoundException;
import com.stackroute.registrationapi.exceptions.EmailIdPasswordMissMtachException;
import com.stackroute.registrationapi.model.LoginCred;
import com.stackroute.registrationapi.model.UserProfile;
import com.stackroute.registrationapi.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo uRepo;
	
	
	
	@Override
	public UserProfile addUser(UserProfile newUser) throws EmailIdAlredayExistException {
		
		Optional<UserProfile> user = uRepo.findById(newUser.getEmail());
		if(user.isPresent()) {
			throw new EmailIdAlredayExistException("Email Id is already exist.");
		}
		
		UserProfile res = uRepo.save(newUser);
		return res;
	}



	@Override
	public boolean checkCredentials(LoginCred credential) throws Exception {
		
//		UserProfile validUser = uRepo.findById(credential.getEmail()).orElseThrow( () -> new EmailIdNotFoundException("Email id is not registered.") );
		
		
		Optional<UserProfile> validUser = uRepo.findById(credential.getEmail());
		
		if(validUser.isEmpty()) {
			throw new EmailIdNotFoundException("Email id is not registered.");
		}
		
		UserProfile user = uRepo.findByEmailAndPassword(credential.getEmail(), credential.getPassword());
		if(user==null) {
			throw new EmailIdPasswordMissMtachException("Email id and password is not match.");
		}
		return true;
	}

}
