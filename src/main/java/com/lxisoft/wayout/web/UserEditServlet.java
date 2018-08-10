package com.lxiosft.wayout.web;
/**
*@author Neeraja.M
*
*Servlet class for working as a controller to add new user 
*
**/
import com.lxisoft.wayout.domain.*;
import com.lxisoft.wayout.model.*;
import com.lxisoft.wayout.service.*;
import com.lxisoft.wayout.service.impl.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import java.util.*;
import org.apache.log4j.Logger;
public class UserEditServlet extends HttpServlet
{
	/**
	*logger instance to print logging propertices
	**/
	
	static Logger logger=Logger.getLogger(UserEditServlet.class.getName());

	/**
	*
	* making a new user
	*
	*/

	User user=new User();

	/**
	*
	* making a new userServiceimplementation object to add to the database
	*
	*/


	UserServiceImpl userServiceImpl=new UserServiceImpl();


	/**
	 * 
	 * Method for getting an unique user
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

		public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException
	{
		try{
			logger.info("======================UserEditServlet/doPost() starting==============");
			String username=request.getParameter("username");
			User user=userServiceImpl.findOne(username);
			request.getSession().setAttribute("user",user);
			response.sendRedirect("UserEdit.jsp");
		}
		catch(Exception e){
			e.printStackTrace();
		}


	}

	/**
	 * 
	 * Method for editing user details
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


	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException
	{
		try{
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String oldUsername=request.getParameter("oldusername");

			user.setUsername(username);
			user.setPassword(password);
			userServiceImpl.editUser(user, oldUsername);
			response.sendRedirect("done.jsp?page=AdminOptions.jsp");

		}
		catch(Exception e){
			e.printStackTrace();
		}



	}
}

