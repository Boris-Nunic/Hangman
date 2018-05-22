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
 * Servlet implementation class DeleteUser
 */
@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get parameter from client page
		String username = request.getParameter("username");
		
		// Delete user from database using dao object
		UserDao dao = new UserDao();
		try {
			dao.deleteUser(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Write message back to client page
		String message = null;
		boolean placeholder = true;
		
		if (placeholder) {
			message = "User successfully deleted";
		}
		else {
			message = "An error occured please try again";
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("html/placeholder.jsp");
	}

}
