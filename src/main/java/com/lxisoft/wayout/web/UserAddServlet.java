package com.lxisoft.wayout.web;
/**
*@author Neeraja.M
*
*Servlet class for working as a controller to add new user 
*
**/
import com.lxisoft.wayout.domain.*;
import com.lxisoft.wayout.model.*;
import com.lxisoft.wayout.service.impl.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import java.util.*;
import org.apache.log4j.Logger;
public class UserAddServlet extends HttpServlet
{
	/**
	*logger instance to print logging propertices
	**/
	
	static Logger logger=Logger.getLogger(UserAddServlet.class.getName());

	/**
	*
	* making a new user
	*
	*/

	User user=new User();

	/**
	*
	* making a new userService object to add to the database
	*
	*/


	UserServiceImpl userServiceImpl=new UserServiceImpl();


	/**
	 * 
	 * Method for adding a new user
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
		logger.info("======================UserAddServlet/doPost() starting==============");
		
		 String username=request.getParameter("username");
		 String password=request.getParameter("password");

		 String userrole=request.getParameter("role");
		 user.setUsername(username);
		 user.setPassword(password);
		 
		 user.setRole(userrole);

		 userServiceImpl.addUser(user);

		logger.info("======================UserAddServlet/doPost() ending==============");
		request.getRequestDispatcher("AdminOptions.jsp").forward(request,response);
		//response.sendRedirect("admin");
		
	}


	/**
	 * 
	 * Method for finding a single user
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
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{
		
		String username=request.getParameter("username");
		//String username=request.getParameter("username");
		//String password=request.getParameter("password");
		User user=userServiceImpl.findOne(username);
		//user.setUsername(username);
		//user.setPassword(password);
		request.getSession().setAttribute("user",user);
		response.sendRedirect("user.jsp");







	}
	
	
}
