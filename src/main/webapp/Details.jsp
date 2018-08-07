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

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <!-- JQuery -->
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.13.0/umd/popper.min.js"></script>
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/js/bootstrap.min.js"></script>
  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.8/js/mdb.min.js"></script>

</head>
<body>

<%@ page import="java.util.*,com.lxisoft.wayout.web.*,com.lxisoft.wayout.model.*,com.lxisoft.wayout.domain.*,java.sql.*,java.util.*"%>
<%
SecurityQuestion securityQuestion=(SecurityQuestion)session.getAttribute("ques");
Set<String> options=securityQuestion.getOptions();

String imgurl=securityQuestion.getImageUrl();

%>


<!-- Card Light -->
  <div class="row">
		<div class="col-sm-1"></div>
			<div class="col-sm-8">
				
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

			    <div class="col-sm-3">
                      
                      <div class="row">
                           <div class="col-sm-12"><a href="AdminOptions.jsp"><img src="images/icons/home.jpg" width="90" height="90"></a></div>
                      </div>
                      
                      <div class="row">

                            <div class="col-sm-12"><a href="edit?questionId=<%=securityQuestion.getQuestionId()%>"><img src="images/icons/edit3.jpg" width="90" height="90" title=editContact></a></div>

                      </div>

                      <div class="row">

                           <div class="col-sm-12">
                           <span class="table-remove"><a href="" data-toggle="modal" data-target="#sideModalTLInfo"><img src="images/icons/remove1.jpg" width="90" height="90" title=deleteContact></a>
                           </span></div>

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

                 


<script>
$("#sideModalTLInfo").on('shown.bs.modal');
</script>

   

	
</body>
</html>