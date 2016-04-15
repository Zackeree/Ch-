<!DOCTYPE html>


<html>
	<head>
		<title>Logged In!</title>
		<link href="_view/css/Style.css" rel="stylesheet" type="text/css">

	</head>
	
	<body>
	<span style="cursor:help">
		<div id="Title">
			<h1><center>
			You have successfully logged in!
			</center></h1>
		</div>
		
		<div id="Content">
			<center>
			<form action="${pageContext.servletContext.contextPath}/index" method="get">
			<span class="user">${user}</span>
			</form>
			</center>
		</div>
		
		<div id="Content">
			<center><a href="rooms">
			<button class="button button1">
			<h2>Join a Room!</h2>
			</button>
			</a></center>
		</div>
		
		<div id="Content">
			<center><a href="/home/">
			<button class="button button1">
			<h2>Logout</h2>
			</button>
			</a></center>
		</div>
		
		<div id="Filler"></div>
		
		<div id="Credits">
			<h5><center>Created by: Brandon Longenecker and Zackeree Henry</center></h5>
		</div>
	</span>
	</body>
</html>
