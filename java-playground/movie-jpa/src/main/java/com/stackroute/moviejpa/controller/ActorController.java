package com.stackroute.moviejpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.moviejpa.exceptions.ActorNotFoundException;
import com.stackroute.moviejpa.exceptions.ActoridAlreadyExistEception;
import com.stackroute.moviejpa.model.Actor;
import com.stackroute.moviejpa.service.ActorService;

@RestController
@RequestMapping("/movie/")
public class ActorController {

	 
	@Autowired
	ActorService actservice;
	
	@GetMapping("/viewall")
	public ResponseEntity<?> getallmovies() {
		
		List<Actor> movieList = actservice.getActors();
		return new ResponseEntity<List> (movieList,HttpStatus.OK);
	}
	
	@GetMapping("/viewbyname/{name}")
	public ResponseEntity<?> getmoviebyname(@PathVariable("name") String name) {
		
		List<Actor> movielist = actservice.findByActorName(name);
		return new ResponseEntity<List>(movielist,HttpStatus.OK);
		
	}
	
	@PostMapping("/addactor")
	public ResponseEntity<?> addactor(@RequestBody Actor newactor) {
		
		Actor actobj;
		try {
			actobj = actservice.addActor(newactor);
			return new ResponseEntity<Actor>(actobj,HttpStatus.CREATED);
		} catch (ActoridAlreadyExistEception e) {
			
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		
	}
	
	@DeleteMapping("delete/{paramid}")
	public ResponseEntity<?> deleteactor(@PathVariable("paramid") String pid){
		
		try {
			boolean result = actservice.deleteActor(pid);
			return new ResponseEntity<String>("Record Deleted",HttpStatus.OK);
		} catch (ActorNotFoundException e) {
			// TODO: handle exception
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateactor(@RequestBody Actor newactor) {
		
		Actor actobj;
		
		try {
			actobj = actservice.updateActor(newactor);
			return new ResponseEntity<Actor> (actobj,HttpStatus.CREATED);
		} catch (ActorNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
}
