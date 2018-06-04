<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<% String message = (String) request.getAttribute("message");%>
<html>
<head>
<title>Registration Failed</title>
<link rel="stylesheet" type="text/css" href="css/mes.css">
<link rel="icon" href="img/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>

	<div class="regf" padding-top: 45%;">
		<p style="border: 10px solid #ce2626;padding 20px;text-align:center;font color: red;border-radius: 14px;padding-top: 40px;padding-bottom:  40px;color:  red;font-size:  25px;"> <img src="img/error.png"> <br> <%=message%> </p>
		
		<input type="button" value="SIGN UP" id="buttonStyle"onclick="window.location.href='registration.jsp'"
			style="WIDTH: 250px; height: 80px; background-color: #39b330; border: none; color: white; padding: 15px 25px; text-align: center; font-size: 16px; cursor: pointer; border-radius: 25px; font-size: 40px;">
	</div>
</body>
</html>