package com.stackroute.playermongo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.playermongo.model.Player;

@Repository
public interface PlayerRepo extends MongoRepository<Player, String> {
	
	List<Player> findByCountry(String country);

}
