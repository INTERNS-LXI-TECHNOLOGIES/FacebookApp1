<!--Author :neeraja admin crud operations-->

<!--Author :neeraja admin crud operations-->

<html>
<head>
<title>Redirecting page</title>
</head>

<style>
	body
	{ 
		background-color:lightblue;
	}
	h1
	{
		color:White;
		text-align:center;
	}
	
	
</style>
<body>
<div>
<h1>Operations</h1></br></br>
</div>


<form action="redirect" method="post">
	<% out.println("do you want to add new question?");%>
<input type="submit" value="submit" name="first"/>
<input type="submit" value="cancel" name="second"/>
	

</form>

</body>
</html>
