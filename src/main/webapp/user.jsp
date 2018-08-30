<!DOCTYPE html>
<head>
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

  <link rel="stylesheet" type="text/css" href="css/admin.css">
  <title>user</title>
</head>
<%@ page import= "com.lxisoft.wayout.domain.*,com.lxisoft.wayout.model.*,java.util.*,java.sql.*"%>
<%User user=(User)session.getAttribute("user");%>

 <!--<form action="userEdit.jsp" method="post">
    <input type="hidden" value="<%=user.getUsername()%>" name="username">
    <input type="hidden" value="<%=user.getPassword()%>" name="password">

<input type="image" src="images/icons/edit1.jpg" width="80" height="80" title=editUser alt="Edit Form" />
</form>



<%out.println("username:"+user.getUsername());%></br></br>
<%out.println("password:"+user.getPassword());%>-->

<body class="light-grey">
  <div class="container-fluid">
  <div class="row">
    <div class="col-sm-1"></div>
    <div class="col-sm-10 float-right text-right">
      <a href="AdminOptions.jsp"><img src="images/icons/home-blue.png"></a>

      <a href="userEdit.jsp?username=<%=user.getUsername()%>&password=<%=user.getPassword()%>"><img src="images/icons/edit-blue.png"></a>

      <a href="" data-toggle="modal" data-target="#sideModalTLInfo" ><img src="images/icons/delete-blue1.png"></a>

  </div>
  </div>

  <!-- Central Modal Medium Info -->

<div class="modal fade left" id="sideModalTLInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-notify modal-info " role="document">
        <!--Content-->
        <div class="modal-content">
            <!--Header-->
            <div class="modal-header">
                <p class="heading lead">Remove Info</p>

                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true" class="white-text">&times;</span>
                </button>
            </div>

            <!--Body-->
            <div class="modal-body">

                   <div class="text-center">
                    <p>Do you want to delete this account now?</p>
                </div>
            </div>

            <!--Footer-->
            <div class="modal-footer justify-content-center">
                <a type="button" class="btn btn-outline-primary waves-effect" href="userDelete.jsp?username=<%=user.getUsername()%>">Yes</a>
                <a type="button" class="btn btn-outline-primary waves-effect" data-dismiss="modal">No, thanks</a>
            </div>
        </div>
        <!--/.Content-->
    </div>
</div>


<!-- Central Modal Medium Info -->

  <div class="row">
    <div class="col-sm-12 text-center question">
      <h3>Logged in as</h3>
    </div>
  </div>
  <div class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-4 text-center question-image">
      <img src="images/dp.png">
    </div>
    <div class="col-lg-7 option-answer">
      <div class="row options">
      <h5>Username</h5>
      <ul>
        <li><p><%=user.getUsername()%></p></li>
      </ul>
      </div>
      <div class="row answer">
        <h5>Password</h5>
        <ul>
        <li><%=user.getPassword()%></li>
      </ul>
      </div>
        <div class="row answer">
          <h5>Role</h5>
          <ul>
          <li><%=user.getRole()%></li>
        </ul>
        </div>          
      </div>
    </div>
  </div>

  
<script>
$("#sideModalTLInfo").on('shown.bs.modal');
</script>


</body>
<<<<<<< HEAD
</p>
</div>
=======
>>>>>>> eac88a323d5114290f6631f3dc9383b002c5cae4
</html>