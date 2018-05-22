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
	public void addUser(String username, String password) throws SQLException {

		String query = "INSERT INTO hangman_user(userID, userName, password, score, isAdmin) "
				+ "VALUES (default, ?, ?, ?, ?)"; // default value -
													// it's
													// autoincrement in
													// db

		try (PreparedStatement ps = conn.prepareStatement(query);) {

			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, 0);
			ps.setInt(4, 0); // tiny int in db, 0 for regular user

			ps.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e);
		}

	}

	@Override
	public void editUser(User user) throws SQLException {
		String query = " UPDATE hangman_user SET userName = ?, score = ?, isAdmin = ? WHERE userName = ?";

		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, user.getUserName());
			ps.setInt(2, user.getScore());
			ps.setInt(3, user.getIsAdmin());

			ps.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e);
		}
	}

	@Override
	public ArrayList<String> getUsernames() throws SQLException {

		String query = "SELECT * FROM hangman_user";
		ResultSet rs = null;
		ArrayList<String> userNames = new ArrayList<>();

		try (Statement statement = conn.createStatement();) {

			rs = statement.executeQuery(query);

			while (rs.next()) { // while table contains some data
				userNames.add(rs.getString("userName"));
			}

		} catch (SQLException e) {
			System.err.println(e);
		}
		return userNames;
	}

	@Override
	public void deleteUser(User user) throws SQLException {
		if (user != null) {
			// create an SELECT SQL query
			String query = "DELETE FROM hangman_user WHERE userID = ?";

			try (PreparedStatement ps = conn.prepareStatement(query);) {

				ps.setInt(1, user.getUserID());

				// execute the query
				ps.executeUpdate();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}

	@Override
	public Map<Integer, String> getLeaderboard() throws SQLException {
		String query = "SELECT * FROM hangman_user";
		ResultSet rs = null;

		Map<Integer, String> lb = new HashMap<>();

		try (Statement statement = conn.createStatement();) {
			rs = statement.executeQuery(query);

			while (rs.next()) { // while table contains some data
				lb.put(rs.getInt("score"), rs.getString("userName"));
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return lb;
	}

	@Override
	public void resetLeaderboard() throws SQLException {
		Map<Integer, String> lb = getLeaderboard();

		if (!lb.isEmpty()) {
			lb.clear();
			System.out.println("Leaderbord reseted.");
		}else
			System.out.println("");
		
	}

}
