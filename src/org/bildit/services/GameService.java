package org.bildit.services;

import org.bildit.beans.Game;
import org.bildit.beans.User;
import org.bildit.dao.UserDao;
import org.bildit.dao.WordsDao;

public class GameService {

	WordsDao wd = new WordsDao();

	public Game initGame() {
		Game game = new Game();
		game.setWord(wd.getWord());
		game.setScore(100);
		game.setConcealedWord(concealWord(game.getWord()));

		return game;
	}

	private String concealWord(String word) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < word.length(); i++) {
			sb.append("*");
		}
		return sb.toString();
	}

	public String setHangermanPicture(int num) {
		switch (num) {
		case 0:
			return "img/Vjesalo1.png";
		case 1:
			return "img/Vjesalo2.png";
		case 2:
			return "img/Vjesalo3.png";
		case 3:
			return "img/Vjesalo4.png";
		case 4:
			return "img/Vjesalo5.png";
		case 5:
			return "img/Vjesalo6.png";
		case 6:
			return "img/Vjesalo7.png";
		default:
			return "";
		}
	}

	public void check(String guess, Game game) {
		if (guess.length() == 1)
			checkLetterGuess(guess.charAt(0), game);
		else
			checkWordGuess(guess, game);
	}

	public void checkLetterGuess(char c, Game game) {

		String word = game.getWord();
		String concealed = game.getConcealedWord();
		StringBuffer sb = new StringBuffer();
		boolean letterGuessed = false;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == c) {
				letterGuessed = true;
				sb.append(c);
			} else if (concealed.charAt(i) != '*')
				sb.append(word.charAt(i));
			else
				sb.append("*");
		}

		game.setConcealedWord(sb.toString());

		if (!letterGuessed) {
			game.setNumOfErrors(game.getNumOfErrors() + 1);
			game.setScore(game.getScore() - 20);

			boolean exists = false;
			for (Character ch : game.getAttempts()) {
				if (c == ch) {
					exists = true;
					break;
				}
			}

			if (!exists) {
				game.getAttempts().add(c);
			}

		}

	}

	public void checkWordGuess(String guess, Game game) {

		String word = game.getWord();
		if (guess.equals(word)) {
			game.setConcealedWord(game.getWord());
		} else {
			game.setNumOfErrors(game.getNumOfErrors() + 1);
			game.setScore(game.getScore() - 20);
		}

	}

	public boolean isGameWon(String username, Game game) {

		if (game.getConcealedWord().equals(game.getWord())) {

			UserDao ud = new UserDao();

			ud.addScore(username, game.getScore());
			ud.addTotalScore(username);

			game.setConcealedWord("");
			game.setNumOfErrors(0);
			game.setScore(100);

			return true;
		}
		return false;
	}

	public boolean isGameLost(Game game) {
		if (game.getNumOfErrors() == 6) {
			game.setConcealedWord("");
			game.setNumOfErrors(0);
			game.setScore(100);

			return true;
		}
		return false;
	}
}
