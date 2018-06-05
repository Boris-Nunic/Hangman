<!DOCTYPE html>
<html>
<head>
<title>AddUser</title>
<link rel="icon" type="image/png" href="img/favicon.ico" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>

	<div class="users">
		<form action="addWord" method="POST">
			<h1>Add User Options:</h1>
			<div class="form-group">
				<label for="word">Add Word:</label> <input type="word"
					class="form-control" id="word" name="word">

			</div>


			<input type="submit" class="btn btn-info" value="Add Word" /> <a
				href="admin.jsp" class="btn btn-info" role="button">Go Back</a>
		</form>

	</div>
</body>
</html>


