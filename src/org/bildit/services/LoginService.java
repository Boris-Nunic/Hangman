package org.bildit.services;

import org.bildit.beans.User;
import org.bildit.dao.UserDao;

public class LoginService {

	private static UserDao dao = new UserDao();
	
	public static String validateLogin(String username, String password) {
		User user = dao.getUser(username);
		String encrypt = EncryptionService.hashPassword(password);
		if (encrypt == null) {
			return "An error has occured. Please try again";
		}
		else if (user == null) {
			return "Username is wrong. Please try again";
		}
		else if (!encrypt.equals(user.getPassword())) {
			return "Incorrect password. Please try again";
		}
		else {
			user.login();
			return null;
		}
	}
}
