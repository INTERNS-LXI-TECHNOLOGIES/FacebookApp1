package com.lxisoft.wayout.web;
import java.io.*;
import javax.servlet.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpSession;
import com.lxisoft.wayout.service.*;
import com.lxisoft.wayout.service.impl.*;
import com.lxisoft.wayout.domain.*;

/**
*@author Anjali
*servlet class to retrive random questions
*
*/
public class SecurityQuestionServlet extends HttpServlet{
	
	/**
	*doget method to retrive questions set from database and pass to jsp
	*
	*/
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	
		SecurityQuestionService service=new SecurityQuestionServiceImpl();
		
		Set<SecurityQuestion> questions=service.findAllSecurityQuestion();
		
		/*for(SecurityQuestion s:questions){
			System.out.println(s.getQuestion());
		
		}*/
		
		HttpSession session=request.getSession();
		session.setAttribute("securityquestions",questions);
		
		RequestDispatcher rd=request.getRequestDispatcher("/GameLoader.jsp");
		rd.forward(request,response);
	}


}