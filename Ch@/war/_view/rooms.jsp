<!DOCTYPE html>

<html>
	<head>
		<title>Chat Away!</title>
		<link rel='stylesheet' type='text/css' href='_view/css/RoomStyle.css'/>

	</head>

	<body>
	<center>
	<div id="Title">
	<h1><center>You Have Successfully Joined a Room</center></h1>
	</div>
	<div id="Content">
	<div class='chatContainer'>
		<div class='chatHeader'>
			<h3>Welcome, Chat Away!</h3> <!-- Display users name/chat rooms name here -->
		</div>
		<div class='chatMessages'></div>
		<div class='chatBottom'>
			<form action='#' onSubmit='return false;' id='chatForm'>
				<input type='hidden' id='name'/>
				<input type='text' name='text' id='text' value='' placeholder='type your chat message' />
				<input type='submit' name='submit' value='Post' />
			</form>
		</div>
	</div>
	</div>
	<div id="Credits">
	<h5><center>Created by: Brandon Longenecker and Zackeree Henry</center></h5>
	</div>
	</center>
	</body>
</html>