package com.stackroute.moviejpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.moviejpa.model.Actor;

@Repository
public interface ActorRepo extends JpaRepository<Actor, String> {

	List<Actor> findByActorName(String name);
	
}
