<html>
<body>
    <head>
<title>display All User</title>
    <link rel="stylesheet" type="text/css" href="Sample.css">
</head>
<div id="add">

<p align="left">
<a href="../admin"><img src="../images/icons/home.jpg" width="50" height="50"></a></br></br>

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

<%@ page import="com.lxisoft.wayout.model.*,com.lxisoft.wayout.domain.*,java.util.*"%>

    <%


        TreeSet<User>users=(TreeSet<User>) request.getSession().getAttribute("users");
        
        request.getSession().removeAttribute("users");


        for(User user:users)
        { 
    %>

   
    <%  out.print("name :");
        out.println(user.getUsername());
    %></br>
      <%  out.print("role : ");        
        out.println(user.getRole());

        String value;
             if(user.getRole().equals("admin"))
            {
                value="demote";
            }
            else
            {
                value="promote";
            }


     %></br></br>

      
            <form action="UsersConfiguration" method="post">
                <input type="hidden" value="<%=user.getUsername()%>" name="username">
                <input type="submit" value="<%=value%>" name="operation">
            </form>
             <form action="secure/deleteUser" method="get">
                <input type="hidden" value="<%=user.getUsername()%>" name="username">
                <input type="submit" value="delete">
            </form>
        <%

        }

        %>
   
</body>

</html>

