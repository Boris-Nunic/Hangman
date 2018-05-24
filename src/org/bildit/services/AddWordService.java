package org.bildit.services;

import java.util.ArrayList;

import org.bildit.dao.UserDao;
import org.bildit.dao.WordsDao;
import org.bildit.dao.WordsDaoInteface;

public class AddWordService {

	private static WordsDao dao = new WordsDao();
	
	public static String AddNewWord(String word) {
		ArrayList<String> words = dao.getWords();
		
	}
}
