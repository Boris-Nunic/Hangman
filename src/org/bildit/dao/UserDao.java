package org.bildit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bildit.beans.User;

public class UserDao implements UserDaoInterface {

	private static Connection conn = ConnectionManager.getInstance().getConnection();

	@Override
	public boolean addUser(User user) {
		boolean added = false;
		String query = "INSERT INTO hangman_user(userName, password, isAdmin) " + "VALUES (?, ?, ?)";

		try (PreparedStatement ps = conn.prepareStatement(query);) {

			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setBoolean(3, user.isAdmin()); 
			// execute the query
			int affected = ps.executeUpdate();
			if (affected == 1) {
				added = true;
			}

		} catch (SQLException e) {
			System.err.println(e);
		}
		return added;
	}

	@Override
	public boolean editUser(User user) {

		boolean edited = false;
		String query = " UPDATE hangman_user SET userName = ?, password = ? WHERE userName = ?";

		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());

			int affected = ps.executeUpdate();
			if (affected == 1) {
				edited = true;
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return edited;
	}

	@Override
	public boolean deleteUser(String username) {

		boolean deleted = false;
		String query = "DELETE FROM hangman_user WHERE userName = ?";

		try (PreparedStatement ps = conn.prepareStatement(query);) {

			ps.setString(1, username);

			int affected = ps.executeUpdate();
			if (affected == 1) {
				deleted = true;
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return deleted;
	}

	@Override
	public void resetLeaderboard() {
		String query = "SELECT * FROM hangman_user";
		ResultSet rs = null;

		Map<String, Integer> lb = new HashMap<>();

		try (Statement statement = conn.createStatement();) {
			rs = statement.executeQuery(query);

			while (rs.next()) { // while table contains some data
				// set all scores to 0
				lb.put(rs.getString("userName"), 0);
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

	@Override
	public boolean addScore(String username, int score) {

		boolean added = false;
		String query = "INSERT INTO scores(score, username) VALUES(?, ?)";

		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, score);
			ps.setString(2, username);

			int affected = ps.executeUpdate();
			if (affected == 1) {
				added = true;
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return added;
	}
	
	@Override
	public boolean addTotalScore(String username){

		boolean added = false;
		String query = "UPDATE hangman_user SET totalScore = ? WHERE userName = ?";
		int totalScore = getTotalScore(username);

		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, totalScore);
			ps.setString(2, username);

			int affected = ps.executeUpdate();
			if (affected == 1) {
				added = true;
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return added;
	}


	@Override
	public ArrayList<String> getUsernames() {

		ArrayList<String> list = new ArrayList<>();
		String query = "SELECT * FROM hangman_user";
		ResultSet rs = null;
		try (Statement st = conn.createStatement()) {
			rs = st.executeQuery(query);

			while (rs.next()) {
				list.add(rs.getString("userName"));
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return list;
	}

	@Override
	public List<User> getUsersSortedByScore() {

		List<User> list = new ArrayList<>();
		String query = "SELECT * FROM hangman_user ORDER BY totalScore DESC";
		ResultSet rs = null;

		try (Statement st = conn.createStatement()) {
			rs = st.executeQuery(query);

			while (rs.next()) {
				list.add(new User(rs.getString("userName"), rs.getInt("totalScore")));
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return list;
	}

	@Override
	public User getUser(String username) {

		User user = null;
		String query = "SELECT * FROM hangman_user WHERE userName = ?";
		ResultSet rs = null;

		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, username);

			rs = ps.executeQuery();

			if (rs.next()) {
				user = new User(rs.getString("userName"), rs.getString("password"), rs.getInt("totalScore"));
				user.setAdminStatus(rs.getBoolean("isAdmin"));
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return user;

	}

	@Override
	public int getTotalScore(String username) {
		String query = "SELECT sum(score) FROM scores WHERE username = ?";
		int topScore = 0;
		ResultSet rs = null;

		try (PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				topScore = rs.getInt("sum(score)");
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return topScore;
	}
	
	

	public void printUser(User user) {
		if (user != null) {
			System.out.println("username: " + user.getUserName() + ", score: " + user.getScore());
		} else {
			System.out.println("No user to print.");
		}
	}

	@Override
	public ArrayList<Integer> getScores(String username) {
		String query = "SELECT * FROM scores WHERE username = ?";
		ArrayList<Integer> scores = new ArrayList<>();
		ResultSet rs = null;
		
		try(PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setString(1, username);
			rs = ps.executeQuery();
			while(rs.next()) {
				scores.add(rs.getInt("score"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return scores;
	}
	
}