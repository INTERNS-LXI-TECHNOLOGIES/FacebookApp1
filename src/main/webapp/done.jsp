
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
			<img src="images\done1.gif" style="width:800px;height:800px;border-radius:800px" class="done">
			<%
				response.setHeader("Refresh", "3;url=addQuestion");
			%>

		</div>
	</div>

</body>
</html>