<html>
<head>
<title>Add Question</title>
	<link rel="stylesheet" type="text/css" href="Sample.css">
</head>
<div id="add">
<center><h1>Add Question</h1></center>
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
    background-color: #FFFFFF;
    border-radius: 3px;
    font-size: 15px;
    color:black;
    
}

</style>
</p>
</div>
<body>
<%@ page import= "com.lxisoft.wayout.domain.*,com.lxisoft.wayout.model.*,java.util.*"%>
<% AddQuestionModel addQuestionModel=(AddQuestionModel)session.getAttribute("model");
    if(addQuestionModel==null)
        addQuestionModel=new AddQuestionModel();

        String imageUrl=addQuestionModel.imageUrl;
        String question=addQuestionModel.question;


%>


<form action="addQuestion" method="post">
	<center>
<div>
    <label for="imageUrl"><b>imageUrl</b></label>
    <input type="text" value="<%=imageUrl%>" name="imageUrl"  required></br></br>

	<label for="question"><b>Question</b></label>
    <input type="text" value="<%=question%>"  name="Question"  required></br></br>

   


    <%

        int count=0;
        if(addQuestionModel.noOfOptions==0)
        { %>
            <label for="no:of options"><b> no:of options</b></label>
            <input type="text" placeholder="enter the no:of options" name="noOfOptions"  required>
            <input type="submit" value="v" class="button" width="50" height="50"></br>
       <% }
        else
        {
            int noOfOptions=addQuestionModel.noOfOptions;
            for(int i=1;i<=noOfOptions;i++)
            {
             count++;
            String optionName="option"+count;
    %>
        <label for=<%=optionName%>><b><%=optionName%></b></label>
        <input type="text" placeholder="<%=optionName %>" name="<%=optionName %>" required></br></br>
    <%
            }%>
            <label for="answer"><b>answer</b></label>
            <input type="text" placeholder="answer" name="answer" required></br></br>

            <input type="submit" value="Submit" class="button"  >
            <input type="reset" value="Reset" class="button">

      <%  }

    %>
   
    <label for="answer"><b>answer</b></label>
    <input type="text" placeholder="answer" name="answer" required></br></br>

    <input type="submit" value="Submit" class="button">
     <input type="reset" value="Reset" class="button">

  

</div></center>
</form>

</body>

</html>