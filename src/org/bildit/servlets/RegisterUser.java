package org.bildit.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bildit.services.RegistrationService;

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
		
		//Write message back to client page
		String message = RegistrationService.register(username, password);
		
		request.setAttribute("message", message);
		request.getRequestDispatcher("/RegFailed.html");
		
		
	}

}
