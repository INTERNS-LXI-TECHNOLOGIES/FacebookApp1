<!--Author :neeraja admin crud operations-->

<!--Author :neeraja admin crud operations-->

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


	<!-- Search form -->
	<<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-10 text-centre">
				<form class="form-inline md-form form-sm active-cyan active-cyan-2" action="search" method="GET">
				    <i class="fa fa-search" aria-hidden="true"></i>
				    <input class="form-control form-control-sm ml-3 w-75" type="text" placeholder="Search by id" name="questionId" aria-label="Search">
				</form>
			</div>
		</div>
		<div class="row">
		<div class="col-sm-1"></div>
			<div class="col-sm-5">
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
		<div class="col-sm-5">
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
				    <h4 class="card-title">Have we enough questions?</h4>
				    <!-- Text -->
				    <p class="card-text">Get a detailed view of questions and their answers</p>
				    <!-- Button -->
				    <a href="addQuestion" class="btn btn-primary">View questions</a>

				  </div>

				</div>
		<!-- Card -->
		</div>
	</div>
	</div>
</body>
</html>