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

public class AddQuestionServlet extends HttpServlet{

	/**
     *  creating the object of security Question to set the questions and answer 
     *
     */

    SecurityQuestion securityQuestion=new SecurityQuestion();

    /**
     *  creating the object of security Question implementation 
     *
     */

    SecurityQuestionServiceImpl securityQuestionServiceImpl= new SecurityQuestionServiceImpl();



	/**
     *  setting logger 
     *
     */
 	static Logger logger=Logger.getLogger(AddQuestionServlet.class.getName());


 	/**
	 * 
	 * @param request
	 * httpRequest
	 *    
	 * @param response
	 * httpResponse
	 */

 	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{


 		logger.info("entering the method");
 		try{

 			logger.info("Hello this is an info message");
			

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

			request.getSession().setAttribute("question",questions);
			response.sendRedirect("DisplayAll.jsp");


 		}
 		catch(Exception e){
 			e.printStackTrace();

 		}



 	}
 }


