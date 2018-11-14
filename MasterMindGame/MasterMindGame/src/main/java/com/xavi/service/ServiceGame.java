package com.xavi.service;

import org.apache.log4j.Logger;

import com.xavi.entity.Moves;
import com.xavi.entity.Player;

public class ServiceGame {

	private static final Logger log = Logger.getLogger(ServiceGame.class);
	
	public Player start() {
		Player player = new Player();
		log.debug("Start Game Service");
		return player;
	}
	
	public Moves checkCode(String secretCode, String[] userCode) {
		Moves move = new Moves();
		
		return move;
	}
}
