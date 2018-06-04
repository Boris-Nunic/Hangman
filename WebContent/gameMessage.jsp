<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	String message = (String) request.getAttribute("message");
%>
<html>
<head>
<title>Game Message</title>
<link rel="icon" href="img/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/gamemsg.css">
</head>
<body>
	<div class="klasa" style="margin-left: 5%;">

		<h1><%=message%></h1>

		<form action="setupGame">
			<input type="submit" value="Play again" id="buttonStyle"
				style="WIDTH: 250px; height: 80px; background-color: #39b330; border: none; color: white; padding: 15px 25px; text-align: center; font-size: 16px; cursor: pointer; border-radius: 25px; font-size: 40px;">
		</form>
		<br>
		<input type="button" value="Profile" id="buttonStyle"
			onclick="window.location.href='userprofile.jsp'"
			style="WIDTH: 250px; height: 80px; background-color: #39b330; border: none; color: white; padding: 15px 25px; text-align: center; font-size: 16px; cursor: pointer; border-radius: 25px; font-size: 40px;">
	</div>



</body>
</html>