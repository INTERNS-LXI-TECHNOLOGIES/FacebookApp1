<html>
<head>
<title>Edit user</title>
	<link rel="stylesheet" type="text/css" href="Sample.css">
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
</p>
<p align="right">
<a href="AdminOptions.jsp"><img src="images/icons/profile.jpg" width="50" height="50"></a></br></br>

</div>
<body>
<%@ page import= "com.lxisoft.wayout.domain.*,com.lxisoft.wayout.model.*,java.util.*"%>
<%String username=request.getParameter("username");
String password=request.getParameter("password");
String oldUsername=username;
%>

<form action="editUser" method="post">
    <center>

    <label for="username"><b>username</b></label>
    <input type="text" value="<%=username%>" name="username"  required></br></br>

    <label for="password"><b>password</b></label>
    <input type="text" value="<%=password%>"  name="password"  required></br></br>

    <input type=hidden value="<%=oldUsername%>" name="oldUsername" required></br>

    <input type="submit" value="Submit" class="button">
    <input type="Reset" value="Cancel" class="button">
</center>
</form>


</body>
</p>
</div>
</html>