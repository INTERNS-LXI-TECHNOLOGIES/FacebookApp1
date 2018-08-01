<html>
<head>
<title>Edit Question</title>
	<link rel="stylesheet" type="text/css" href="Sample.css">
</head>
<div id="add">
<h1>Edit Question</h1>
<p align="left">
<a href="AdminOptions.jsp"><img src="images/icons/home.jpg" width="50" height="50"></a></br></br>

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
<body>
<%@ page import= "com.lxisoft.wayout.domain.*,com.lxisoft.wayout.web.*"%>
<% SecurityQuestion securityQuestion=request.getSession.getAttribute("question");
    Set<String>options=securityQuestion.getOptions();
    for(String opt:options)

%>

<form action="edit" method="post">
    
<div>
    <label for="imageUrl"><b>imageUrl</b></label>
    <input type="text" value="<%securityQuestion.getImageUrl()%>" name="imageUrl"  required></br></br>

    <label for="question"><b>Question</b></label>
    <input type="text" value="<%securityQuestion.getQuestion()%>" name="Question"  required></br></br>

    <label for="option 1"><b>option 1</b></label>
    <input type="text" value="<%securityQuestion.getOption().get(0)%>" name="option1" required></br></br>

    <label for="option 2"><b>option 2</b></label>
    <input type="text" value="<%securityQuestion.getOption().get(1)%>"" name="option2" required></br></br>

    <label for="option 3"><b>option 3</b></label>
    <input type="text" value="<%securityQuestion.getOption().get(2)%>" name="option3" required></br></br>

   
    <label for="answer"><b>answer</b></label>
    <input type="text" value="<%securityQuestion.getanswer()" name="answer" required></br></br>

    <input type="hidden" value="<%securityQuestion.getId()%>" name="questionId"></br> 

    <input type="submit" value="Submit" class="button">
     <input type="reset" value="Reset" class="button">

  

</div>
</form>
</body>
</html>