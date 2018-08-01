<!DOCTYPE html>
<head>
	<title>story</title>
	<link rel="stylesheet" type="text/css" href="css\way_out.css">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="js/my-countdownTimer.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8">
</head>
<body onload="checkCookie()">
		<%
		session.setAttribute("model",null); 
		response.sendRedirect("play");%>
</body>
</html>