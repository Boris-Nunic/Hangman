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
<link rel="icon" type="image/png" href="img/favicon.ico" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>

<body>
	<div class="game" style="padding-bottom: 35%">

		<img src="<%=gs.setHangermanPicture(game.getNumOfErrors())%>"
			style="padding-left: 25%; padding-top: 10px;">

		<div class="form-group" style="text-align: center;">
			<!-- <form action="/game" method="POST"> -->
			<form action="game" method="post">
				<h3>
					<label for="word">Insert word:</label>
				</h3>
				<input type="text" name="guess" class="btn btn-info"
					value="Insert guess">
			</form>
		</div>
		<div class="form-group" style="text-align: center;">
			<h3>Solution:</h3>

			<h3><%=game.getConcealedWord()%></h3>
			<h3>FailedAttempts</h3>
			<h3><%=game.getAttempts()%></h3>
		</div>
		<br> <br>
		<form action=> 
		<input type="button" value="New Game"
			id="buttonStyle" 
			style="WIDTH: 100%; height: 40px; background-color: #7ae441; border-radius: 25px; font-family: fantasy; font-size: 20px;">

		<input type="button" value="Profile" id="buttonStyle"
			onclick="Userprofile.html"
			style="WIDTH: 100%; height: 40px; background-color: #6285ff; border-radius: 25px; font-family: fantasy; font-size: 20px;">
		<input type="button" value="Go back" id="buttonStyle"
			onclick="history.back()"
			style="WIDTH: 100%; height: 40px; background-color: red; border-radius: 25px; font-family: fantasy; font-size: 20px;">

	</div>
</body>
</html>


