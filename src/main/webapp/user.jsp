<html>
<head>
<title>Add Question</title>
	<link rel="stylesheet" type="text/css" href="css/admin.css">

        <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.4/css/mdb.min.css" rel="stylesheet">
</head>
<div id="add">

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

<body>
<%@ page import= "com.lxisoft.wayout.domain.*,com.lxisoft.wayout.model.*,java.util.*,java.sql.*"%>
<%User user=(User)session.getAttribute("user");%>
 <form action="userEdit.jsp" method="post">
    <input type="hidden" value="<%=user.getUsername()%>" name="username">
    <input type="hidden" value="<%=user.getPassword()%>" name="password">

<input type="image" src="images/icons/edit1.jpg" width="80" height="80" title=editUser alt="Edit Form" />
</form>



<%out.println("username:"+user.getUsername());%></br></br>
<%out.println("password:"+user.getPassword());%>




</body>
</p>
</div>
</html>