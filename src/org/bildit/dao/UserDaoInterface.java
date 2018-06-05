package org.bildit.dao;
 
import java.util.ArrayList;
import java.util.List;

import org.bildit.beans.User;

public interface UserDaoInterface {

	public boolean addUser(User user);
	
	public boolean editUser(User user);
	
	public boolean deleteUser(String username);
	
	public void resetLeaderboard();
	
	public boolean addScore(String username, int score);
	
	public List<User> getUsersSortedByScore();
		
	public ArrayList<String> getUsernames(); 
	
	public User getUser(String username);
	
	public int getTotalScore(String username);

	public boolean addTotalScore(String username);
	
	public ArrayList<Integer> getScores(String username);
	
}
