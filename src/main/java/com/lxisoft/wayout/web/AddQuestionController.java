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
/**
*@author Neeraja
*servlet class to add questions
*
*@version 1.0
*
*/

public class AddQuestionController extends HttpServlet{

	/**
     *  setting logger 
     *
     */
 	static Logger logger=Logger.getLogger(AddQuestionController.class.getName());


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
			DataSource ds=null;	
			Connection connection = null;
			Statement stmt = null;
			response.setContentType("text/html");

			String question=request.getParameter("question");
			String option1=request.getParameter("option1");
			String option2=request.getParameter("option2");
			String option3=request.getParameter("option3");
			String option4=request.getParameter("option4");








 		}
 		catch(Exception e){
 			e.printStackTrace();

 		}



 	}
 }


