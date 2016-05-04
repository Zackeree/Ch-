<!DOCTYPE html>


<html>
	<head>
		<title>Logged In!</title>
		<link href="_view/css/Style.css" rel="stylesheet" type="text/css">

	</head>
	
	<body>
		<div id="Title">
			<h1><center>
			<form action="${pageContext.servletContext.contextPath}/index" method="get">
			Welcome,
			${username}!
			${status}
			</form>
			</center></h1>
		</div>
		
		<div id="Content">
		<h2><center>
		Select a room to join:
		</center></h2>
		</div>
		
		<div id="Content">
			<center><a href="rooms">
			<button class="button button1">
			<h2>SpamFest</h2>
			</button>
			</a></center>
		</div>
		
		<div id="Content">
		<h2><center>
		Make changes to your account:
		</center></h2>
		</div>
		
		<div id="Content">
			<center><a href="change">
			<button class="button button1">
			<h2>Change Password</h2>
			</button>
			</a></center>
		</div>
		
		<div id="Content">
			<center><a href="/home/">
			<form action="${pageContext.servletContext.contextPath}/index" method="post">
			<button class="button button1">
			<h2>Logout</h2>
			</button>
			</form>
			</a></center>
		</div>
		
		<div id="Credits">
			<h5><center>Created by: Brandon Longenecker and Zackeree Henry</center></h5>
		</div>
	</body>
</html>
