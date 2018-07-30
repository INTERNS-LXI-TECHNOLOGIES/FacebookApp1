</html>
<head>
<title>Display all Question</title>
	<link rel="stylesheet" type="text/css" href="Sample.css">
</head>
<div id="add">
<h1>Display all Question</h1>
<p align="left">
<a href="AdminOptions.jsp"><img src="/ContactsDB/images/home.jpg" width="50" height="50"></a></br></br>

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
<% @ page import="com.lxisoft.wayout.web.*,com.lxisoft.wayout.domain.*,java.sql.*"%>

<%Set<question> secQuestion=(Set<Question>)request.getSession.getAttribute("question");%>
<table style="width:100%">
<caption>Questions</caption>
    <tr>
        <th>question</th>
        <th>answer</th>
    </tr>
    <tr>
   <% while(secQuestion.hasNext()){%>

       <td> <a href="search?questionId=<%=secQuestion.getQuestionId()%>"><%out.println(secQuestion.getQuestion());%></a></td>
       <td><%out.println(secQuestion.getQuestion());%></td>
   </tr>
</table>
<%
}




%>



</html>