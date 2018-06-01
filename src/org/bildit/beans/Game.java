package org.bildit.beans;

import java.util.ArrayList;

public class Game {
	
	private String word = "";
	private String concealedWord = "";
	private int numOfErrors = 0;
	private int score = 100;
	private ArrayList<Character> attempts = new ArrayList<>();
	
	public Game() {
		
	}
	
	public Game(String word, String concealedWord, int numOfErrors, int score) {
		this.word = word;
		this.concealedWord = concealedWord;
		this.numOfErrors = numOfErrors;
		this.score = score;
	}
		
	public ArrayList<Character> getAttempts() {
		return attempts;
	}

	public void setAttempts(ArrayList<Character> attempts) {
		this.attempts = attempts;
	}
	
	public String getConcealedWord() {
		return concealedWord;
	}

	public void setConcealedWord(String concealedWord) {
		this.concealedWord = concealedWord;
	}

	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getNumOfErrors() {
		return numOfErrors;
	}
	public void setNumOfErrors(int numOfErrors) {
		this.numOfErrors = numOfErrors;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
