package org.bildit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bildit.beans.User;

public class UserDaoImpl implements UserDaoInterface {

	private static Connection conn = ConnectionManager.getInstance().getConnection();

	@Override
	public boolean addUser(String username, String password) throws SQLException {
		boolean added = false;
		String query = "INSERT INTO hangman_user( userName, password, score) " + "VALUES (?, ?, ?)";

		try (PreparedStatement ps = conn.prepareStatement(query);) {

			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, 0); // set score to 0 for every new user
			// ps.setInt(4, 0); // tiny int in db, 0 for regular user
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
	public boolean editUser(User user) throws SQLException {

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
	public boolean deleteUser(String username) throws SQLException {

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
	public Map<String, Integer> getLeaderboard() throws SQLException {
		String query = "SELECT * FROM hangman_user";
		ResultSet rs = null;

		Map<String, Integer> lb = new HashMap<>();

		try (Statement statement = conn.createStatement();) {
			rs = statement.executeQuery(query);

			while (rs.next()) { // while table contains some data
				lb.put(rs.getString("userName"), rs.getInt("score"));
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return lb;
	}

	@Override
	public void resetLeaderboard() throws SQLException {
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
	public boolean addScore(String username, int score) throws SQLException {

		boolean added = false;
		String query = "UPDATE hangman_user SET score = ? WHERE userName = ?";

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
	public boolean validateUser(String username, String password) throws SQLException {

		boolean valid = false;
		String query = "SELECT * FROM hangman_user";
		ResultSet rs = null;

		try (Statement statement = conn.createStatement();) {
			rs = statement.executeQuery(query);

			while (rs.next()) { // while table contains some data

				if (username.equalsIgnoreCase(rs.getString("userName"))
						&& password.equalsIgnoreCase(rs.getString("password"))) {

					valid = true;
				}
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return valid;
	}

	@Override
	public ArrayList<String> getUsernames() throws SQLException {

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
	public ArrayList<Integer> getScores() throws SQLException {

		ArrayList<Integer> list = new ArrayList<>();
		String query = "SELECT * FROM hangman_user";
		ResultSet rs = null;
		try (Statement st = conn.createStatement()) {
			rs = st.executeQuery(query);

			while (rs.next()) {
				list.add(rs.getInt("score"));
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return list;

	}

	@Override
	public boolean isUniqueUsername(String username) throws SQLException {

		boolean unique = false;
		ArrayList<String> list = getUsernames();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equalsIgnoreCase(username))
				;
			unique = true;
		}

		return unique;
	}

	@Override
	public User getUser(String username) throws SQLException {

		User user = null;
		String query = "SELECT FROM hangman WHERE useName = ?";
		ResultSet rs = null;

		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, "userName");

			rs = ps.executeQuery();
			user = new User(rs.getString("userName"), rs.getString("password"), rs.getInt("score"));

		} catch (SQLException e) {
			System.err.println(e);
		}
		return user;
	}

}
