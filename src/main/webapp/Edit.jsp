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
  
  <link rel="stylesheet" type="text/css" href="css/admin.css">
  </head>
  <body>

<%@ page import= "com.lxisoft.wayout.domain.*,com.lxisoft.wayout.web.*,java.util.*"%>

<% SecurityQuestion securityQuestion=(SecurityQuestion)request.getSession().getAttribute("question");
    
   String imageUrl=securityQuestion.getImageUrl();
   String question=securityQuestion.getQuestion();
   

%>

<!-- Material form login -->
<div class="row">
      <div class="col-sm-3"></div>
      <div class="col-sm-6 text-centre"> 
<div class="card">
     
           <h5 class="card-header info-color white-text text-center py-4">
           <strong>Edit Form</strong>
           </h5>

  <!--Card content-->
  <div class="card-body px-lg-5 pt-0">

    <!-- Form -->
    <form class="text-center" style="color: #757575;" action="edit" method="post">

     <!-- ImageUrl -->

      <div class="md-form">
        

        ImageUrl</br></br>
        <input type="text" id="materialLoginForm" class="form-control" value="<%=imageUrl%>" name="imageUrl" required>
        
      </div> 

      <label class="btn-bs-file btn btn-info">
                Browse question image
                <input type="file" name="image" accept="image/*">
      </label>

      <!-- Question -->

      <div class="md-form">

         Question</br></br>
         <input type="text" id="materialLoginForm" class="form-control"  value="<%=question%>" name="question" required>
        
      </div>


      <% 
        int noOfOptions=securityQuestion.getOptions().size();
        int count=0;
        for( String option:securityQuestion.getOptions())
        {
            count++;
            String optionName="option"+count;
           
      %>

      <!-- Options-->

      <div class="md-form">
         
         <%=optionName%></br></br>
         <input type="text" id="materialLoginForm" class="form-control"  value="<%=option%>" name="optionName" required>
        
      </div>       
     
      <%
        }
        String answer=securityQuestion.getAnswer();
        long id=securityQuestion.getQuestionId();
      %>

      <!-- Answer-->

      <div class="md-form">
         Answer</br></br>
         <input type="text" id="materialLoginForm" class="form-control"  value="<%=answer %>" name="answer" required>
        
      </div> 

       <input type="hidden" value="<%=id%>" name="questionId"></br> 

       

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
  


   
    

  

