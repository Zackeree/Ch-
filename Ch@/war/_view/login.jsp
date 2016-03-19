<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<html>
	<head>
		<title>Login</title>
		<link href="_view/css/Style.css" rel="stylesheet" type="text/css">

	</head>
	
	<body>
	<span style="cursor:help">
		<div id="Title">
			<h1><center>Login or Create an Account:</center></h1>
		</div>
		
		<div id="Content">
			<center>
			<form action="${pageContext.servletContext.contextPath}/Login" method="post">
			<p class="custom1">
			Username: <input type="text" maxlength="20" name="id" value="${id}">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			Password: <input type="password" maxlength="20" name="pass" value="${pass}"><br>
			</p>
			</form>
			</center>
		</div>
		
		<div id="Content">
			<center><a href="login"> 			<!--Should be login-->
			<button class="button button1">
			<h2>Submit</h2>
			</button>
			</a></center>
		</div>
		
		<div id="Content">
			<center><a href="index">
			<button class="button button1">
			<h2>Register</h2>
			</button>
			</a></center>
		</div>
		
		<div id="Content">
			<center><a href="javascript:history.back()">
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
