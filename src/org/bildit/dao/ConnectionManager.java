package org.bildit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static ConnectionManager instance = null;

	private static final String USERNAME = "root";
	private static final String PASSWORD = "lozinka";
	private static final String CONN_STRING = "jdbc:mysql://localhost/hangman?useSSL=false&serverTimezone=UTC";

	private Connection connection = null;

	private ConnectionManager() {
	}

	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}

	private boolean openConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
}

	public Connection getConnection() {
		if (connection == null) {
			if (openConnection()) {
				System.out.println("Connection is opened.");
				return connection;
			} else {
				return null;
			}
		}
		return connection;
	}

	public void close() {
		System.out.println("Closing connection.");
		try {
			connection.close();
			connection = null;
		} catch (Exception e) {
		}
	}
}
