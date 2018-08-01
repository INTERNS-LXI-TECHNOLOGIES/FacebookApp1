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
<a href="AdminOptions.jsp"><img src="images/icons/home.jpg" width="50" height="50"></a></br></br>
</p>

<h1>Details</h1>



<body>

<%@ page import="java.util.*,com.lxisoft.wayout.web.*,com.lxisoft.wayout.model.*,com.lxisoft.wayout.domain.*,java.sql.*,java.util.*"%>

   
			<%
SecurityQuestion securityQuestion=(SecurityQuestion)session.getAttribute("ques");
Set<String> options=securityQuestion.getOptions();

%>

<div>
	<a href="edit?questionId=<%=securityQuestion.getQuestionId()%>"><img src="images/icons/edit.jpg" width="50" height="50" title=editContact></a>
	<a href="delete?questionId=<%=securityQuestion.getQuestionId()%>"><img src="images/icons/delete.jpg" width="50" height="50" title=deleteContact></a>
	<%String imgurl=securityQuestion.getImageUrl();%>
	<img src="<%=imgurl%>"  height="150" width="140">
	<%
	out.println(""+securityQuestion.getQuestion());
	for(String option:options)
		out.println(option);

	out.println(""+securityQuestion.getAnswer());%>

</div>
	
</body>


</html>