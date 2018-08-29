<!DOCTYPE html>
<head>
	<title>Home</title>

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


	<!-- Search form -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8 text-centre">
				<form class="form-inline md-form form-sm active-cyan active-cyan-2" action="search" method="GET">
				    <i class="fa fa-search" aria-hidden="true"></i>
				    <input class="form-control form-control-sm ml-3 w-75" type="text" name="questionId" placeholder="Search by id" aria-label="Search">
				</form>
			</div>
		</div>
		<p align="right">
		<%@ page import="java.util.*,com.lxisoft.wayout.web.*,com.lxisoft.wayout.model.*,com.lxisoft.wayout.domain.*,java.sql.*,java.util.*"%>
		<%String username=request.getRemoteUser();	%>
		

		<a href="addUser?username=<%=request.getRemoteUser()%>"><img src="images/icons/profile.jpg" width="50" height="50"></a></br></br>
		</p>
		<p align="left">
			<form action="addUser.jsp" method="post">
				<input type="submit" value="Add new user">
			</form> 
	</p>
		<div class="row">
		<div class="col-lg-1"></div>
			<div class="col-lg-5">
				<!-- Card -->
				<div class="card">

				  <!-- Card image -->
				  <div class="view overlay">
				    <img class="card-img-top" src="images/question-view.jpg" alt="Card image cap">
				    <a href="AddQuestion.jsp">
				      <div class="mask rgba-white-slight"></div>
				    </a>
				  </div>

				  <!-- Card content -->
				  <div class="card-body">

				    <!-- Title -->
				    <h4 class="card-title">More questions</h4>
				    <!-- Text -->
				    <p class="card-text">Find intelligent questions and have it in your database</p>
				    <!-- Button -->
				    <a href="AddQuestion.jsp" class="btn btn-primary">Add question</a>

				  </div>

				</div>
		<!-- Card -->
		</div>
		<div class="col-lg-5">
				<!-- Card -->
				<div class="card">

				  <!-- Card image -->
				  <div class="view overlay">
				    <img class="card-img-top" src="images/question-view.jpg" alt="Card image cap">
				    <a href="addQuestion">
				      <div class="mask rgba-white-slight"></div>
				    </a>
				  </div>

				  <!-- Card content -->
				  <div class="card-body">

				    <!-- Title -->
				    <h4 class="card-title">Take a look</h4>
				    <!-- Text -->
				    <p class="card-text">Get a detailed view of questions and their answers from the database</p>
				    <!-- Button -->
				    <a href="addQuestion" class="btn btn-primary">View questions</a>

				  </div>

				</div>
		<!-- Card -->
		<form action="admin" method="post">
			<input type="submit" value="Users Configuration">
		</form>
		</div>
		<div class="col-lg-1"></div>
	</div>
	</div>
	
</body>
</html>