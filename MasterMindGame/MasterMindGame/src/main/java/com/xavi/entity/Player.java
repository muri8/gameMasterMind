package com.xavi.entity;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private boolean win;

	private String secretCode;

	private List<Moves> listMoves;

	public Player() {
		listMoves = new ArrayList<Moves>();
	}

	public Player(boolean win, String secretCode, List<Moves> listMoves) {
		super();
		this.win = win;
		this.secretCode = secretCode;
		this.listMoves = listMoves;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public String getSecretCode() {
		return secretCode;
	}

	public void setSecretCode(String secretCode) {
		this.secretCode = secretCode;
	}

	public List<Moves> getListMoves() {
		return listMoves;
	}

	public void setListMoves(List<Moves> listMoves) {
		this.listMoves = listMoves;
	}

	@Override
	public String toString() {
		return "Player [win=" + win + ", secretCode=" + secretCode + ", listMoves=" + listMoves + "]";
	}

}
