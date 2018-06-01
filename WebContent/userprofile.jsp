
<!DOCTYPE html>
<%@page import="org.bildit.beans.User"%>
<html>

<head>
<title>User profile</title>
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href='https://fonts.googleapis.com/css?family=Ubuntu:500'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/styles.css">
</head>

<body>
	<div class="profil">
		<h1>Welcome</h1>
		<%
			User user = (User) session.getAttribute("user");
		%>
		<h3>
			<%=user.getUserName()%>
		</h3>

		<div class="score">
			<table align="center" color="black">
				<th><h4>
						Highest score
						<h4></th>
				<tr>
					<td><%=user.getScore()%></td>
				</tr>
			</table>
		</div>
		<br>
		<form action="setupGame" method="get">
			<input type="submit" value="New Game" id="buttonStyle"
				style="WIDTH: 100%; height: 50px; background-color: #32e20f; border: none; color: white; padding: 15px 25px; text-align: center; font-size: 16px; cursor: pointer; border-radius: 25px; margin-bottom: 5px;">
		</form>

		<input type="button" value="Leaderboard" id="buttonStyle"
			onclick="window.location.href='leaderboard.html'"
			style="WIDTH: 100%; height: 50px; background-color: #636363; border: none; color: white; padding: 15px 25px; text-align: center; font-size: 16px; cursor: pointer; border-radius: 25px; margin-bottom: 5px;">

		<input type="button" value="Log Out" id="buttonStyle"
			onclick="window.location.href='logut'"
			style="WIDTH: 100%; height: 50px; background-color: #f5282a; border: none; color: white; padding: 15px 25px; text-align: center; font-size: 16px; cursor: pointer; border-radius: 25px; margin-bottom: 5px;">

		</br>
		</button>
	</div>
	</form>

	</div>
</body>
</html>




















