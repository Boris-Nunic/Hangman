<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<% String message = (String) request.getAttribute("message");%>
<html>
<head>
<title>Registration Failed</title>
<link rel="icon" href="img/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">

</head>
<body>

	<div class="regf style="padding-top: 45%;">

		<h1>message</h1 style="font color: red;">
				<a href="registration.jsp" class="btn btn-info" role="button">Please
					try again</a>
	</div>
</body>
</html>