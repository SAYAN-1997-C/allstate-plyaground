package com.stackroute.moviejpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.moviejpa.exceptions.ActorNotFoundException;
import com.stackroute.moviejpa.exceptions.ActoridAlreadyExistEception;
import com.stackroute.moviejpa.model.Actor;
import com.stackroute.moviejpa.repository.ActorRepo;

@Service
public class ActorServiceImpl implements ActorService {

	@Autowired
	ActorRepo actRepo;
	
	@Override
	public Actor addActor(Actor newActor) throws ActoridAlreadyExistEception {
		// TODO Auto-generated method stub
		Optional<Actor> actopt = actRepo.findById(newActor.getActorid());
		if(actopt.isPresent()) {
			throw new ActoridAlreadyExistEception("Duplicate id");
		}
		
		Actor result = actRepo.save(newActor);
		return result;
	}

	@Override
	public List<Actor> getActors() {
		// TODO Auto-generated method stub
		return actRepo.findAll();
	}

	@Override
	public List<Actor> findByActorName(String name) {
		
		return actRepo.findByActorName(name);
	}

	@Override
	public boolean deleteActor(String actId) throws ActorNotFoundException {
		
		Optional<Actor> actopt = actRepo.findById(actId);
		if(actopt.isEmpty()) {
			throw new ActorNotFoundException("record does not exist for delete");
		}
		actRepo.delete(actopt.get());
		return true;
	}

	@Override
	public Actor updateActor(Actor actModi) throws ActorNotFoundException {
		
		Optional<Actor> actopt = actRepo.findById(actModi.getActorid());
		
		if(actopt.isEmpty()) {
			throw new ActorNotFoundException("Id not available");
		}
		Actor actorModified = actRepo.save(actModi);
		return actorModified;
	}

}
