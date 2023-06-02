package com.stackroute.playermongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.playermongo.exceptions.PlayerIdAlreadyExistException;
import com.stackroute.playermongo.model.Player;
import com.stackroute.playermongo.service.PlayerService;

@RestController
@RequestMapping("/player/")
public class PlayerController {

	@Autowired
	PlayerService pserve;

	@PostMapping("addPlayer")
	public ResponseEntity<?> addPlayer(@RequestBody Player player) {
		try {
			Player result = pserve.addPlayer(player);

			return new ResponseEntity<Player>(result, HttpStatus.CREATED);
		} catch (PlayerIdAlreadyExistException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("viewPlayers")
	public ResponseEntity<?> viewall()
	{
		
		List<Player> players=	pserve.viewPlayers();
		
		
		return new ResponseEntity<List>(players,HttpStatus.OK);
	}

	@GetMapping("viewbycountry/{country}")
	public ResponseEntity<?> viewcountry(@PathVariable("country") String cntry)
	{
		
		List<Player> players=	pserve.getPlayerByCountry(cntry);
		
		
		return new ResponseEntity<List>(players,HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{playerid}")
	public ResponseEntity<?> deletecountry(@PathVariable("playerid") String pid)
	{
				pserve.deletePlayer(pid);
			return new ResponseEntity<String>("deleted successfully",HttpStatus.OK);
	
	}

}
