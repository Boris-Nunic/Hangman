package org.bildit.services;

import java.util.ArrayList;

import org.bildit.dao.UserDao;

public class UserScoresService {

	public static ArrayList<Integer> getUserScores(String username) {
		UserDao dao = new UserDao();
		ArrayList<Integer> scores = dao.getScores(username);
		return scores;
	}
}
