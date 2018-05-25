package org.bildit.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bildit.dao.WordsDao;

/**
 * Servlet implementation class DeleteWord
 */
@WebServlet("/deleteWord")
public class DeleteWord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get parameter from client page
		String word = request.getParameter("word");

		// Delete word from db using dao
		WordsDao dao = new WordsDao();
		try {
			dao.deleteWord(word);;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Write message back to client page
		String message = null;
		boolean placeholder = true;

		if (placeholder) {
			message = "A new word was deleted successfully";
		} else {
			message = "An error occured please try again";
		}

		request.setAttribute("message", message);
		request.getRequestDispatcher("html/placeholder.jsp");

	}

}