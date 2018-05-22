package org.bildit.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bildit.dao.WordsDao;

/**
 * Servlet implementation class GetWord
 */
@WebServlet("/getWord")
public class GetWord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get all words from db using dao
		WordsDao dao = new WordsDao();
		ArrayList<String> words = new ArrayList<>();
		try {
			words = dao.getWords();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Get one random word from list words
		Random random = new Random(System.currentTimeMillis());
		int randomIndex = random.nextInt(words.size());
		String word = words.get(randomIndex);
		
		// Return back selected word to client page
		request.setAttribute("word", word);
		request.getRequestDispatcher("html/placeholder.jsp");

	}
	

}
