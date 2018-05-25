package org.bildit.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.bildit.beans.User;
import org.bildit.dao.UserDaoImpl;

public class Test {

	static UserDaoImpl userImpl = new UserDaoImpl();
	
	public static void main(String[] args) throws SQLException {

		ConnectionManager.getInstance().close();
	}
}
