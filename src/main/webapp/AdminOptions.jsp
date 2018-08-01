<!--Author :neeraja admin crud operations-->

<!--Author :neeraja admin crud operations-->

<html>
<head>
<title>Home</title>
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

<a href="AddQuestion.jsp"><img src="images/icons/addQuestion.jpg" width="100" height="100" title=addQuestion><h2><%out.println("add a question");%></h2></a></br></br>


<form action="addQuestion" method="get"> 
	<h2><input align="center" type="submit" value="showAllQuestions"></h2>
</form>

<form action="search" method="get" >


<input type="text" name="questionId" placeholder="search id">
<input type="submit" value="go"></br>
</form>


</body>
</html>