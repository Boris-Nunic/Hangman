<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@page import="org.bildit.beans.User"%>
<html>
<head>
    <title>Login Message</title>
    <link rel="icon" href="img/favicon.ico" type="image/x-icon"/>
	<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/styles.css">
</head>
<body>

	<%User user = (User)request.getAttribute("user"); %>
	
<div class="regf" padding-top: 45%;">
		<p style="border: 10px solid #ce2626;padding 20px;text-align:center;font color: red;border-radius: 14px;padding-top: 40px;padding-bottom:  40px;color:  red;font-size:  25px;"> <img src="img/error.png"> <br> <%=user.getMessage() %> </p>
		
		<input type="button" value="Please try again" id="buttonStyle"onclick="window.location.href='login.jsp'"
			style="WIDTH: 350px; height: 80px; background-color: #39b330; border: none; color: white; padding: 15px 25px; text-align: center; font-size: 16px; cursor: pointer; border-radius: 25px; font-size: 20px; margin-left: 20%;
">
		


</div>
</body>
</html>
