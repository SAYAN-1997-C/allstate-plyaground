package com.stackroute.playermongo.service;

import java.util.List;

import com.stackroute.playermongo.exceptions.PlayerIdAlreadyExistException;
import com.stackroute.playermongo.model.Player;

public interface PlayerService {
	
	Player addPlayer(Player player) throws PlayerIdAlreadyExistException;
	
	List<Player> viewPlayers();
	
	List<Player> getPlayerByCountry(String country);
	
	boolean deletePlayer(String pid);
	
	Player updatePlayer(Player player);

}
