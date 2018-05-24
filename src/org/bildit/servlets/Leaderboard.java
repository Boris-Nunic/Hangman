package org.bildit.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bildit.beans.User;
import org.bildit.dao.UserDao;

/**
 * Servlet implementation class Leaderboard
 */
@WebServlet("/leaderboard")
public class Leaderboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get leaderboard from dao
		UserDao dao = new UserDao();
		ArrayList<User> leaderboard = dao.getUsers();

		// Write the leaderboard back to client browser
		request.setAttribute("leaderboard", leaderboard);
		request.getRequestDispatcher("html/placeholder.jsp");
	}

}
