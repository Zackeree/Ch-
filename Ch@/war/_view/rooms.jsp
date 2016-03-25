<!DOCTYPE html>

<html>
	<head>
		<title>Chat Away!</title>
		<link rel='stylesheet' type='text/css' href='css/RoomStyle.css'/>
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'/>
		
	</head>

	<body>
	<center>
	<div class='chatContainer'>
		<div class='chatHeader'>
			<h3>Welcome</h3> <!-- Display users name/chat rooms name here -->
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
	</center>
	</body>
</html>