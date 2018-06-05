<!DOCTYPE html>
<%@page import="javax.swing.text.html.HTMLDocument.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.bildit.beans.User"%>
<%@page import="java.util.ArrayList"%>

<html>
<head>
<title>Leaderboard</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/lead.css">
<link rel="icon" href="img/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href='https://fonts.googleapis.com/css?family=Ubuntu:500'
	rel='stylesheet' type='text/css'>
</head>

<body>
	<div class="bord">
		<h1 style="text-align: center;">
			Leaderboard
			<h1>
				<div class="score">
					<div style="overflow-x: auto;">
						<table>
							<th></th>
							<th>Username</th>
							<th>Score</th>
							<%
								List<User> list = (List<User>) request.getAttribute("leaderboard");
								int i = 0;
								for (User e : list) {
									i++;
							%>
							<tr>
								<td><%=i%></td>
								<td><%=e.getUserName()%></td>
								<td><%=e.getScore()%></td>
							</tr>
							<%
								}
							%>


						</table>
					</div>
				</div>
				<br> <input type="button" value="GO BACK" id="buttonStyle"
					onclick="history.back()"
					style="width: 30%; background: greenyellow; height: 40px; margin-top: 10px; border-radius: 25px; font-family: fantasy; font-size: 20px; margin-left: 33%; MARGIN-BOTTOM: 20px;">

				</button>
	</div>
</body>
</html>

