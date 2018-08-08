
<!DOCTYPE html>
<head>
  <title>DisplayAll</title>
 
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
  
  <script src="js/editPopup.js"></script>

  <link rel="stylesheet" type="text/css" href="bootstrap.css">
  <link rel="stylesheet" type="text/css" href="mystyle.css">
  <link rel="stylesheet" type="text/css" href="Sample.css">
</head>
<body>



<%@ page import="com.lxisoft.wayout.web.*,com.lxisoft.wayout.domain.*,com.lxisoft.wayout.model.*,java.sql.*,java.util.*"%>

<%


QuestionsView questionsView=(QuestionsView)session.getAttribute("questionsView");


String pageNo=request.getParameter("link");

      if(pageNo!=null)
        questionsView.setCurrentPageNo(Integer.parseInt(pageNo));

      int currentPageNo=questionsView.getCurrentPageNo();
      
      int lastPageNo=questionsView.getLastPageNo();


      List<SecurityQuestion> securityQuestionList=new ArrayList<SecurityQuestion>(new TreeSet<SecurityQuestion>(questionsView.getSecurityQuestionSet()));

      Set<SecurityQuestion> secQuestions=new TreeSet<SecurityQuestion>();

      if(currentPageNo!=lastPageNo || ((securityQuestionList.size())%5)==0)
      {
      for (int i=(currentPageNo-1)*5;i<((currentPageNo-1)*5)+5 ;i++ ) {
        
          secQuestions.add(securityQuestionList.get(i));
      }
      }

      else
      {
        for (int i=(currentPageNo-1)*5;i<(((currentPageNo-1)*5)+((securityQuestionList.size())%5)) ;i++ ) {
        
          secQuestions.add(securityQuestionList.get(i));
      } 
      }

%>

<!-- Editable table -->
<div class="card">
    <div class="col-sm-2"></div>
  <div class="col-sm-12">
    <h3 class="card-header text-center font-weight-bold text-uppercase py-4">Questions</h3>
    <div class="card-body">
        <div id="table" class="table-editable">
            <span class="table-add float-right mb-3 mr-2"><a href="AdminOptions.jsp"><img src="images/icons/back.jpg" width="10" height="10" class="text-success">
            </a></span>
            <table class="table table-bordered table-responsive-md table-striped text-center">
                <tr>
                    <th class="text-center">QuestionId</th>
                    <th class="text-center">ImagrUrl</th>
                    <th class="text-center">Question</th>
                    <th class="text-center">Answer</th>                    
                    <th class="text-center">Edit</th>   
                    <th class="text-center">Remove</th>
                </tr>
  
    <% for(SecurityQuestion secQuestion:secQuestions)
   { %>

                <tr>
                    <td class="pt-3-half" contenteditable="false"><%=secQuestion.getQuestionId()%></td>
                    <td class="pt-3-half" contenteditable="false"><%=secQuestion.getImageUrl()%></td>
                    <td class="pt-3-half" contenteditable="false"><a href="search?questionId=<%=secQuestion.getQuestionId()%>"><%=secQuestion.getQuestion()%></a></td>
                    <td class="pt-3-half" contenteditable="false"><%=secQuestion.getAnswer()%></td>                    
                    
                    <td>
                        <span class="table-remove"><button type="button" <a href="edit?questionId=<%=secQuestion.getQuestionId()%>" class="btn btn-default btn-rounded">Edit</a></button></span>
                    </td>

                    
                    <!-- Button trigger modal -->
                     <td>
                     <span class="table-remove"><button type="button" <a href="" class="btn btn-default btn-rounded" data-toggle="modal" data-target="#sideModalTLInfo">Remove</a></button></span>
                     </td>


                </tr>  

         



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
                <a type="button" class="btn btn-outline-primary waves-effect" href="delete?questionId=<%=secQuestion.getQuestionId()%>">Yes</a>
                <a type="button" class="btn btn-outline-primary waves-effect" data-dismiss="modal">No, thanks</a>
            </div>
        </div>
        <!--/.Content-->
    </div>
</div>

<!-- Central Modal Medium Info -->

<%}%>

</table>
         </br>
         </br>
        </div>
    </div>
</div>
<!-- Editable table -->

<div class="text-center">
      <ul class="my-pagination">
      
      <%if((currentPageNo>=1) && (lastPageNo!=1)){%>
      <%if(currentPageNo!=1){%>
      <li><a href="DisplayAll.jsp?link=<%out.println(currentPageNo-1);%>"><</a></li><%}%>
      <%if(currentPageNo!=1){%>
      <li><a href="DisplayAll.jsp?link=1">1</a></li><%}%>
      <%if((currentPageNo-2)>=3){%>
      <li>..</li><%}%>
      <%if((currentPageNo-2)>1){%>
      <li><a href="DisplayAll.jsp?link=<%out.println(currentPageNo-2);%>"><%out.println(currentPageNo-2);%></a></li><%}%>
      <%if((currentPageNo-1)>1){%>
      <li><a href="DisplayAll.jsp?link=<%out.println(currentPageNo-1);%>"><%out.println(currentPageNo-1);%></a></li><%}%>
      <li><a class="active" href="DisplayAll.jsp?link=<%out.println(currentPageNo);%>"><%out.println(currentPageNo);%></a></li>
      <%if((currentPageNo+1)<=lastPageNo){%>
      <li><a href="DisplayAll.jsp?link=<%out.println(currentPageNo+1);%>"><%out.println(currentPageNo+1);%></a></li><%}%>
      <%if((currentPageNo+2)<=lastPageNo){%>
      <li><a href="DisplayAll.jsp?link=<%out.println(currentPageNo+2);%>"><%out.println(currentPageNo+2);%></a></li><%}%>
      <%if((currentPageNo+2)<=lastPageNo){%>
      <li>..</li><%}%>
      <%if(currentPageNo!=lastPageNo){%>
      <li><a href="DisplayAll.jsp?link=<%out.println(currentPageNo+1);%>">></a></li><%}%>
      <%}%>

    </ul>
    </div>
    </div>
  
<script>
$("#sideModalTLInfo").on('shown.bs.modal');
</script>

</body>

</html>