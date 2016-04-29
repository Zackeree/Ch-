<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<title>Chat Away!</title>
		<link rel='stylesheet' type='text/css' href='_view/css/RoomStyle.css'/>
		<script src="https://code.jquery.com/jquery-2.2.2.min.js"   integrity="sha256-36cp2Co+/62rEAAYHLmRCPIych47CvdM+uTBJwSzWjI="   crossorigin="anonymous"></script>
		<script type="text/javascript" src="_view/js/script.js"></script>
	</head>
	
	<body>
	
	<center>
	
	<div id="Title">
	<h1><center>
	You Have Joined 
	SpamFest
	!
	</center></h1>
	</div>
	
	<div id="Content">
	<div class='chatContainer'>
		<div class='chatHeader'>
			<h2>Welcome, Chat Away!</h2> <!-- Display users name/chat rooms name here -->
		</div>
		<div id='chatMessages'>
		<ul style ="list-style-type:none">
		<c:forEach items="${messages}" var="message">
			<li>
			<p style="text-align: left;">
				
				${message.text}
			<span style="float:right;">
				${message.time}<br>
			</span>
			</p>
			</li>
		</c:forEach>
		</ul>
		</div>
		<!-- <span class="messages">${messages}</span><br><br>  -->
		
		<div class='chatBottom'>
			<form action="${pageContext.servletContext.contextPath}/rooms" method='post'>
				<input type='text' name='text' id='text' value='' placeholder='type your chat message' />
				<input type='submit' name='submit' value='Send' />
				
				<script>
				var scroll = document.getElementById("chatMessages");
				scroll.scrollTop = scroll.scrollHeight;
				</script>
				
			</form>
		</div>
	</div>
	</div>
	
	<!--  not sure why button doesn't have styles -->
	
	<div id="Content">
		<center><a href="index">
		<button class="button button1">
		<h2>Go Back</h2>
		</button>
		</a></center>
	</div>
	
	<div id="Credits">
	<h5><center>Created by: Brandon Longenecker and Zackeree Henry</center></h5>
	</div>
	
	</center>
	
	</body>
</html>