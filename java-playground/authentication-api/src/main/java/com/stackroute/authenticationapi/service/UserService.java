package com.stackroute.authenticationapi.service;

import com.stackroute.authenticationapi.model.Userprofile;

public interface UserService {

	Userprofile registerUser(Userprofile userobj);
	boolean validateUser(String mailid,String password);
}
