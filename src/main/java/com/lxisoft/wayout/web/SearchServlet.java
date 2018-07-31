package com.lxisoft.wayout.web;
import com.lxisoft.wayout.domain.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;
import java.sql.*;
import java.util.logging.*;
import org.apache.log4j.Logger;
import javax.naming.*;
import java.util.*;
import com.lxisoft.wayout.service.impl.*;
import com.lxisoft.wayout.service.*;

/**
*@author Neeraja
*servlet class to search questions
*
*@version 1.0
*
*/

public class SearchServlet extends HttpServlet{

	/**
     *  creating the object of security Question implementation 
     *
     */

   // SecurityQuestionServiceImpl securityQuestionServiceImpl= new SecurityQuestionServiceImpl();


public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{
	String sid=request.getParameter("questionId");
	Long id=Long.parseLong(sid);

	//SecurityQuestion question=securityQuestionServiceImpl.findSecurityQuestion(id);
	//request.getSession().setAttribute("ques",question);

	response.sendRedirect("Details.jsp");


}




}