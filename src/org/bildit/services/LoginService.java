package org.bildit.services;

import org.bildit.beans.User;
import org.bildit.dao.UserDao;

public class LoginService {

	private static UserDao dao = new UserDao();

	public static User validateLogin(String username, String password) {
		User user = new User();
		String message = null;
		String encrypt = EncryptionService.hashPassword(password);
		if (encrypt == null) {
			message = "An error has occured. Please try again";
			user.setMessage(message);
			return user;
		}
		
		if (dao.getUser(username) == null) {
			message = "Username is wrong. Please try again";
			user.setMessage(message);
			return user;
		}
		
		user = dao.getUser(username);
		
		if (!password.equals(user.getPassword())) {
			message = "Incorrect password. Please try again";
			user.setMessage(message);;
			return user;
		}

		user.login();
		message = "Login was successful";
		user.setMessage(message);
		return user;
	}
}
