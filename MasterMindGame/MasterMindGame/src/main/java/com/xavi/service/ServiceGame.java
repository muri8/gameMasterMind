package com.xavi.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.xavi.entity.Moves;
import com.xavi.entity.Player;

/**
 * This class execute the MasterMind and has everything you need to play.It
 * gives us methods to validate the code entered by the user. It allows us to
 * request a new code from the user, and compare it with the secret code.
 * 
 * @author xavi
 *
 */
public class ServiceGame {

	private static final Logger log = Logger.getLogger(ServiceGame.class);

	public static final String MATCH = "^[BGOPRY]{4}$";

	private static Pattern pattern = Pattern.compile(MATCH);

	private Matcher matcher;

	public static final String[] colors = { "B", "G", "O", "P", "R", "Y" };

	/**
	 * Start app. Initialize the necessary parameters, call to generate the secret
	 * code and start the game.
	 */
	public Player start() {
		Player player = new Player();
		log.debug("Start Game Service");
		return player;
	}

	/**
	 * Compare the code entered by the user with the secret code. It gives us the
	 * total of hits in position and color.
	 * 
	 * @param secertCode, String auto generated.
	 * @param userCode, Array String code entered by the user.
	 * @return Moves, returns the number of position and color hits.
	 */
	public Moves checkCode(String secretCode, String[] userCode) {
		Moves move = new Moves();

		return move;
	}

	/**
	 * Validate the code entered by the user.
	 * 
	 * @param code
	 * @return bolean. It is valid or not valid.
	 */
	public boolean validate(String code) {
		code = code.toUpperCase();
		return pattern.matcher(code).matches();
	}
}
