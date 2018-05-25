package org.bildit.services;

import java.util.ArrayList;

import org.bildit.dao.WordsDao;

public class AddWordService {
	
	public static String AddNewWord(String word) {
		WordsDao dao = new WordsDao();
		ArrayList<String> words = dao.getWords();
		if (words.contains(word)) {
			return"\"" + word + "\" is already in database";
		}
		dao.addWord(word);
		return "\"" + word + "\" is successfully added in database";
	}
}
