package com.lxisoft.wayout.web;
import com.lxisoft.wayout.domain.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import org.apache.log4j.Logger;
import javax.naming.*;
import java.util.*;
import com.lxisoft.wayout.service.impl.*;
import com.lxisoft.wayout.service.*;

/**
*@author Neeraja
*A main servlet class to redirect to AddController or AdminOptions
*
*@version 1.0
*
*/

public class MainServlet extends HttpServlet{

	/**
     *  creating the object of security Question implementation 
     *
     */

   // SecurityQuestionServiceImpl securityQuestionServiceImpl= new SecurityQuestionServiceImpl();


	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{
		

		if(request.getParameter("first")!=null){

			response.sendRedirect("AddQuestion.jsp");

		}
		else if(request.getParameter("second")!=null){

			response.sendRedirect("AdminOptions.jsp");//response.sendRedirect("Details.jsp");

		}
		
	}


}




