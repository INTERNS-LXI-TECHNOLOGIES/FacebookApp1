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

 	/*
 	*method is used to delete an admin or user
 	*/
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	{

		logger.info("===============AdminServlet/doget() starting==============");
		
		try{

			UserServiceImpl userServiceImpl=new UserServiceImpl();
			String username=request.getParameter("username");
			User user=userServiceImpl.findOne(username);
			request.getSession().removeAttribute("userToDelete");
			userServiceImpl.deleteUser(user);
			//response.sendRedirect("../done2.jsp?page=../admin/UsersConfiguration");
			request.getRequestDispatcher("../../done.jsp?page=adminRedirectingPage.jsp").forward(request,response);//UsersConfiguration
			if(request.getRemoteUser().equals(username))
				{
					request.getSession().invalidate();
				}

			}
			catch(Exception e)
			{
				logger.warn(e);
				e.printStackTrace();
			}
		logger.info("===============AdminServlet/doGet() Ending==============");	
		
	}




	/**
	*METHOD IS USED TO UPADTE OR PROMOTE USER ROLE
	*/


	public void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		logger.info("===============AdminServlet/doPost() starting==============");
		try
		{

			String username=request.getParameter("username");
			logger.info("}}}}}}}}}}}}}}}}}}}}}}}}}}username to promoteUser"+username);
			AdminServiceImpl adminServiceImpl=new AdminServiceImpl();
			UserServiceImpl userServiceImpl=new UserServiceImpl();
			User user=userServiceImpl.findOne(username);
			String operation=request.getParameter("operation");
			if(operation.equals("promote"))
			{
				user.setRole("admin");
			}
			else
			{
				user.setRole("user");
			}
			adminServiceImpl.promoteUser(user);
			//request.getRequestDispatcher("../done2.jsp?page=../admin/UsersConfiguration").forward(request,response);
			//response.sendRedirect("../done.jsp?page=admin/UsersConfiguration");
			response.sendRedirect("../../done.jsp?page=adminRedirectingPage.jsp");
		}
		catch(Exception e)
		{
			logger.warn(e);
		}
		logger.info("===============AdminServlet/doPost() Ending==============");	
	}	
}