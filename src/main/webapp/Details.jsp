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
	
	
</style>

<%@ page import="java.util.*,com.lxisoft.controller.*,com.lxisoft.model.*,java.sql.*"%>

   
			<%
SecurityQuestion securityQuestion=(SecurityQuestion)request.getSession().getAttribute("Ques");
Set<String> options=securityQuestion.getOptions();


<table style="width:100%">
  <caption>Questions</caption>
  <tr>
    <th>question</th>
    <th>option 1</th>
    <th>option 2</th>
    <th>option 3</th>
    <th>option 4</th>
    <th>answer</th>
    <th>edit</th>
    <th>delete</th>
  </tr>
  <tr>
    <td><%securityQuestion.getQuestion();%></td>
    for(String option:options)
    <td><%=option%></td>
    <td><%securityQuestion.getAnswer();%></td>
    <td><a href="edit?name=<%=contact.getName()%>"><img src="/ContactsApp/images/edit.jpg" width="50" height="50" title=editContact></a></td>
    <td><a href="delete?name=<%=contact.getName()%>"><img src="/ContactsApp/images/delete.jpg" width="50" height="50" title=deleteContact></a></td>
    
  </tr>
  
</table>



			<body>
<p align="left">
<a href="AdminOptions.jsp"><img src="/ContactsApp/images/home.jpg" width="50" height="50"></a></br></br>
</p>

<h1>Details</h1>
<p align="center">
<img src="/fbtest/images/addque.jpg" width="140" height="150">
</p>

<!--<a href="edit?name=<%=contact.getName()%>"><img src="/ContactsApp/images/edit.jpg" width="50" height="50" title=editContact></a>
<a href="delete?name=<%=contact.getName()%>"><img src="/ContactsApp/images/delete.jpg" width="50" height="50" title=deleteContact></a>
<link rel="stylesheet" type="text/css" href="Sample.css"/>
</div>-->
			
			
	
</br><%out.println("<>"); out.println("Q: "+securityQuestion.getQuestion());%></br>
<%
for(Option opt:options){
int 1=1;
	out.println("opt "+i+":"+opt);
	i++;
}
out.println("<>"); out.println("A: "+securityQuestion.getQuestion());%></br>



</body>


</html>