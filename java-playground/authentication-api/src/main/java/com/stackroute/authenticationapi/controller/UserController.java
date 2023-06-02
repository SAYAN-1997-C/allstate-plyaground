package com.stackroute.authenticationapi.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.authenticationapi.model.Userprofile;
import com.stackroute.authenticationapi.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@PostMapping("/auth/adduser")
	public ResponseEntity<?> addUser(@RequestBody Userprofile userobj){
		
		Userprofile uprofile = userservice.registerUser(userobj);
		return new ResponseEntity<Userprofile>(uprofile,HttpStatus.CREATED);
	}

	@PostMapping("/auth/login")
	public ResponseEntity<?> loginuser(@RequestBody Userprofile userobj) {
		
		boolean flag = userservice.validateUser(userobj.getMailid(), userobj.getPassword());
		
		if(flag) {
			String tokenResult = generateToken(userobj);
			Map<String, String> mytoken = new HashMap<String, String>();
			mytoken.put("token", tokenResult);
			return new  ResponseEntity<Map>(mytoken,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Invalid Credentials",HttpStatus.UNAUTHORIZED);
		}
	}
	
	String generateToken(Userprofile obj) {
		
		long expiry = 10_000_00;
		
		return Jwts.builder().setIssuedAt(new Date(System.currentTimeMillis()))
				.setSubject(obj.getName())
				.setExpiration(new Date(System.currentTimeMillis()+expiry))
				.signWith(SignatureAlgorithm.HS256, "allstatekey")
				.compact();
	}
}
