package com.lxisoft.wayout.web;
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
*servlet class to edit questions
*
*@version 1.0
*
*/

public class QuestionEditServlet extends HttpServlet{
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
	
	static Logger logger=Logger.getLogger(QuestionEditServlet.class.getName());
	
	/**
	 * 
	 * Method for getting only a single Question 
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
		logger.info("entering the doget method to get a single question to edit");
		try{
			logger.info(">>>>>>>>>>entering the  try block of edit servlet");
		String sId=request.getParameter("questionId");
		long questionId=Long.parseLong(sId);


		SecurityQuestion question=securityQuestionServiceImpl.findSecurityQuestion(questionId);
		request.getSession().setAttribute("question",question);
		response.sendRedirect("Edit.jsp");

		logger.info(">>>>>>>>>>exiting the  try block of the method to get the single questionto edit");
		}
		catch(Exception e){
	 			e.printStackTrace();

	 	}




	}

	/**
	 * 
	 * Method for editing the Question 
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

	public void doPost(HttpServletRequest request, HttpServletResponse response )throws IOException, ServletException{
				logger.info(">>>>>>>>>>entering the  try block of edit servlet");
		try{

		String sId=request.getParameter("questionId");
		long questionId=Long.parseLong(sId);
		String question=request.getParameter("quetion");
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



		securityQuestionServiceImpl.updateSecurityQuestion(securityQuestion);
		response.sendRedirect("AdminOtions.jsp");
				logger.info(">>>>>>>>>>exiting the  try block of edit servlet");

		}
		catch(Exception e){
	 			e.printStackTrace();

	 	}

	}

}