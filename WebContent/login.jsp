<!DOCTYPE html>
<html>
<head>
<title> Login </title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/styles.css">
	<link rel="icon" href="img/favicon.ico" type="image/x-icon"/>
	<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href='https://fonts.googleapis.com/css?family=Ubuntu:500' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
	
	
</head>

<body style="background: url('img/slika.jpg');background-size:  100%;margin-bottom: 25%;">


<div class="loginpage">
 
<div class="register-box">
<img src="img/avatar.png" class="avatar">

	<h1 style="color: darkorange;">Login</h1>
	<form action="login" method="GET" > 

	<label for="username"> <b>Username</b> </label>
	<input type="text" name="username" placeholder="" required="required" style=" background: #ffffff;">
	<br>
	<label for="password"><b>Password</b></label>
	<input type="password" name="password" placeholder="" required="required" style="background: #ffffff;">
	<br>
	<br>
	<input type="Submit" name="submit" value="Login" style="background: greenyellow; width: 120px;">
	<input type="button" value="Go Back" id="buttonStyle" onclick="history.back()" style="background: red; margin-left: 35px; width:  120px;">
	
	</form>
	</div>
	
	</div>
	
	
	</body>

	</html>
