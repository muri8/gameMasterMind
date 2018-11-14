package com.xavi.service;

import com.xavi.entity.Moves;
import com.xavi.entity.Player;

public class ServiceGame {

	public Player start() {
		Player player = new Player();
		
		return player;
	}
	
	public Moves checkCode(String secretCode, String[] userCode) {
		Moves move = new Moves();
		
		return move;
	}
}
