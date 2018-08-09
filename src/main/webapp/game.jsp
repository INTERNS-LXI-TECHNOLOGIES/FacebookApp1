<!DOCTYPE html>
<head>
	<title>game</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
	<script src="js/my-countdownTimer.js"></script>
	<script src="js/wayout.js"></script>
	<script src="js/bxslider-initializer.js"></script>
	<link rel="stylesheet" type="text/css" href="css\way_out.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8">
</head>
<%@ page import="com.lxisoft.wayout.model.Game,java.util.*,com.lxisoft.wayout.domain.*"%>

<% 
	Game model= (Game)session.getAttribute("model"); //model object of this page
	List<Door> doors= model.getPrisoner().getCurrentLocation().getDoors();
	List<SuperKey> superKeys= model.getPrisoner().getSuperKeys();
	String hallName= "Hall "+(model.getPrisoner().getCurrentLocation().getHallId()+1);
%>

<body class="game-body">
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-8 timer-warning text-center"><p>Click on below image to open door</p></div>
			<div class="col-sm-2 text-center">
				<div class="game-timer text-center">
					<p id="timer"></p>
				</div>
			</div>
		</div>
		<div class="row margin-top">
			<!-- for loop -->
			<div class="col-sm-2">
			</div>
			<div class="col-sm-8">
				<div class="bxslider">
					<%
						String pictureName;
						if(doors!=null) {

							for(Door door: doors)
							{
								pictureName=(door.isOpen())?"images/doors/room-modified-open.jpg":"images/doors/room-modified.jpg";
						
								if(door.isAccessDenied()) {%>
								  <div>
									 <div>
										<a href="play?doorId=<%=door.getDoorId()%>&isAccessDenied=true"><img src="images/key-icon1.png" class="img-responsive super-key float-right" alt="key"></a>
							  			<p class="float-right key-number"><%=model.getNumberOfKeys()%></p>
							  			<p class="text-center hall-name"><%=hallName+":door "+(door.getDoorId()+1)%></p>
									</div>
								  	<img src="<%=pictureName%>" onclick="noAccess()" id="div-image" title="Door with id =<%=door.getDoorId()%>"></div>
								<%}
								else if(door.getOpeningHall()==null) {%>
								  <div>
								  	<div>
										<a href="play?doorId=<%=door.getDoorId()%>"><img src="images/key-icon1.png" class="img-responsive super-key float-right" alt="key"></a>
							  			<p class="float-right key-number"><%=model.getNumberOfKeys()%></p>
							  			<p class="text-center hall-name"><%=hallName+":door "+(door.getDoorId()+1)%></p>
									</div>
								  	<img src="<%=pictureName%>" onclick="noOpen()" id="div-image" title="Door with id =<%=door.getDoorId()%>"></div>
								<%}
								else if(door.isOpen()) {%>
								  <div>
								  	<div>
										<a href="play?doorId=<%=door.getDoorId()%>"><img src="images/key-icon1.png" class="img-responsive super-key float-right" alt="key"></a>
							  			<p class="float-right key-number"><%=model.getNumberOfKeys()%></p>
							  			<p class="text-center hall-name"><%=hallName+":door "+(door.getDoorId()+1)%></p>
									</div>
								  	<img src="<%=pictureName%>" onclick="window.location='play?doorId=<%=door.getDoorId()%>'" id="div-image" title="Door with id =<%=door.getDoorId()%>"></div>
								<%}
								else {%>
								  <div>
								  	<div>
										<a href="play?doorId=<%=door.getDoorId()%>"><img src="images/key-icon1.png" class="img-responsive super-key float-right" alt="key"></a>
							  			<p class="float-right key-number"><%=model.getNumberOfKeys()%></p>
							  			<p class="text-center hall-name"><%=hallName+":door "+(door.getDoorId()+1)%></p>
									</div>
								  	<img src="<%=pictureName%>" id="div-image" onclick="popupWarningWindow(<%=door.getDoorId()%>)"></div>
								<%}
							 }
						 }
						 if(doors==null){%>

					 		<div>
							  	<div>
						  			<p class="text-center hall-name"><%=hallName%>:no doors</p>
								</div>
							  	<img src="images/no-door.png" id="div-image"></div>

						<%}	 
						 if(model.getPrisoner().getCurrentLocation().getBackDoor()!=null) {%>

						  <div>
								<div>
									<a href="play?doorId=<%=model.getPrisoner().getCurrentLocation().getBackDoor().getDoorId()%>"><img src="images/key-icon1.png" class="img-responsive super-key float-right" alt="key"></a>
						  			<p class="float-right key-number"><%=model.getNumberOfKeys()%></p>
						  			<p class="text-center hall-name"><%=hallName+":door "+(model.getPrisoner().getCurrentLocation().getBackDoor().getDoorId()+1)%></p>
								</div>
						  	<img src="images/doors/room-modified-open.jpg" id="div-image" onclick="window.location='play?doorId=<%=model.getPrisoner().getCurrentLocation().getBackDoor().getDoorId()%>'" title="<%=model.getPrisoner().getCurrentLocation().getBackDoor().getDoorId()%>"></div>
						  <%}%>
				</div>
			</div>
		</div>
		<div id="warning-message" class="full">
		<div class="warning text-center animate-zoom">
			<h3>Warning!</h3>
			<h5>The door you trying to open may be permanently locked</h5>
			<h4>Use the superkeys if you have. Else try an attempt</h4>
			<input type="button" onclick="redirect()" class="go-ahead float-right" name="go ahead" value="go ahead">
			<input type="button" onclick="document.getElementById('warning-message').style.display='none'" class="go-ahead float-right" name="go ahead" value="cancel">
		</div>
		</div>
		<div id="warning" class="full">
		<div class="warning text-center animate-zoom">
			<h3>Warning!</h3>
			<h5>Access denied</h5>
			<input type="button" onclick="document.getElementById('warning').style.display='none'" class="go-ahead float-right" name="go ahead" value="close">
		</div>
		</div>
		<div id="no-hall" class="full">
		<div class="warning text-center animate-zoom">
			<h3>Warning!</h3>
			<h5>No opening hall</h5>
			<input type="button" onclick="document.getElementById('no-hall').style.display='none'" class="go-ahead float-right" name="go ahead" value="close">
		</div>
		</div>

<!-- 		<audio id="myAudio">
		  <source src="horse.ogg" type="audio/ogg">
		  <source src="horse.mp3" type="audio/mpeg">
		  Your browser does not support the audio element.
		</audio> -->
</body>
</html>