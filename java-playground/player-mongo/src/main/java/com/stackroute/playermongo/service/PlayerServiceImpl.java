package com.stackroute.playermongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.playermongo.exceptions.PlayerIdAlreadyExistException;
import com.stackroute.playermongo.model.Player;
import com.stackroute.playermongo.repo.PlayerRepo;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerRepo playerrepo;

	@Override
	public Player addPlayer(Player player) throws PlayerIdAlreadyExistException {
		Optional<Player> optplayer=	playerrepo.findById(player.getPlayerid());
		
		  if (optplayer.isPresent())
			  throw new PlayerIdAlreadyExistException("Duplicate player id");
		  
			
			 Player savedplayer= playerrepo.save(player);
			
			return savedplayer;
	}

	@Override
	public List<Player> viewPlayers() {
		
		  return playerrepo.findAll();
	}

	@Override
	public List<Player> getPlayerByCountry(String country) {
		
		return playerrepo.findByCountry(country);
	}

	@Override
	public boolean deletePlayer(String pid) {
		 
		playerrepo.deleteById(pid);
		return true;
	}

	@Override
	public Player updatePlayer(Player player) {
		Optional<Player> optplayer=	playerrepo.findById(player.getPlayerid());
		
		  if (optplayer.isEmpty())
			  return null;
		  
		 return playerrepo.save(player);
	}
	
	
}
