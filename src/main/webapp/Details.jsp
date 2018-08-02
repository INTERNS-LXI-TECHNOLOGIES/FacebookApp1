<html>
<!--contacts app-->

<!DOCTYPE html>
<head>
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="css/admin.css">

		<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
	<!-- Font Awesome -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<!-- Bootstrap core CSS -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
	<!-- Material Design Bootstrap -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.4/css/mdb.min.css" rel="stylesheet">
</head>
<body>
<style>
	body
	{
		background-color:White;
	}
	
	input[type=text] {
    width: 100%;
    padding: 12px 20px;
    margin: 10px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}
	
	
</style>
			

<body>

<%@ page import="java.util.*,com.lxisoft.wayout.web.*,com.lxisoft.wayout.model.*,com.lxisoft.wayout.domain.*,java.sql.*,java.util.*"%>
<%
SecurityQuestion securityQuestion=(SecurityQuestion)session.getAttribute("ques");
Set<String> options=securityQuestion.getOptions();

String imgurl=securityQuestion.getImageUrl();

%>

<p align="right">
<a href="AdminOptions.jsp"><img src="images/icons/home.jpg" width="90" height="90"></a></br></br>
<a href="edit?questionId=<%=securityQuestion.getQuestionId()%>"><img src="images/icons/edit3.jpg" width="90" height="90" title=editContact></a></br></br>
<a href="delete?questionId=<%=securityQuestion.getQuestionId()%>"><img src="images/icons/remove1.jpg" width="90" height="90" title=deleteContact></a></br></br>
</p>



<!-- Card Light -->
  <div class="row">
		<div class="col-sm-2"></div>
			<div class="col-sm-5">
   <div class="card">

  <!-- Card image -->
  <div class="view overlay">
    <img class="card-img-top" src="<%=imgurl%>" alt="Card image cap">
    <a>
      <div class="mask rgba-white-slight"></div>
    </a>
  </div>

  <!-- Card content -->
  <div class="card-body">

    
    <!-- Title -->
    <h4 class="card-title">Details</h4>
    <hr>
    <!-- Text -->
    <p class="card-text"><%
	out.println(""+securityQuestion.getQuestion());%></br></br>
	<%for(String option:options)
		out.println(option);%></br></br>

	<%out.println(""+securityQuestion.getAnswer());%></br></br></p>
    <!-- Link -->
    <a href="#!" class="black-text d-flex justify-content-end"><h5>Read more <i class="fa fa-angle-double-right"></i></h5></a>

  </div>

</div>
<!-- Card Light -->
</div>
</div>

	
</body>
</html>