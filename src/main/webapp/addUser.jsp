<html>
<head>
<title>Add User</title>
<h1>Add New User</h1>
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


</div>
<body>
<%@ page import= "com.lxisoft.wayout.domain.*,com.lxisoft.wayout.model.*,java.util.*"%>
<form action="admin/secure/addUser" method="post">
     <input type="text" placeholder="name" name="username" required></br></br>
    <label for="name"></label>
    <input type="text" placeholder="password" name="password" required=""></br></br>
    <label for="password"></label>
    <input type="text" placeholder="role" name="role" required=""></br></br>
    <label for="role"></label>
    <input type="submit" value="submit">
    <label for="submit"></label>

</form>



