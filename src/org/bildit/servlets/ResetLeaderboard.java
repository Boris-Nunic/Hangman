package org.bildit.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bildit.dao.UserDao;

/**
 * Servlet implementation class ResetLeaderboard
 */
@WebServlet("/resetLeaderboard")
public class ResetLeaderboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Set all scores in db to zero
		UserDao dao = new UserDao();
		try {
			dao.resetLeaderboard();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Write message back to client page
		String message = null;
		boolean placeholder = true;

		if (placeholder) {
			message = "Reset was successful";
		} else {
			message = "An error occured please try again";
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("html/placeholder.jsp");
	}

}
