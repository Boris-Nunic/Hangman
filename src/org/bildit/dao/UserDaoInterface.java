package org.bildit.dao;

import java.sql.SQLException; 
import java.util.ArrayList;
import java.util.Map;

import org.bildit.beans.User;


public interface UserDaoInterface {

	public void addUser(String username, String password) throws SQLException;
	
	public void editUser(User user) throws SQLException;
	
	public ArrayList<String> getUsernames() throws SQLException;
	
	public void deleteUser(User user) throws SQLException;
	
	public Map<Integer, String> getLeaderboard() throws SQLException;
	
	public void resetLeaderboard() throws SQLException;
	
	
	
}
