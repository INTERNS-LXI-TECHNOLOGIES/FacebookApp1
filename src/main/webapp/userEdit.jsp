<!DOCTYPE html>
<head>
  <title>edit user</title>
 
    <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <!-- Bootstrap core CSS -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
  <!-- Material Design Bootstrap -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.4/css/mdb.min.css" rel="stylesheet">
  
  <link rel="stylesheet" type="text/css" href="css/admin.css">
  </head>
  <body>

<%@ page import= "com.lxisoft.wayout.domain.*,com.lxisoft.wayout.model.*,java.util.*"%>
<%String username=request.getParameter("username");
String password=request.getParameter("password");
String oldUsername=username;
%>

<!-- Material form login -->
<div class="row">
      <div class="col-sm-3"></div>
      <div class="col-sm-6 text-centre"> 
<div class="card">
     
           <h5 class="card-header info-color white-text text-center py-4">
           <strong>Edit Account</strong>
           </h5>

  <!--Card content-->
  <div class="card-body px-lg-5 pt-0">

    <!-- Form -->
    <form class="text-center" style="color: #757575;" action="editUser" method="post">

      <div class="md-form">

         Username</br></br>
         <input type="text" id="materialLoginForm" class="form-control"  value="<%=username%>" name="question" required>
        
      </div>

      <div class="md-form">

         Password</br></br>
         <input type="password" id="materialLoginForm" class="form-control"  value="<%=password%>" name="question" required>
        
      </div>

      <input type=hidden value="<%=oldUsername%>" name="oldUsername" required></br>

      <div class="d-flex justify-content-around">
        <div>
               

      <div class="modal-footer justify-content-center">
                <input type="submit" value="Save" class="btn btn-outline-primary waves-effect">
                <a href='<%=request.getHeader("referer")%>' class="btn btn-outline-primary waves-effect">Cancel</a>
            </div>
         
         </div>
      
    </form>
    <!-- Form -->

  </div>

</div>
</div>
<!-- Material form login -->

</body>
</html>
  


   
    

  

