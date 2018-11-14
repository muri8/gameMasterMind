package com.xavi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
		String secretCode = generateSecretCode();
		log.debug("Secret Code: " + secretCode);
		Player player = playUser(secretCode);
		return player;
	}

	/**
	 * It requests a code from the user and controls the number of movements.
	 * 
	 * @param secretCode auto generate
	 * @return Player. The results of game and history
	 */
	public Player playUser(String secretCode) {
		Player player = new Player();
		int numMove = 0;
		player.setSecretCode(secretCode);
		while (numMove < 10) {
			numMove++;
			String code = moveUser();
			String[] userCode = code.split("");
			Moves move = checkCode(secretCode, userCode);
			move.setCode(code);
			move.setNumMove(numMove);
			player.getListMoves().add(move);
			printHistory(player);
			if (move.getRed() == 4) {
				System.out.println("-------------------------------- You Win!!! --------------------------------");
				player.setWin(true);
				break;
			} else if (numMove == 10) {
				System.out.println("-------------------------------- You Lose!!! --------------------------------");
			}
		}

		return player;
	}

	/**
	 * It requests a code from the user , converts it to uppercase and validates it.
	 * 
	 * @return Player. Add generated code in the object.
	 */
	public String moveUser() {
		Scanner scan = new Scanner(System.in);
		boolean exit = false;
		String result = "";

		while (!exit) {
			System.out.print("Enter four letters (B, G, O, P, R, Y): ");
			result = scan.next();
			if (validate(result)) {
				result = result.toUpperCase();
				exit = true;
			} else {
				System.out.println("The letters " + result + " are not valid");
			}
		}

		return result;
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
		List<String> listSecert = new ArrayList<String>();
		List<String> listUser = new ArrayList<String>();

		int red = 0;
		int white = 0;
		String[] s = secretCode.split("");
		for (int i = 0; i < s.length; i++) {
			String secret = s[i];
			String user = userCode[i];
			if (secret.equals(user)) {
				red++;
			} else {
				listSecert.add(s[i]);
				listUser.add(user);
			}
		}
		if (listSecert.size() > 0) {
			boolean exit = false;
			int i = 0;
			while (!exit) {
				String secret = listSecert.get(i);
				if (listUser.contains(secret)) {
					int posUser = listUser.indexOf(secret);
					listUser.remove(posUser);
					listSecert.remove(i);
					white++;
					if (listSecert.size() == 0) {
						exit = true;
					}
				} else {
					listSecert.remove(i);
					if (listSecert.size() == 0) {
						exit = true;
					}
				}
			}

		}
		Moves move = new Moves();
		move.setRed(red);
		move.setWhite(white);
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

	/**
	 * Generate the secret code random
	 * 
	 * @return result the secret code generated
	 */
	public String generateSecretCode() {
		String result = "";
		for (int i = 0; i < 4; i++) {
			result = result + colors[(int) (Math.random() * 5 + 1)];
		}
		return result;
	}

	/**
	 * print the board, the history of the plays and how many moves we have made.
	 */
	private void printHistory(Player player) {
		System.out.println("-------- BOARD --------");
		for (Moves move : player.getListMoves()) {
			System.out.println(move.getNumMove() + " - Code: [" + move.getCode() + "]" + " Red: " + move.getRed()
					+ " White: " + move.getWhite());
		}
		System.out.println("-------- BOARD --------");
	}
}
