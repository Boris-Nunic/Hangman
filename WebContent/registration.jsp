<!DOCTYPE html>
<html>
<head>
<title>Registration</title>
<link rel="stylesheet" href="css/logreg.css">
<link rel="icon" href="img/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
	<div class="login-page">
	
	<div class="register-box">
		<img src="img/avatar.png" class="avatar">
		<h1 style="color: darkorange;">Register</h1>
		<form action="registerUser" method="POST">
			<label for="username"><b>Username</b></label> <input type="text" name="username" placeholder=""
				required="required" style="background: #ffffff;"> 
				
			<label for="password"> <b>Password</b></label> <input type="password"
				name="password" placeholder="" style="background: #ffffff;">
			
			<label for="psw-repeat"><b>Repeat Password</b></label> <input type="password" placeholder="" name="psw_repeat" required="required"
				style="background: #ffffff;"> <br>
			<br>
		
			<input type="Submit" name="submit" value="Register" style="background: greenyellow; width: 120px;border-radius: 25px;height: 30px;">
			<input type="button" value="Login" id="buttonStyle" onclick="window.location.href='login.jsp'" style="background: red; width: 120px; margin-top: 2%;border-radius: 25px;height: 30px; margin-left:7px;"> <br>
			<input type="button" value="Home" id="buttonStylee" onclick="window.location.href='home.jsp'" style="background: #0093ff; width: 120px; margin-top: 2%;border-radius: 25px;height: 30px;">
			
			<div class="error">
		</form>

	</div>
	</div>
</body>
</html>
