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
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//Get parameters from login.jsp
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// Use dao to save date into db 
		UserDao dao = new UserDao();
		try {
			dao.addUser(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Write message back to client page
		String message = null;
		boolean placeholeder = true;
		
		if(placeholeder) {
			message = "Registration successfull";
		}
		else {
			message = "Registation failed";
		}
		
		request.setAttribute("message", message);
		request.getRequestDispatcher("/html/placeholder.jsp");
		
		
	}

}
