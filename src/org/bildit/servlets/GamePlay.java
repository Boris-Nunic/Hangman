package org.bildit.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bildit.beans.Game;
import org.bildit.beans.User;
import org.bildit.services.GameService;

@WebServlet("/game")
public class GamePlay extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		GameService gs = new GameService();

		Game game = (Game) session.getAttribute("game");
		User user = (User) session.getAttribute("user");
		String message;

		String guess = request.getParameter("guess");
		gs.check(guess, game);

		if (gs.isGameWon(user.getUserName(), game)) {
			session.removeAttribute("game");
			message = "You Win, the correct word was:\n " + game.getWord();
			request.setAttribute("message", message);

			request.getRequestDispatcher("/gameMessage.jsp").forward(request, response);

		}

		 if(gs.isGameLost(game)) {

			message = "You Lose\nThe Word was: \"" + game.getWord() + "\"";
			session.removeAttribute("game");
			request.setAttribute("message", message);

			request.getRequestDispatcher("/gameMessage.jsp").forward(request, response);

		}

		if (game == null)
			response.sendRedirect("/setupGame");
		else {
			request.getRequestDispatcher("/game.jsp").forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		Game game = (Game) session.getAttribute("game");

		if (game == null)
			response.sendRedirect("/setupGame");
		else {
			request.getRequestDispatcher("/game.jsp").forward(request, response);
		}

	}

}
