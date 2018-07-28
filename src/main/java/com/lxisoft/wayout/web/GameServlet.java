package com.lxisoft.wayout.web;

// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.util.logging.*;
import com.lxisoft.wayout.domain.*;
import com.lxisoft.wayout.model.*;

/**
 * Servlet class for working as a controller for managing games
 *
 * @author Sarangi Balu
 * 
 * @version $version-stub$
 *
 */


// Extend HttpServlet class
public class GameServlet extends HttpServlet 
{

 /**
  * Reference to Game class
  */
 private Game game;

/**
 * Reference to Logger class to get log messages
 */
  
  private static final Logger log=Logger.getLogger(GameServlet.class.getName());

 /**
   * method for initial working
   *
   * @throws ServletException
   *             if undesired condition occures
   */
  public void init() throws ServletException 
  {
    log.fine("execution starts");

    log.fine("execution ends");
  }


  /**
   * Get method for getting the details
   *
   * @param request
   *            http request
   * @param response
   *            http response
   */


public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException

   {
      log.info("********************GameServlet**********************doGet---------> start");

      HttpSession session=request.getSession();  

      Object object=session.getAttribute("model");

      if((object==null) || !(object instanceof Game))
        game=loadGame();
      else
        game=playGame();
        
      session.setAttribute("model",game);

      // forward to jsp page with request parameters 
      request.getRequestDispatcher("game.jsp").forward(request,response);     
             
         
      log.info("********************GameServlet**********************doGet---------> end");

   }


   public Game playGame()
   {
      return game;
   }
   
   public Game loadGame()
   {
     return game;
   }

}