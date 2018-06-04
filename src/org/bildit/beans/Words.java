package org.bildit.beans;

public class Words {
	private int wordID;
	private String word;

	public Words() {

	}

	public Words(int wordID, String word) {
		super();
		this.wordID = wordID;
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getWordID() {
		return wordID;
	}

}
