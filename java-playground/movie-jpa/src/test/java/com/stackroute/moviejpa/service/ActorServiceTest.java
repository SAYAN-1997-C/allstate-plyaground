package com.stackroute.moviejpa.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.stackroute.moviejpa.exceptions.ActoridAlreadyExistEception;
import com.stackroute.moviejpa.model.Actor;
import com.stackroute.moviejpa.repository.ActorRepo;

public class ActorServiceTest {

	@InjectMocks
	ActorServiceImpl actorservice;
	
	@Mock
	ActorRepo actorrepo;
	
	Actor actor;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		actor = new Actor();
		actor.setActorid("A1");
		actor.setActorName("Sayan");
		actor.setAge(24);
		actor.setMovies("DDLJ");
	}
	
	@Test
	public void addActorSuccess() throws Exception {
		Mockito.when(actorrepo.save(actor)).thenReturn(actor);
		
		Actor resultactor = actorservice.addActor(actor);
		
		Assertions.assertEquals("Sayan", resultactor.getActorName());
		
		verify(actorrepo , times(1)).save(actor);
	}
	
	@Test
	public void addActorFailure() {
		
		Optional<Actor> optactor = Optional.of(actor);
		
		Mockito.when(actorrepo.findById("A1")).thenReturn(optactor);
		
		Assertions.assertThrows(ActoridAlreadyExistEception.class, () -> actorservice.addActor(actor));
		
		verify(actorrepo , times(0)).save(actor);
		
	}
	
	@Test
	public void deleteActorSuccess() throws Exception {
		
		Optional<Actor> optactor = Optional.of(actor);
		
		Mockito.when(actorrepo.findById("A1")).thenReturn(optactor);
		
		boolean flag = actorservice.deleteActor("A1");
		
		Assertions.assertTrue(true);
		
	}
}
