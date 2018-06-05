package org.bildit.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bildit.beans.User;
import org.bildit.services.LoginService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
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

		// Check if user is valid and setup an error message
		User user = LoginService.validateLogin(username, password);
		if (user.isOnline()) {

			// Set HTTP session
			HttpSession session = request.getSession();

			// Set username as attribute
			session.setAttribute("user", user);

			if (user.isAdmin()) {
				// Forward to admin page
				request.getRequestDispatcher("admin.jsp").forward(request, response);
			}

			else {
				// Forward to user page
				request.getRequestDispatcher("userprofile.jsp").forward(request, response);
			}
		}

		else {
			// Return to home page
			request.setAttribute("user", user);
			request.getRequestDispatcher("loginMessage.jsp").forward(request, response);
		}
		
	}
}
