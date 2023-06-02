package com.stackroute.moviejpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Actor {
	
	@Id
	String actorid;
	
	String actorName;
	String movies;
	int age;
	
	public String getActorid() {
		return actorid;
	}
	public void setActorid(String actorid) {
		this.actorid = actorid;
	}
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public String getMovies() {
		return movies;
	}
	public void setMovies(String movies) {
		this.movies = movies;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
