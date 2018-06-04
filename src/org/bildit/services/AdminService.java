package org.bildit.services;

import org.bildit.dao.UserDao;
import org.bildit.dao.WordsDao;

public class AdminService {

	private static UserDao userdao = new UserDao();
	private static WordsDao wordsDao = new WordsDao();

	public static String deleteUser(String username) {

		if (userdao.deleteUser(username)) {
			return "Action was successful";
		}
		return "Action failed";
	}

	public static String addWord(String word) {
		if (wordsDao.getWords().contains(word)) {
			return "Entered word is already in the database";
		}
		if (wordsDao.addWord(word)) {
			return "New word was successfully added in the database";
		}
		return "Action falied";
	}
	
	public static String deleteWord(String word) {
		if (!wordsDao.getWords().contains(word)) {
			return "Entered word is not in the database";
		}
		if (wordsDao.deleteWord(word)) {
			return word + " was successfully deleted from the database";
		}
		return "Action failed";
	}

}
