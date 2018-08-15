<html>
<body>
<%@ page import="com.lxisoft.wayout.model.*,com.lxisoft.wayout.domain.*,java.util.*"%>

    <%

        TreeSet<User>users=(TreeSet<User>) request.getSession().getAttribute("users");

        for(User user:users)
        { %>

   
           <%  out.println(user.getUsername()); %></br></br>

       <% }


             %>
            <form action="UsersConfiguration" method="post">
                <input type="submit" value="promote">
            </form>
           
   
</body>

</html>

