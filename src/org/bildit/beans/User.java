package org.bildit.beans;

public class User {
	private int score;
	private String userName;
	private String password;
	private boolean isOnline;

	public User() {

	}

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public User(String userName, String password, int score) {
		this.userName = userName;
		this.password = password;
		this.score = score;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isOnline() {
		return isOnline;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void login() {
		this.isOnline = true;
	}

	public void logout() {
		this.isOnline = false;
	}

}
