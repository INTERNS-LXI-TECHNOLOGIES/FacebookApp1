
<!DOCTYPE html>
<head>
<title>Home</title>
<link rel="stylesheet" type="text/css" href="bootstrap.css">
<link rel="stylesheet" type="text/css" href="mystyle.css">
<meta charset="UTF-8">
</head>
<body>
	<div class="container">
		<div class="text-center no-padding">
			<img src="images\done1.gif" style="width:700px;height:600px;" class="done">
			<%
				response.setHeader("Refresh", "3;url=addQuestion");
			%>

		</div>
	</div>

</body>
</html>