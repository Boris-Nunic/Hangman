package org.bildit.services;

import org.bildit.beans.User;
import org.bildit.dao.UserDao;

public class RegistrationService {

	private static UserDao dao = new UserDao();

	// Try to register a user and return adequate message
	public static String register(String username, String password, String pswRepeat) {

		if (invalidUsernameMessage(username) != null) {
			return invalidUsernameMessage(username);
		}
		if (dao.getUsernames().contains(username)) {
			return "Entered username is already taken";
		}

		if (invalidPasswordMessage(password) != null) {
			return invalidPasswordMessage(password);
		}

		if (!password.equals(pswRepeat)) {
			return "Password and repeated password do not match, please try again";
		}

		if (EncryptionService.hashPassword(password) == null) {
			return "An error has occured please try again";
		}

		return successfulRegistration(username, password);
	}

	// Encrypts password, adds user into database and returns message
	private static String successfulRegistration(String username, String password) {
		String encrypt = EncryptionService.hashPassword(password);
		User user = new User(username, password);
		if (dao.addUser(user) == true) {
			return "Your registration was successful";
		}
		return "Registration failed";

	}

	// Returns message if user name is not valid
	private static String invalidUsernameMessage(String username) {
		if (!validUsername(username)) {
			String message = "Entered username is invalid.\nUsername can only contain"
					+ " lower and upper case letters, digits, undersores and dashes\nMust have at least 5 chars";
			return message;
		}
		return null;
	}

	// Returns message if password is not valid, else returns null
	private static String invalidPasswordMessage(String password) {
		if (!validPassword(password)) {
			String message = "Entered password is invalid.\nA digit must occur at least once\n"
					+ "A lower case character must occur at least once\n"
					+ "A lower case character must occur at least once\n"
					+ "An upper case character must occur at least once\n"
					+ "A special character must occur at least once\n" + "No whitespace is allowed in entire password\n"
					+ "Password must contain at least 8 characters";
			return message;
		}
		return null;

	}

	/*
	 * Return true if entered password is valid A digit must occur at least once A
	 * lower case character must occur at least once An upper case character must
	 * occur at least once A special character must occur at least once No
	 * whitespace allowed in entire password Password must contain at least 8
	 * characters
	 */
	private static boolean validPassword(String password) {
		final String PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		return password.matches(PATTERN);
	}

	/*
	 * Return true if username is valid Can only contain lower and upper case
	 * letters, digits, undersores and dashes Must have at least 5 chars
	 */
	private static boolean validUsername(String username) {
		final String PATTERN = "[a-zA-Z0-9_-]{5,}";
		return username.matches(PATTERN);
	}
}
