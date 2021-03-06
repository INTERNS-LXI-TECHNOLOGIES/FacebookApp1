package com.lxisoft.wayout.web;
import com.lxisoft.wayout.domain.*;
import com.lxisoft.wayout.model.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;
import java.sql.*;
import java.util.logging.*;
import org.apache.log4j.Logger;
import javax.naming.*;
import java.util.*;
import com.lxisoft.wayout.service.impl.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
import javax.servlet.http.HttpServlet;
/**
*@author Neeraja
*servlet class to add questions
*
*@version 1.0
*
*/ 
@MultipartConfig
public class QuestionServlet extends HttpServlet{

     
     /**
       * Reference to QuestionsView
       */
     private QuestionsView questionsView;
	
	 /**
       * Reference to SwcurityQuestion class
       */


    SecurityQuestion securityQuestion=new SecurityQuestion();

     /**
       * Reference to SecuritQuestionimpl class
       */

    SecurityQuestionServiceImpl securityQuestionServiceImpl= new SecurityQuestionServiceImpl();



	 /**
       * Reference to Logger class to get log messages
       */
 	static Logger logger=Logger.getLogger(QuestionServlet.class.getName());


 	/**
	 * 
	 * Method for adding Questions
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

 	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{
		
		logger.info("-----------entering the  insert question doPost--------------");
		
		//---------------------------------------------------------------------------

		response.setContentType("text/html;charset=UTF-8");
        PrintWriter Writer = response.getWriter();
		try{
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
		String dateTime=dtf.format(now);
		dateTime=dateTime.trim().replaceAll("\\s+","");
		String dt=dateTime.trim().replaceAll("\\:+","");
		
		logger.info("-----------entering the  insert question doPost start image process--------------");
		
		final Part photoPart= request.getPart("image");
		final String fileName=getFileName(photoPart);
        String fl=fileName.substring(fileName.length()-4,fileName.length());
        OutputStream out = null;
        InputStream fileContent = null;
        String path1=(getServletContext().getRealPath("")
		+File.separator+"images"+File.separator+"questionimages"+File.separator+"img"+dt+fl);
        File file=new File(path1);
        String originalPath="images/questionimages/img"+dt+fl;
        out = new FileOutputStream(file);
        fileContent = photoPart.getInputStream();
        int read = 0;
        final byte[] bytes = new byte[1024];

        while ((read = fileContent.read(bytes)) != -1) 
        {
            out.write(bytes, 0, read);
        } 
		logger.info("-----------insert question doPost end image process--------------");
	
	
	//-------------------------------------------------------------------------------------------
	
	
 		AddQuestionModel addQuestionModel=new AddQuestionModel();
 		logger.info("entering the method");
 		logger.info("-----------entering the  insert question doPost setting question object--------------");
		Integer noOfOptions=Integer.parseInt(request.getParameter("noOfOptions"));
		
		
			SecurityQuestion securityQuestion=new SecurityQuestion();
			Set<String> options= new TreeSet<String>();
			//addQuestionModel=(AddQuestionModel)request.getSession().getAttribute("model");
			
			
			securityQuestion.setImageUrl(originalPath);
			securityQuestion.setQuestion(request.getParameter("question"));
			securityQuestion.setAnswer(request.getParameter("answer"));
			for(int i=0;i<noOfOptions;i++)
			{
				options.add(request.getParameter("option"+(i+1)));
			}
			securityQuestion.setOptions(options);
			
			securityQuestionServiceImpl.addSecurityQuestion(securityQuestion);
			/**
			*redirecting to another page
			*
			*/
			addQuestionModel=null;
			request.getSession().removeAttribute("model");
			logger.info("-----------entering the  insert question doPost end of setting question object--------------");
			
			response.sendRedirect("done.jsp?redirectPageUrl=addQuestion");

		}
 		catch(Exception e){
			logger.warn("----------Exception in doPost() of QuestionServlet class--------");
 			e.printStackTrace();
 		}
 	}
 	/**
       * Get method to find all questions from the database
       *
       * @param request
       *            http request
       * @param response
       *            http response
       * @throws IOException
		*          if IOException occurs
		*
		* @throws ServletException 
		*           if Undesired condition occurs 
       */
	   
 	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{
 		try{

 			logger.info(">>>>>>>>>>>>>>entering the find all Method");
            
            HttpSession session=request.getSession(); 

            Object object=session.getAttribute("questionsView");

		    if((object==null) || !(object instanceof Game))
            {  
              questionsView=new QuestionsView();
            }
             
            //questionsView=(QuestionsView)object;
             
			Set<SecurityQuestion> questions=securityQuestionServiceImpl.findAllSecurityQuestion();

			/*request.getSession().setAttribute("question",questions);*/

            questionsView.setSecurityQuestionSet(questions);

            questionsView.setLastPageNo(getPageSize());


             session.setAttribute("questionsView",questionsView);


			response.sendRedirect("DisplayAll.jsp");

			logger.info(">>>>>>>>>>>>>>exiting the find all Method");

 		}
 		catch(Exception e){
 			e.printStackTrace();

 		}



 	}

 	public int getPageSize()
   {

    int size=(questionsView.getSecurityQuestionSet()).size();

       if(size%5==0)
          return (size/5);
       else
         return (size/5)+1;
   }
   
   private String getFileName(final Part part)
    {
        final String partHeader=part.getHeader("content-disposition");
        for(String content:partHeader.split(";"))
        {
            if(content.trim().startsWith("filename"))
            {
                String x=content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
                return x;
            }
        }
        return null;
    }
	
	public String getServletInfo() {
        return "Short description";
    }
 }


