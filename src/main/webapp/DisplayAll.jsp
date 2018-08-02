</html>
<head>
<title>Display all Question</title>
	<link rel="stylesheet" type="text/css" href="Sample.css">
</head>
<div id="add">
<center><h1> Question</h1></center>
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
table, th, td {
    border: 1px solid black;
}

</style>
</p>
</div>
<%@ page import="com.lxisoft.wayout.web.*,com.lxisoft.wayout.domain.*,java.sql.*,java.util.*"%>

<%
Set<SecurityQuestion> secQuestions=(Set<SecurityQuestion>)session.getAttribute("question");
//Set<SecurityQuestion> secQuestions=Set<SecurityQuestion>)session.getAttribute("PageImport");
//Collections.sort(secQuestions);
%>
<table style="width:100%">
<caption>Questions</caption>
    <tr>
        <th>questionId</th>
        <th>question</th>
        <th>answer</th>
    </tr>
    <% for(SecurityQuestion secQuestion:secQuestions){
    /*for(int i=secQuestions.size();i<=0;i--){
   SecurityQuestion secQuestion=secQuestions.get(i);*/ %>

    <tr>
   
      <td><center><%out.println(secQuestion.getQuestionId());%></center></td>
      <td>  <center> <a href="search?questionId=<%=secQuestion.getQuestionId()%>"><%out.println(secQuestion.getQuestion());%></a></center></td>
       <td><center><%out.println(secQuestion.getAnswer());%></center></td>
   </tr>
   <%
}

%>
</table>


  


</html>