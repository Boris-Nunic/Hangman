package org.bildit.dao;

import java.sql.SQLException;

import org.bildit.beans.User;
import org.bildit.dao.UserDaoImpl;


public class TestConnection {

	static User user = new User();
	static UserDaoImpl userImpl = new UserDaoImpl();

	public static void main(String[] args) throws SQLException {

		ConnectionManager.getInstance().close();
	}

}
