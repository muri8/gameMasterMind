package com.xavi.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xavi.entity.Player;
import com.xavi.service.ServiceGame;

@RestController
@RequestMapping("/")
public class Controller {

	private static final Logger log = Logger.getLogger(Controller.class);
	
	@Autowired
	private ServiceGame serviceGame;
	
	/**
     * Accept the request and launch the game.
     * @return Player. Information of the plays and results in JSON format
     */
	@RequestMapping(value="/play", method = RequestMethod.GET,  produces = "application/json")
	public Player playMasterMind() {
		log.debug("Start MasterMind ");
		Player player = serviceGame.start();
		return player;
	}
	
}
