package com.stackroute.playlistapi.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.playlistapi.model.Userplaylist;

@Repository
public interface UserplaylistRepo extends MongoRepository<Userplaylist, String> {

	List<Userplaylist> findByEmail(String email);
}
