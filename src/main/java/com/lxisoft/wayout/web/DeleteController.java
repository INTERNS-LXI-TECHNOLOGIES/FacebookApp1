package com.lxisoft.wayout.web;
import com.lxisoft.wayout.domain.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.sql.*;
import java.sql.*;
import java.util.logging.*;
import org.apache.log4j.Logger;
import javax.naming.*;
import com.lxisoft.wayout.service.impl.*;
import com.lxisoft.wayout.service.*;

/**
*@author Neeraja
*servlet class to search questions
*
*@version 1.0
*
*/


public class DeleteController extends HttpServlet{
	
	static Logger logger=Logger.getLogger(AddQuestionController.class.getName());
	
	public void doGet(HttpServletRequest request, HttpServletResponse response ){
		
		System.out.println(">>>>>>>>>>>>>>");
		
	}

}