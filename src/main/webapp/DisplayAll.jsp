


<!DOCTYPE html>
<head>
  <title>DisplayAll</title>
  <link rel="stylesheet" type="text/css" href="css/admin.css">

    <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <!-- Bootstrap core CSS -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
  <!-- Material Design Bootstrap -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.4/css/mdb.min.css" rel="stylesheet">

  <link rel="stylesheet" type="text/css" href="bootstrap.css">
  <link rel="stylesheet" type="text/css" href="mystyle.css">
  <link rel="stylesheet" type="text/css" href="Sample.css">
</head>
<body>


<div id="add">

<p align="left">
<a href="AdminOptions.jsp"><img src="images/icons/home.jpg" width="50" height="50"></a></br></br>

<style>
.button{
	background-color:cornflowerblue;
	color:white;
}
.button:hover{
	background-color:green;
}

input[type=text] {
    width: 100%;
    padding: 12px 20px;
    margin: 10px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}
table, th, td {
    border: 1px solid black;
}

</style>
</p>
</div>
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
  <div class="row">
    <div class="col-sm-2"></div>
  <div class="col-sm-8">
  <table id="dtMaterialDesignExample" class="table table-striped" cellspacing="0" width="100%">
  <thead>
    <tr>
      <th class="th-sm">QuestionId
        <i class="fa fa-sort float-right" aria-hidden="true"></i>
      </th>
      <th class="th-sm">Question
        <i class="fa fa-sort float-right" aria-hidden="true"></i>
      </th>
      <th class="th-sm">Answer
        <i class="fa fa-sort float-right" aria-hidden="true"></i>
      </th>
      
    </tr>
  </thead>
  <tbody>

    <% for(SecurityQuestion secQuestion:secQuestions)
   { %>

    <tr>
      <td><%=secQuestion.getQuestionId()%></td>
      <td><a href="search?questionId=<%=secQuestion.getQuestionId()%>"><%=secQuestion.getQuestion()%></a></td>
      <td><%=secQuestion.getAnswer()%></td>
      
    </tr>
    
  </tbody>

  <%}%>
  
</table></br>
</div>
</div>


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
  


</html>