package com.lxiosft.wayout.web;
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
import com.lxisoft.wayout.repository.*;
import org.apache.log4j.Logger;
public class AdminDeleteServlet extends HttpServlet
{
	/**
	*logger instance to print logging propertices
	**/
	
 	static Logger logger=Logger.getLogger(AdminDeleteServlet.class.getName());

 	/**
 	*Used to find and show the user details an delete conformation page
 	*
 	*/


	public void doGet(HttpServletRequest request,HttpServletResponse response)
	{
		logger.info("===============AdminDeleteServlet/doGet() starting==============");
		try
		{
			UserRepository userRepository=new UserRepository();
			String userName=request.getParameter("userName");
			TreeSet<User>mainSet=userRepository.findAllUser();
			request.getSession().setAttribute("users",mainSet);
			response.sendRedirect("UserDelete.jsp");
		}
		catch(Exception e)
		{
			logger.warn(e);
			e.printStackTrace();
		}
		logger.info("===============AdminDeleteServlet/doGet() Ending==============");
		
	}


	/**
	*Method delete an user
	*/


	public void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		logger.info("===============AdminDeleteServlet/doPost() starting==============");
		try{
			UserServiceImpl userServiceImpl=new UserServiceImpl();
			User user=(User)request.getSession().getAttribute("userToDelete");
			request.getSession().removeAttribute("userToDelete");
			userServiceImpl.deleteUser(user);
			response.sendRedirect("UserDeleted.jsp");
			}
			catch(Exception e)
			{
				logger.warn(e);
				e.printStackTrace();
			}
		logger.info("===============AdminDeleteServlet/doPost() Ending==============");	
	}
	
}