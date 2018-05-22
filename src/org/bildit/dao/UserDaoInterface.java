package org.bildit.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
;

public interface UserDaoInterface {

	public void addUser(String username, String password) throws SQLException;
	
	public void editUser(String username) throws SQLException;
	
	public boolean validateUser(String username, String password) throws SQLException;
	
	public void deleteUser(String username) throws SQLException;
	
	public Map<String, Integer> getLeaderboard() throws SQLException;
	
	public void resetLeaderboard() throws SQLException;
	
	public void addScore(String username, int score) throws SQLException;
	
	public ArrayList<String> getUsernames() throws SQLException; 
	
	
}
