<!DOCTYPE html>


<html>
	<head>
		<title>Logged In!</title>
		<link href="_view/css/Style.css" rel="stylesheet" type="text/css">

	</head>
	
	<body>
		<div id="Title">
			<h1><center>
			<form action="${pageContext.servletContext.contextPath}/change" method="get">
			Welcome,
			${username}!
			${status}
			</form>
			</center></h1>
		</div>
		
		<div id="Content">
			<center>
			<form action="${pageContext.servletContext.contextPath}/change" method="post">
			<p class="custom1">
			<span class="error">${error}</span><br><br>
			Old Password: <input type="password" maxlength="20" name="old" class="removespace"><br>
			New Password: <input type="password" maxlength="20" name="new" class="removespace"><br>
			Re-Enter Password:<input type="password" maxlength="20" name="new2" class="removespace">
			</p>
			</center>
		</div>
		
		<div id="Credits">
			<h5><center>Created by: Brandon Longenecker and Zackeree Henry</center></h5>
		</div>
	</body>
</html>
