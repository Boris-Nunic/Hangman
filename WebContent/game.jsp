<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="org.bildit.beans.Game"%>
<%@ page import="org.bildit.services.GameService"%>
<%
	Game game = (Game) session.getAttribute("game");
	GameService gs = new GameService();
%>

<!DOCTYPE html>
<html>
<head>
<title>Game</title>
<link rel="stylesheet" type="text/css" href="css/novicss.css">
<link rel="icon" type="image/png" href="img/favicon.ico" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/novi.css">
</head>

<body>
	<img src="<%=gs.setHangermanPicture(game.getNumOfErrors())%>"
		style="padding-left: 8%; padding-top: 10%; float: left;">

	<div class="game">
		<div class="form-group" style="text-align: center;">
			<!-- <form action="/game" method="POST"> -->
			<form action="game" method="post">
				<h3>
					<label for="word">Insert letter/word:</label>
				</h3>
				<input type="word" class="form-control" id="word" name="guess" autofocus>
                    <input type="submit" class="btn btn-info" value="Guess">
			</form>
		</div>
		<div class="form-group" style="text-align: center;">
			<h3>Solution:</h3>

			<h3><%=game.getConcealedWord()%></h3>
			<h3>FailedAttempts</h3>
			<h3><%=game.getAttempts()%></h3>
			<h3>Score:</h3>
			<h3><%=game.getScore()%></h3>

		</div>
		<br> <br>
		<div class="button">

			<form action="setupGame" method="get">
				<input type="submit" value="New Game" id="buttonStyle"
					style="width: 50%; 	background-color: #7ef54b; border-radius: 25px; font-family: fantasy; font-size: 20px;">
			</form>

			<input type="button" value="Profile" id="buttonStyle"
				onclick="window.location.href='userprofile.jsp'"
				style="width: 50%; background-color: #6285ff; border-radius: 25px; font-family: fantasy; font-size: 20px;">

		</div>
	</div>
</body>
</html>


