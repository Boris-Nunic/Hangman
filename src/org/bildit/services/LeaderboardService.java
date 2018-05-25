package org.bildit.services;

import java.util.ArrayList;
import java.util.List;

import org.bildit.beans.User;
import org.bildit.dao.UserDao;

public class LeaderboardService {

	public static ArrayList<User> getLeaderboard() {
		UserDao dao = new UserDao();
		ArrayList<User> leaderboard = dao.getUsersSortedByScore();
		final int TENTH_POSITION = 10;
		List<User> topTen = null;
		if (leaderboard.size() < TENTH_POSITION) {
			return leaderboard;
		} else {
			topTen = leaderboard.subList(0, TENTH_POSITION);
			return (ArrayList<User>) topTen;
		}

	}

}
