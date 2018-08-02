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
    width: 80%;
    padding: 12px 20px;
    margin: 10px 0;
   
    border: 1px solid #ccc;
   color:black;
    background-color: #FFFFFF;
    font-size: 15px;
    
}

</style>
</style>
</p>
</div>
<body>
<%@ page import= "com.lxisoft.wayout.domain.*,com.lxisoft.wayout.web.*,java.util.*"%>
<% SecurityQuestion securityQuestion=(SecurityQuestion)request.getSession().getAttribute("question");
    
   String imageUrl=securityQuestion.getImageUrl();
   String question=securityQuestion.getQuestion();

%>
    <label for="imageUrl"><b>imageUrl</b></label>
    <input type="text" value="<%=imageUrl%>" name="imageUrl"  required></br></br>

    <label for="question"><b>Question</b></label>
    <input type="text" value="<%=question%>"  name="question"  required></br></br>



<form action="edit" method="post">
    
<div>
   <% 
        int noOfOptions=securityQuestion.getOptions().size();
        int count=0;
        for( String option:securityQuestion.getOptions())
        {
            count++;
            String optionName="option"+count;
           
    %>
        <label for=<%=optionName%>><b><%=optionName%></b></label>
        <input type="text" value="<%=option%>" name="<%=optionName%>" required></br></br>
    <%
        }
       String answer=securityQuestion.getAnswer();
       long id=securityQuestion.getQuestionId();

    %>
      


   
    <label for="answer"><b>answer</b></label>
    <input type="text" value="<%=answer %>" name="answer" required></br></br>

    <input type="hidden" value="<%=id%>" name="questionId"></br> 

    <input type="submit" value="Submit" class="button">
     <input type="reset" value="Reset" class="button">

  

</div>
</form>
</body>
</html>