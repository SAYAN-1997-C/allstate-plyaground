package com.stackroute.moviejpa.service;

import java.util.List;

import com.stackroute.moviejpa.exceptions.ActorNotFoundException;
import com.stackroute.moviejpa.exceptions.ActoridAlreadyExistEception;
import com.stackroute.moviejpa.model.Actor;

public interface ActorService {
	
	Actor addActor(Actor newActor) throws ActoridAlreadyExistEception;
	
	List<Actor> getActors();
	
	List<Actor> findByActorName(String name);
	
	boolean deleteActor(String actId) throws ActorNotFoundException;
	
	Actor updateActor(Actor actModi) throws ActorNotFoundException;
	

}
