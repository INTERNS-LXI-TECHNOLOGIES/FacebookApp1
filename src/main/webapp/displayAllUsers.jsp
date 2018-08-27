<html>
<body>
<%@ page import="com.lxisoft.wayout.model.*,com.lxisoft.wayout.domain.*,java.util.*"%>

    <%


        TreeSet<User>users=(TreeSet<User>) request.getSession().getAttribute("users");

        for(User user:users)
        { 
    %>

   
    <%  out.print("name :");
        out.println(user.getUsername());
        out.print("role : ");        
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
             <form action="RemoveUser" method="get">
                <input type="hidden" value="<%=user.getUsername()%>" name="username">
                <input type="submit" value="delete">
            </form>
        <%

        }

        %>
   
</body>

</html>

