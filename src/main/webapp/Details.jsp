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
</head>
<%@ page import="java.util.*,com.lxisoft.wayout.web.*,com.lxisoft.wayout.model.*,com.lxisoft.wayout.domain.*,java.sql.*,java.util.*"%>
<%
SecurityQuestion securityQuestion=(SecurityQuestion)session.getAttribute("ques");
Set<String> options=securityQuestion.getOptions();

String imgurl=securityQuestion.getImageUrl();

%>
<body class="light-grey">
  <div class="container-fluid">
  <div class="row">
    <div class="col-sm-1"></div>
    <div class="col-sm-10 float-right text-right">
      <a href="AdminOptions.jsp"><img src="images/icons/home-blue.png"></a>

      <a href="edit?questionId=<%=securityQuestion.getQuestionId()%>"><img src="images/icons/edit-blue.png"></a>

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
                    <p>Do you want to delete this quetion now ?</p>
                </div>
            </div>

            <!--Footer-->
            <div class="modal-footer justify-content-center">
                <a type="button" class="btn btn-outline-primary waves-effect" href="delete?questionId=<%=securityQuestion.getQuestionId()%>">Yes</a>
                <a type="button" class="btn btn-outline-primary waves-effect" data-dismiss="modal">No, thanks</a>
            </div>
        </div>
        <!--/.Content-->
    </div>
</div>

<!-- Central Modal Medium Info -->

  <div class="row">
    <div class="col-sm-12 text-center question">
      <h3><%=securityQuestion.getQuestion()%></h3>
    </div>
  </div>
  <div class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-6 text-center question-image">
      <img src="<%=imgurl%>">
    </div>
    <div class="col-lg-5 option-answer">
      <div class="row options">
      <h5>Options</h5>
      <ul>
        <%for(String option:options) {%>
        <li><p><%=option%></p></li>
        <%}%>
      </ul>
      </div>
      <div class="row answer">
        <h5>Answer</h5>
        <ul>
        <li><%=securityQuestion.getAnswer()%></li>
      </ul>
      </div>        
      </div>
    </div>
  </div>

  
<script>
$("#sideModalTLInfo").on('shown.bs.modal');
</script>


</body>
</html>