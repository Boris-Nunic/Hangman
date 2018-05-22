package org.bildit.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bildit.dao.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get parameters from client page
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// Validate user
		UserDao dao = new UserDao();
		boolean isValidUser = false;
		try {
			isValidUser = dao.validateUser(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Check if user is valid and setup an error message
		if (isValidUser) {

			// Set HTTP session
			HttpSession session = request.getSession();

			// Set username as attribute
			session.setAttribute("username", username);

			// Forward to home page
			request.getRequestDispatcher("html/placeholder.jsp").forward(request, response);
		}
		
		else {
			String message = "Username or password is wrong. Please try again";
			request.setAttribute("message", message);
			request.getRequestDispatcher("html/placeholder.jsp").forward(request, response);
		}

	}

}
