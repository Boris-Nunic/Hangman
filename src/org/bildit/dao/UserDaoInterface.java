package org.bildit.dao;
 
import java.util.ArrayList;
import org.bildit.beans.User;

public interface UserDaoInterface {

	public boolean addUser(User user);
	
	public boolean editUser(User user);
	
	public boolean deleteUser(String username);
	
	public void resetLeaderboard();
	
	public boolean addScore(String username, int score);
	
	public ArrayList<User> getUsersSortedByScore();
		
	public ArrayList<String> getUsernames(); 
	
	public User getUser(String username);
	
}
