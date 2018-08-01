<head>
<title>Delete Question</title>
	<link rel="stylesheet" type="text/css" href="Sample.css">
</head>
<div id="add">
<h1>Delete Question</h1>
<p align="left">
<a href="AdminOptions.jsp"><img src="/images/icons/home.jpg" width="50" height="50"></a></br></br>

<style>
.button{
	background-color:cornflowerblue;
	color:white;
}
.button:hover{
	background-color:green;
}

input[type=text] {
    width: 100%;
    padding: 12px 20px;
    margin: 10px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

</style>
</p>
</div>
<form action="AdminOptions.jsp" method="post">
   <% SecurityQuestion secQuestion=(SecurityQuestion)session.getAttribute("question");
   out.println(""+secQuestion.getQuestion()+"is deleted");%>
   <input type="submit" value="ok">


</form>




</html>