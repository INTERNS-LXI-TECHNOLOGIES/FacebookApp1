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
			 request.getRequestDispatcher("../displayAllUsers.jsp").forward(request,response);
			//response.sendRedirect("displayAllUsers.jsp");
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
			request.getRequestDispatcher("../done2.jsp?page=../admin/UsersConfiguration").forward(request,response);
			//response.sendRedirect("../done.jsp?page=admin/UsersConfiguration");
			response.sendRedirect("../done2.jsp?page=../admin/UsersConfiguration");
		}
		catch(Exception e)
		{
			logger.warn(e);
		}
		logger.info("===============AdminServlet/doPost() Ending==============");	
	}	
}