<html>
<!--contacts app-->

<head>
	<title>Details</title>
	
</head>
<style>
	body
	{
		background-color:skyblue;
	}
	h1
	{
		color:White;
		text-align:center;
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
			
<p align="left">
<a href="AdminOptions.jsp"><img src="/ContactsApp/images/home.jpg" width="50" height="50"></a></br></br>
</p>

<h1>Details</h1>
<p align="center">
<img src="/fbtest/images/addque.jpg" width="140" height="150">
</p>


<body>

<%@ page import="java.util.*,com.lxisoft.controller.*,com.lxisoft.model.*,java.sql.*"%>

   
			<%
SecurityQuestion securityQuestion=(SecurityQuestion)request.getSession().getAttribute("Ques");
Set<String> options=securityQuestion.getOptions();

%>

<div>
	<a href="edit?questionId=<%=securityQuestion.getQuestionId()%>"><img src="/fbtest/images/edit.jpg" width="50" height="50" title=editContact></a>
	<a href="delete?questionId=<%=securityQuestion.getQuestionId()%>"><img src="/fbtest/images/delete.jpg" width="50" height="50" title=deleteContact></a>

	<%out.println(""+securityQuestion.getImgUrl());
	out.println(""+securityQuestion.getQuestion());
	for(String option:options)
		out.println(option);
	out.println(""+securityQuestion.getAnswer());

</div>

</body>


</html>