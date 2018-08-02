<!DOCTYPE html>
<head>
	<title>game</title>
	<link rel="stylesheet" type="text/css" href="css\way_out.css">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="js/wayout.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8">
</head>
<body style="background-color: black" onload="resetCookie()">
	<% session.invalidate();%>
	<div class="text-center" style="margin-top: 40px; ">
		<img src="images/cry.png" style="width: 30%; margin: 50px auto 30px auto;" class="text-center">
		<h2 style="color: #e5cd16">Try again..</h2>
	</div>
</body>
</html>