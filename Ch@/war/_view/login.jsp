<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<html>
	<head>
		<title>Login</title>
		<link href="_view/css/Style.css" rel="stylesheet" type="text/css">
		<script   src="https://code.jquery.com/jquery-2.2.2.min.js"   integrity="sha256-36cp2Co+/62rEAAYHLmRCPIych47CvdM+uTBJwSzWjI="   crossorigin="anonymous"></script>
		<script type="text/javascript" src="_view/script.js"></script>
		
	</head>
	
	<body>
	<span style="cursor:help">
		<div id="Title">
			<h1><center>Login to your Account:</center></h1>
		</div>
		
		<div id="Content">
			<center>
			<form action="${pageContext.servletContext.contextPath}/login" method="post">
			<p class="custom1">
			<span class="error">${error}</span><br><br>
			Username: <input type="text" maxlength="20" name="id" class="removespace">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			Password: <input type="password" maxlength="20" name="pass" class="removespace"><br>
			</p>
			</center>
		</div>
		
		<div id="Content">
			<center>
			<button class="button button1"> 
			<h2>Submit</h2>
			</button>
			</center>
			</form>
		</div>
		
		<div id="Content">
			<center><a href="register">
			<button class="button button1">
			<h2>Register</h2>
			</button>
			</a></center>
		</div>
		
		<div id="Content">
			<center><a href="/home/">
			<button class="button button1",>
			<h2>Return Home</h2>
			</button>
			</a></center>
		</div>
		
		<div id="Credits">
			<h5><center>Created by: Brandon Longenecker and Zackeree Henry</center></h5>
		</div>
	</span>
	</body>
</html>
