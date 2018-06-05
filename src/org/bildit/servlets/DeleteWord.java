package org.bildit.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bildit.services.AdminService;

/**
 * Servlet implementation class DeleteWord
 */
@WebServlet("/deleteWord")
public class DeleteWord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String word = request.getParameter("word");
		
		String message = AdminService.deleteWord(word);
		
		request.setAttribute("message", message);
		
		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}

}
