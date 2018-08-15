<html>
<body>
<%@ page import="com.lxisoft.wayout.model.*,com.lxisoft.wayout.domain.*"%>

    <%

        TreeSet<User>users=(TreeSet<User>) request.getSession().getAttribute("users");

        for(User user:Users)
        {

    %>
             out.println(user.getUsername());
            <form action="UsersConfiguration" method="post">
                <input type="submit" value="promote">
            </form>
            <br>
             <form action="DeleteUser" method="get">
               <input type="submit" value=delete>
            </form>
    <%
        }
    %>

</body>

</html>

