
<!DOCTYPE html>
<head>
  <title>DisplayAll</title>
 
    <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <!-- Bootstrap core CSS -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
  <!-- Material Design Bootstrap -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.4/css/mdb.min.css" rel="stylesheet">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <!-- JQuery -->
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.13.0/umd/popper.min.js"></script>
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/js/bootstrap.min.js"></script>
  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.8/js/mdb.min.js"></script>
  
  <!-- <link rel="stylesheet" type="text/css" href="bootstrap.css"> -->
  <link rel="stylesheet" type="text/css" href="css/mystyle.css">
  <link rel="stylesheet" type="text/css" href="css/admin.css">
  <link rel="stylesheet" type="text/css" href="css/mystyle.css">
  <link rel="stylesheet" type="text/css" href="css/button.css">
  <!-- <link rel="stylesheet" type="text/css" href="Sample.css"> -->
</head>
<body>



<%@ page import="com.lxisoft.wayout.model.*,com.lxisoft.wayout.domain.*,java.util.*"%>

    <%


        TreeSet<User>users=(TreeSet<User>) request.getSession().getAttribute("users");
        
        request.getSession().removeAttribute("users");

%>

<!-- Editable table -->
<div class="card">
    <div class="col-sm-2"></div>
  <div class="col-sm-12">
    <h3 class="card-header text-center font-weight-bold text-uppercase py-4">User accounts</h3>
    <div class="card-body">
        <div id="table" class="table-editable">
            <span class="table-add float-right mb-3 mr-2"><a href="AdminOptions.jsp"><img src="images/icons/home-blue.png" width="10" height="10" class="text-success">
            </a></span>

            <span class="table-add float-right mb-3 mr-2"><a href="addUser.jsp"><img src="images/add-user.png" width="10" height="10" class="text-success">
            </a></span>
            <table class="table table-bordered table-responsive-md table-striped text-center">
                <tr>
                    <th class="text-center">Username</th>
                    <th class="text-center">Role</th>
                    <th class="text-center">Change role</th>
                    <th class="text-center">Remove account</th>
                </tr>
  
    <% for(User user:users)
   { 

            String value;
             if(user.getRole().equals("admin"))
            {
                value="demote";
            }
            else
            {
                value="promote";
            }
    %>

                <tr>
                    <td class="pt-3-half" contenteditable="false"><%=user.getUsername()%></td>
                    <td class="pt-3-half" contenteditable="false"><%=user.getRole()%></td>

                    <td><form action="admin/secured/modify" method="post">
                        <input type="hidden" value="<%=user.getUsername()%>" name="username">
                        <span class="table-remove"><input type="submit" value="<%=value%>" name="operation"></span>
                  </form></td>


                    <td class="pt-3-half" contenteditable="false"><form action="admin/secured/modify" method="get">
                      <input type="hidden" value="<%=user.getUsername()%>" name="username">
                      <span class="table-remove"><input type="submit" class="remove-button" value="delete"></span>
                    </form></td> 

                </tr>  


<!-- Central Modal Medium Info -->


<!-- Central Modal Medium Info -->

<%}%>

</table>
         </br>
         </br>
        </div>
    </div>
</div>
<!-- Editable table -->
    </div>
  
<script>
$("#sideModalTLInfo").on('shown.bs.modal');
</script>

</body>

</html>