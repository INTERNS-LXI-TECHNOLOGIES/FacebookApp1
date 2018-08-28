
<!DOCTYPE html>
<head>
<title>Home</title>

<!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" type="text/css" href="css/mystyle.css">

<meta charset="UTF-8">
</head>
<body>
	<div class="container">
		<div class="text-center no-padding">
			<img src="..\images\done1.gif" style="width:600px;height:350px;margin-top:100px" class="done">
			<%
				String pageUrl=request.getParameter("page");
				response.setHeader("Refresh", "3;url="+pageUrl);
			%>

		</div>
	</div>

</body>
</html>