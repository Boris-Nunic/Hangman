<!DOCTYPE html>
<%@page import="javax.swing.text.html.HTMLDocument.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.bildit.beans.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.Integer"%>

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
			Personal Scores
			<h1>
				<div class="score">
					<div style="overflow-x: auto;">
						<table>
							<th></th>
							<th>Score</th>
							<%
								ArrayList<Integer> scores = (ArrayList<Integer>) request.getAttribute("scores");
								int i = 0;
								for (Integer e : scores) {
									i++;
							%>
							
							<tr>
								<td><%=i%></td>
								<td><%=e%></td>
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

