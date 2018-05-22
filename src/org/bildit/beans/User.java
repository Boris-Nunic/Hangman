package org.bildit.beans;

public class User {
	private int userID;
	private int score;
	private String userName;
	private String password;
	private boolean isOnline;
	private int isAdmin;
	
	
	public User () {
		
	}
	
	public User (String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
	
	
	public int getUserID() {
		return userID;
	}

	public int getScore() {
		return score;
	}

	public void setUserID(int id) {
		this.userID = id;
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

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

}
