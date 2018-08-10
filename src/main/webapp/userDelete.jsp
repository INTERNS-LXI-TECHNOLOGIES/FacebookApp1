<html>
<head>
<title>Deletet user</title>
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
    <form action="deleteUser" method="post">
        <h1><%out.println("do you want to delete your account");%></h1>

        <input align="center" type="submit" value="Submit" class="button">
    </form>
    <form action="user.jsp" method="post">
        <input align="center" type="submit" value="cancel" class="button">
    </form>
</body>

</html>