package com.stackroute.registrationapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.registrationapi.model.UserProfile;

@Repository
public interface UserRepo extends JpaRepository<UserProfile, String> {
	
	UserProfile findByEmailAndPassword(String email,String password);
}
