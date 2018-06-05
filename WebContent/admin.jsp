<%String message = (String)request.getAttribute("message");
if (message == null) {
	message = "";
}
%>
<!DOCTYPE html>
<html>
<head>
<title>Admin</title>
<link rel="icon" type="image/png" href="img/favicon.ico" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>

	<div class="admin">
		<h1>Admin panel- Please choose</h1>


		<input type="button" value="Delete user" id="btn btn-primary"
			onclick="window.location.href='delUser.jsp'"
			style="WIDTH: 100%; height: 50px; background-color: #b8430b; border: none; color: white; padding: 15px 25px; text-align: center; font-size: 16px; cursor: pointer; border-radius: 25px; margin-bottom: 5px;">
		<br> <input type="button" value="Add Word" id="button"
			onclick="window.location.href='addWord.jsp'"
			style="WIDTH: 100%; height: 50px; background-color: #0b78b8; border: none; color: white; padding: 15px 25px; text-align: center; font-size: 16px; cursor: pointer; border-radius: 25px; margin-bottom: 5px;">
		<br> <input type="button" value="Delete Word"
			id="btn btn-primary" onclick="window.location.href='delWord.jsp'"
			style="WIDTH: 100%; height: 50px; background-color: #676767; border: none; color: white; padding: 15px 25px; text-align: center; font-size: 16px; cursor: pointer; border-radius: 25px; margin-bottom: 5px;">
		<br><h3><%=message%></h3>

	</div>
</body>
</html>



