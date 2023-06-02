package com.stackroute.bookmarkapi.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.bookmarkapi.model.Userbookmark;

@Repository
public interface UserbookmarkRepo extends MongoRepository<Userbookmark, String> {

	List<Userbookmark> findByEmail(String email);
}
