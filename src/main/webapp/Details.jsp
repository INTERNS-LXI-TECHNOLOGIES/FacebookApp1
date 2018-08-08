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
      <a href="delete?questionId=<%=securityQuestion.getQuestionId()%>"><img src="images/icons/delete-blue1.png"></a>
    </div>
  </div>
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
</body>