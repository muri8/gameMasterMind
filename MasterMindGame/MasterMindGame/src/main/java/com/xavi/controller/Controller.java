package com.xavi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xavi.entity.Player;
import com.xavi.service.ServiceGame;

@RestController
@RequestMapping("/")
public class Controller {

	@Autowired
	private ServiceGame ServiceGame;
	
	public Player playMasterMind() {
		
		Player player = new Player();
		
		return player;
	}
	
}
