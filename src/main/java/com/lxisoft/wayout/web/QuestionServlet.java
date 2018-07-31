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
/**
*@author Neeraja
*servlet class to add questions
*
*@version 1.0
*
*/ 

public class QuestionServlet extends HttpServlet{

	
	 /**
       * Reference to SwcurityQuestion class
       */


    SecurityQuestion securityQuestion=new SecurityQuestion();

     /**
       * Reference to SecuritQuestionimpl class
       */

    SecurityQuestionServiceImpl securityQuestionServiceImpl= new SecurityQuestionServiceImpl();



	 /**
       * Reference to Logger class to get log messages
       */
 	static Logger logger=Logger.getLogger(QuestionServlet.class.getName());


 	/**
	 * 
	 * Method for adding Questions
	 *
	 * @param request
	 *        httpRequest
	 *    
	 * @param response
	 *         httpResponse
	 *
	 * @throws IOException
	 *          if IOException occurs
	 *
	 * @throws ServletException 
	 *           if Undesired condition occurs 
	 */

 	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{


 		logger.info("entering the method");
 		try{

 			logger.info(">>>>>>>>>>entering the  try block");
			

			String question=request.getParameter("question");
			String option1=request.getParameter("option1");
			String option2=request.getParameter("option2");
			String option3=request.getParameter("option3");
			
			String answer=request.getParameter("answer");

			

			securityQuestion.setQuestion(question);
			Set<String> options= new TreeSet<String>();
			options.add(option1);
			options.add(option2);
			options.add(option3);
			
			securityQuestion.setOptions(options);
			securityQuestion.setAnswer(answer);

			securityQuestionServiceImpl.addSecurityQuestion(securityQuestion);
			response.sendRedirect("RedirectingPage.jsp");



 		}
 		catch(Exception e){
 			e.printStackTrace();

 		}



 	}

 	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{
 		try{

 			

			Set<SecurityQuestion> questions=securityQuestionServiceImpl.findAllSecurityQuestion();

			//request.getSession().setAttribute("PageImport",questions);
			response.sendRedirect("DisplayAll.jsp");


 		}
 		catch(Exception e){
 			e.printStackTrace();

 		}



 	}
 }


