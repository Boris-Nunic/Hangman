package org.bildit.dao;
 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import org.bildit.beans.User;

public interface UserDaoInterface {

	public boolean addUser(String username, String password) throws SQLException;
	
	public boolean editUser(User user) throws SQLException;
	
	public boolean validateUser(String username, String password) throws SQLException;
	
	public boolean deleteUser(String username) throws SQLException;
	
	public Map<String, Integer> getLeaderboard() throws SQLException;
	
	public void resetLeaderboard() throws SQLException;
	
	public boolean addScore(String username, int score) throws SQLException;
	
	public ArrayList<String> getUsernames() throws SQLException;
	
	public ArrayList<Integer> getScores() throws SQLException;
	
	
	public boolean isUniqueUsername(String username) throws SQLException;
	
	public User getUser(String username) throws SQLException;
	
}
