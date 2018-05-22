package org.bildit.dao;

 
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.Map;
import org.bildit.beans.User;


public interface UserDaoInterface {

	public void addUser(String username, String password) throws SQLException;
	
	public void editUser(User user) throws SQLException;
	
	public boolean validateUser(String username, String password) throws SQLException;
	
	public void deleteUser(User user) throws SQLException;
	
	public Map<String, Integer> getLeaderboard() throws SQLException;
	
	public void resetLeaderboard() throws SQLException;
	
	public void addScore(String username, int score) throws SQLException;
	
	
	
}
