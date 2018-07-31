</html>
<head>
<title>Display all Question</title>
	<link rel="stylesheet" type="text/css" href="Sample.css">
</head>
<div id="add">
<center><h1> Question</h1></center>
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
<%@ page import="com.lxisoft.wayout.web.*,com.lxisoft.wayout.domain.*,java.sql.*,java.util.*,com.lxisoft.wayout.model.pageNavigator"%>

<%
Set<SecurityQuestion> secQuestions=(Set<SecurityQuestion>)session.getAttribute("question");
//Set<SecurityQuestion> secQuestions=Set<SecurityQuestion>)session.getAttribute("PageImport");
%>
<table style="width:100%">
<caption>Questions</caption>
    <tr>
        <th>questionId</th>
        <th>question</th>
        <th>answer</th>
    </tr>
    <tr>
   <% for(SecurityQuestion secQuestion:secQuestions){%>
      <td><center><%out.println(secQuestion.getQuestionId());%></center></td>
      <td>  <center> <a href="search?questionId=<%=secQuestion.getQuestionId()%>"><%out.println(secQuestion.getQuestion());%></a></center></td>
       <td><center><%out.println(secQuestion.getAnswer());%></center></td>
   </tr>
</table>
<%
}

%>

  <div class="contact_container">
     
    <%

      String pageNo=request.getParameter("link");

      if(pageNo!=null)
        PageNavigator.setCurrentPageNo(Integer.parseInt(pageNo));

      if((ContactController.isSetCreated())==false)
      {
        ContactController.initializeContactSet();
      }
      
      int currentPageNo=PageNavigator.getCurrentPageNo();
      int lastPa0geNo=PageNavigator.getLastPageNo();

      List<Contact> contactList=new ArrayList<Contact>(new TreeSet<Contact>(ContactController.getContactSet()));

      Set<Contact> contactSet=new TreeSet<Contact>();

      if(currentPageNo!=lastPageNo || ((contactList.size())%5)==0)
      {
      for (int i=(currentPageNo-1)*5;i<currentPageNo+4 ;i++ ) {
        
          contactSet.add(contactList.get(i));
      }
      }

      else
      {
        for (int i=(currentPageNo-1)*5;i<(((currentPageNo-1)*5)+((contactList.size())%5)) ;i++ ) {
        
          contactSet.add(contactList.get(i));
      } 
      }

      for(Contact contact:contactSet)
      {%>
      <div class="row individual_contact_row">
      <div class="col-sm-8 individual_contact">
      <img class="individual_contact_icon" src="Images\contact_1.png" alt="contact_picture"><p><a href="contact_details.jsp?link=<%out.println(contact.getPhNo());%>"><% out.println(contact); %></a></p>
      </div>
      <div class="col-sm-4 text-center">
        <a href="edit_contact.jsp?link=<%out.println(contact.getPhNo());%>"><span title="Edit"><img class="align" src="Images\edit_1.png" title=""></span></a>
        <a href="confirmation.jsp?link=<%out.println(contact.getPhNo());%>"><span title="Delete"><img class="align" src="Images\delete_3.png" title=""></span></a>
      </div>
      </div> 
    <%}%>

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
      <li><a class="active" href="index.jsp?link=<%out.println(currentPageNo);%>"><%out.println(currentPageNo);%></a></li>
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