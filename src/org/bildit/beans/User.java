package org.bildit.beans;

public class User {
	private int score;
	private String userName;
	private String password;
	private boolean isOnline;
	private boolean isAdmin;
	private String message;

	public User() {

	}

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public User(String userName, String password, int score) {
		this.userName = userName;
		this.score = score;
		this.password = password;
	}
	
	public User(String userName, int score) {
		this.userName = userName;
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

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdminStatus(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
