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
<center><h1>Save Success....</h1></center></br></br>
</div>


<form action="AddQuestion.jsp" method="post">
	<% out.println("do you want to add new question?");%>
<input type="submit" value="submit" name="first"/>
<a id="cancel" href="AdminOptions.jsp">home</a>

</form>

</body>
</html>
