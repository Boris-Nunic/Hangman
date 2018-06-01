package org.bildit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class WordsDao implements WordsDaoInteface {

	Connection conn = ConnectionManager.getInstance().getConnection();

	@Override
	public void addWord(String word) {
		String query = "INSERT INTO hangman_words(wordID, word) " + "VALUES (default, ?)";
		// default value - it's autoincrement in db

		try (PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setString(1, word);
			ps.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e);
		}
	}

	@Override
	public void deleteWord(String word) {
		String query = "DELETE FROM hangman_words WHERE word= ?";
		try (PreparedStatement ps = conn.prepareStatement(query);) {

			ps.setString(1, word);
			ps.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e);
		}
	}

	@Override
	public ArrayList<String> getWords() {
		String query = "SELECT * FROM hangman_words";
		ResultSet rs = null;
		ArrayList<String> words = new ArrayList<>();

		try (Statement statment = conn.createStatement()) {
			rs = statment.executeQuery(query);
			while (rs.next()) {
				words.add(rs.getString("Word"));
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return words;
	}
	
	@Override
	public String getWord() {
		Random rand = new Random();
		ArrayList<String> allWords = getWords();
		int randWord = rand.nextInt(allWords.size());
		return allWords.get(randWord);
	}

}
