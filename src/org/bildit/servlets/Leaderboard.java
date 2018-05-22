package org.bildit.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bildit.dao.UserDao;

/**
 * Servlet implementation class Leaderboard
 */
@WebServlet("/leaderboard")
public class Leaderboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//Get leaderboard from dao 
		UserDao dao = new UserDao();
		TreeMap<String, Integer> leaderboard = new TreeMap<>();
		try {
			 leaderboard = (TreeMap<String, Integer>)dao.getLeaderboard();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Write the leaderboard back to client browser
		request.setAttribute("leaderboard", leaderboard);
		request.getRequestDispatcher("html/placeholder.jsp");
	}
	
	

}
