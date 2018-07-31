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

public class DeleteController extends HttpServlet{
	/**
     *  creating the object of security Question to set the questions and answer 
     *
     */

    SecurityQuestion securityQuestion=new SecurityQuestion();

    /**
       * Reference to Service class
       */

    SecurityQuestionServiceImpl securityQuestionServiceImpl= new SecurityQuestionServiceImpl();
    /**
       * Reference to Logger class to get log messages
       */
	
	static Logger logger=Logger.getLogger(AddQuestionController.class.getName());
	
	public void doGet(HttpServletRequest request, HttpServletResponse response ){
		
		try{
		String sId=request.getParameter("questionId");
		long questionId=Long.parseLong(sId);

		SecurityQuestion question=securityQuestionServiceImpl.findSecurityQuestion(questionId);
		securityQuestionServiceImpl.deleteSecurityQuestion(question);

		
		response.sendRedirect("AdminOptions.jsp");

		}
		catch(Exception e){
	 			e.printStackTrace();

	 	}




	}
		
	}

