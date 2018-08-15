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
public class AdminServlet extends HttpServlet
{
	/**
	*logger instance to print logging propertices
	**/
	
 	static Logger logger=Logger.getLogger(AdminServlet.class.getName());

 	/**
 	*USED TO SHOW ALL AVAILABLE USERS
 	*
 	*/


	public void doGet(HttpServletRequest request,HttpServletResponse response)
	{
		logger.info("===============AddUserServlet/doGet() starting==============");
		try
		{
			UserServiceImpl userServiceImpl=new UserServiceImpl();

			TreeSet<User>mainSet=userServiceImpl.findAllUser();
			request.getSession().setAttribute("users",mainSet);
			response.sendRedirect("displayAllUsers.jsp");
		}
		catch(Exception e)
		{
			logger.warn(e);
			e.printStackTrace();
		}
		logger.info("===============AddUserServlet/doGet() Ending==============");
		
	}


	/**
	*METHOD IS USED TO UPADTE OR PROMOTE USER ROLE
	*/


	public void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		logger.info("===============AddUserServlet/doPost() starting==============");
		try
		{
			User user=(User) request.getSession().getAttribute("updateUser");

			request.getSession().removeAttribute("updateUser");
		
			AdminServiceImpl adminServiceImpl=new AdminServiceImpl();
				user.setRole("admin");
			adminServiceImpl.promoteUser(user);
			response.sendRedirect("AdminView");
		}
		catch(Exception e)
		{
			logger.warn(e);
		}
		logger.info("===============AddUserServlet/doPost() Ending==============");	
	}	
}