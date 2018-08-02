<!DOCTYPE html>
<head>
	<title>question</title>
	<link rel="stylesheet" type="text/css" href="css\way_out.css">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
	<!-- Font Awesome -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<!-- Bootstrap core CSS -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
	<!-- Material Design Bootstrap -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.4/css/mdb.min.css" rel="stylesheet">

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="js/jQuery.countdownTimer.min.js"></script>
	<script src="js/jQuery.countdownTimer.js"></script>
	<script src="js/wayout.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8">
</head>
<%@ page import="com.lxisoft.wayout.model.Game,java.util.*,com.lxisoft.wayout.domain.*"%>

<% 
	Game model= (Game)session.getAttribute("model"); //model object of this page
	List<Door> doors= model.getPrisoner().getCurrentLocation().getDoors();
	List<SuperKey> superKeys= model.getPrisoner().getSuperKeys();
	Door door=null;

		for (Door d:doors) {
			if(d.getDoorId()==Long.parseLong(request.getParameter("doorId")))
				door=d;
		}

		Set<String> options=door.getSecurityQuestion().getOptions();
		String question="See the below image";
		if(door.getSecurityQuestion().getQuestion()!=null)
			question=door.getSecurityQuestion().getQuestion();
	
%>
<body class="question-container" onload='start(<%=request.getParameter("doorId")%>)'>


	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10 question text-center"><p><%=question%></p></div>
			<div class="col-sm-1 text-center"></div>
		</div>
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-7 question-image text-center"><img src="<%=door.getSecurityQuestion().getImageUrl()%>"></div>
			<div class="col-sm-3 options text-center">
				<div class="row">
			<div class="question-timer"><p id="question-timer"></p></div>
				</div>
				<div class="row">
				<form class="question-form" method="POST" action="play">
				<!-- Group of default radios - option 2 -->
				<%
				int i=1; 
				for(String option:options){%>
				<div class="custom-control custom-radio">
				  <input type="radio" class="custom-control-input" id="defaultGroupExample<%=i%>" value="<%=option%>" name="option">
				  <label class="custom-control-label option-color" for="defaultGroupExample<%=i++%>"><%=option%></label>
				</div>
				<%}%>
 				<input type="hidden" value="<%=door.getDoorId()%>" name="doorId">
				<input type="submit" class="go-ahead" name="submit" value="submit">
				</form>
			</div>
		</div>
		</div>
		</div>
		
</body>
</html>