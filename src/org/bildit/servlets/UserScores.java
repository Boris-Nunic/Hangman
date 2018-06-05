package org.bildit.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bildit.beans.User;
import org.bildit.services.UserScoresService;

/**
 * Servlet implementation class UserScores
 */
@WebServlet("/userScores")
public class UserScores extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user =(User)session.getAttribute("user");
		ArrayList<Integer> scores = UserScoresService.getUserScores(user.getUserName());
		request.setAttribute("scores", scores);
		request.getRequestDispatcher("personalScores.jsp").forward(request, response);
		
	}

}
