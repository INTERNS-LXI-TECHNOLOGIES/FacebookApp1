package com.lxisoft.wayout.web;

// Import required java libraries
import com.lxisoft.wayout.domain.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.sql.*;
import java.sql.*;
import java.util.logging.*;
import org.apache.log4j.Logger;
import javax.naming.*;
import com.lxisoft.wayout.service.impl.*;
import com.lxisoft.wayout.service.*;
import java.util.*;

/**
*@author Neeraja
*servlet class to search questions
*
*@version 1.0
*
*/

// Extend HttpServlet class

public class QuestionDeleteServlet extends HttpServlet{
	/**
     *  creating the object of security Question to set the questions and answer 
     *
     */

    SecurityQuestion securityQuestion=new SecurityQuestion();

    /**
       * Reference to Service implementation class
       */

    SecurityQuestionServiceImpl securityQuestionServiceImpl= new SecurityQuestionServiceImpl();
    /**
       * Reference to Logger class to get log messages
       */
	
	static Logger logger=Logger.getLogger(QuestionDeleteServlet.class.getName());
	/**
	 * 
	 * Method for deleting Questions
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
	public void doGet(HttpServletRequest request, HttpServletResponse response )throws IOException, ServletException{
		
		try{
			logger.info("entering the try block of the delete method");
		String sId=request.getParameter("questionId");
		long questionId=Long.parseLong(sId);

		SecurityQuestion question=securityQuestionServiceImpl.findSecurityQuestion(questionId);
		securityQuestionServiceImpl.deleteSecurityQuestion(question);

		request.getSession().setAttribute("question",question);
		response.sendRedirect("done.jsp");
		logger.info("exiting the try block of the delete method");
		}
		catch(Exception e){
	 			e.printStackTrace();

	 	}




	}
		
	}

