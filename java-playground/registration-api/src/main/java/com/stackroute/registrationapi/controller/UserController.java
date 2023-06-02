package com.stackroute.registrationapi.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.registrationapi.exceptions.EmailIdAlredayExistException;
import com.stackroute.registrationapi.model.LoginCred;
import com.stackroute.registrationapi.model.UserProfile;
import com.stackroute.registrationapi.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@RestController
@RequestMapping("/user/")
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService uService;
	
	@PostMapping("/register")
	public ResponseEntity<?> resgister(@RequestBody UserProfile newUser) {
		
		try {
			UserProfile res = uService.addUser(newUser);
			return new ResponseEntity<UserProfile>(res,HttpStatus.CREATED);
			
		} catch (EmailIdAlredayExistException e) {
			return new ResponseEntity<String>(e.getMessage() , HttpStatus.CONFLICT);
		}
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<?> logincheck(@RequestBody LoginCred cred) {
		
		try {
			boolean flag = uService.checkCredentials(cred);
			String tokenResult = generateToken(cred);
			Map<String, String> mytoken = new HashMap<String, String>();
			mytoken.put("token", tokenResult);
			return new ResponseEntity<Map>(mytoken, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage() , HttpStatus.UNAUTHORIZED);
		}
		
	}
	
	String generateToken(LoginCred obj) {
		
		long expiry = 10_000_00;
		
		return Jwts.builder().setIssuedAt(new Date(System.currentTimeMillis()))
				.setSubject(obj.getEmail())
				.setExpiration(new Date(System.currentTimeMillis()+expiry))
				.signWith(SignatureAlgorithm.HS256, "allstatekey")
				.compact();
	}

}
