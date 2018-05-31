<!DOCTYPE html>
<html>
<head>
<title> Registration </title>	
	<link rel="stylesheet" href="css/styles.css">
	<link rel="icon" href="img/favicon.ico" type="image/x-icon"/>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
	<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>

	<body style="background: url('img/slika.jpg');background-size:  100%;margin-bottom:  25%;">
	
	<div class="error">
	<label for="error" style="/* float: right; */margin-top: 50%;width: 400px; height:  250px; margin-left: 100%;"> </label>
	
	</div>
	
	<div class="register-box">
	<img src="img/avatar.png" class="avatar">

	<h1 style="color: darkorange;">Register</h1>
	<form action="registerUser" method="POST"> 
	<label for="username">  <br><b>Username</b></label>
	<input type="text" name="username" placeholder="" required="required" style="background: #ffffff;">
	<br>
	<label for="password"> <b>Password</b></label> 
	<input type="password" name="password" placeholder="" style="background: #ffffff;"> 
	<br>
	<label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="" name="psw_repeat" required="required" style="background: #ffffff;">
	<br>
	<br>
	<input type="Submit" name="submit" value="Register" style="background: greenyellow; width: 120px;">
	<input type="button" value="Login" id="buttonStyle" onclick="login.jsp" style="background: red;  width:120px; margin-top:2%;"> 
	<br>
	<input type="button" value="Home" id="buttonStyle" onclick="window.location.href='Home.html'" style="background: #0093ff;  width:  120px; margin-top:2%;">
	
	</form>
	</div>
	
	<div class="register-box">
	<img src="img/avatar.png" class="avatar">
 <h1 style="color: darkorange;">Register</h1>
	<form action="registerUser" method="POST" > 
	<label for="username">  <br><b>Username</b></label>
	<input type="text" name="username" placeholder="" required="required" style="background: #ffffff;">
	<br>
	<label for="password"> <b>Password</b></label> 
	<input type="password" name="password" placeholder="" style="background: #ffffff;"> 
	<br>
	<label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="" name="psw_repeat" required="required" style="background: #ffffff;">
	<br>
	<br>
	<input type="Submit" name="submit" value="Register" style="background: greenyellow; width: 120px;">
	<input type="button" value="Login" id="buttonStyle" onclick="login.jsp" style="background: red;  width:120px; margin-top:2%;"> 
	<br>
	<input type="button" value="Home" id="buttonStyle" onclick="Home.html" style="background: #0093ff;  width:  120px; margin-top:2%;">
	
	</form>
	</div>
	</body>
	</html>
