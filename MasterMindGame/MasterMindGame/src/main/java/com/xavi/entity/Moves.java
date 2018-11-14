package com.xavi.entity;

public class Moves {

	private int white;

	private int red;

	private int numMove;

	private String code;

	public Moves() {

	}

	public Moves(int white, int red, int numMove, String code) {
		super();
		this.white = white;
		this.red = red;
		this.numMove = numMove;
		this.code = code;
	}

	public int getWhite() {
		return white;
	}

	public void setWhite(int white) {
		this.white = white;
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getNumMove() {
		return numMove;
	}

	public void setNumMove(int numMove) {
		this.numMove = numMove;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Moves [white=" + white + ", red=" + red + ", numMove=" + numMove + ", code=" + code + "]";
	}

}
