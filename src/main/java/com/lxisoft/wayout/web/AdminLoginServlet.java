package com.lxisoft.wayout.web;
/**
*@author sooraj pn
*
*Servlet class for working as  an Admincontroller to add new user 
*
**/
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import java.util.*;
import com.lxisoft.wayout.domain.*;
import com.lxisoft.wayout.service.impl.*;
import org.apache.log4j.Logger;
public class AdminLoginServlet extends HttpServlet
{
	/**
	*logger instance to print logging propertices
	**/
	
 	static Logger logger=Logger.getLogger(AdminLoginServlet.class.getName());

 	

	/**
	*METHOD IS USED TO show the admin options
	*/


	public void doGet(HttpServletRequest request,HttpServletResponse response)
	{
		logger.info("===============AdminLoginServlet/doGet() starting==============");
		try
		{

			request.getRequestDispatcher("AdminOptions.jsp").forward(request,response);
			//response.sendRedirect("done.jsp?page=UsersConfiguetration");
		}
		catch(Exception e)
		{
			logger.warn(e);
		}
		logger.info("===============AdminLoginServlet/doGet() Ending==============");	
	}	
}