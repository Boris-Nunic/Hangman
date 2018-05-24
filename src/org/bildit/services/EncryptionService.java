package org.bildit.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionService {

	public static String hashPassword(String password) {
		
		try {
			MessageDigest message = MessageDigest.getInstance("SHA-256");
			message.update(password.getBytes());
			return new String(message.digest());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
