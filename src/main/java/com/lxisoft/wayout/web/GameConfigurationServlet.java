package com.lxisoft.wayout.web;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.Logger.*;
import org.apache.log4j.Logger;
import com.lxisoft.wayout.model.GameConfiguration;
import java.io.IOException;
import com.lxisoft.wayout.service.GameConfigurationService;
import com.lxisoft.wayout.service.impl.GameConfigurationServiceImpl;

/**
*@author Ruhail
*servlet class to take data for game configuration; 
*
*@version 1.0
*@since 08-08-2018
*/ 

public class GameConfigurationServlet extends HttpServlet
{
/**
*Logger reference for logging
*/ 
	private static final Logger log = Logger.getLogger(GameConfigurationServlet.class.getName());
	
	/**
	 * 
	 * Method for recieving data from form
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
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		try
		{
			log.info("------doPost() method started--------");
			int keysCount = Integer.parseInt(request.getParameter("keysCount"));
			int hallsCount = Integer.parseInt(request.getParameter("hallsCount"));
			int questionTime = Integer.parseInt(request.getParameter("questionTime"));
			int gameTime = Integer.parseInt(request.getParameter("gameTime"));
			String gameMode = request.getParameter("gameMode");
		
			GameConfiguration gameConfiguration = new GameConfiguration();
			gameConfiguration.setKeysCount(keysCount);
			gameConfiguration.setHallsCount(hallsCount);
			gameConfiguration.setQuestionTime(questionTime);
			gameConfiguration.setGameTime(gameTime);
			gameConfiguration.setGameMode(gameMode);
			GameConfigurationService gameConfigurationService = new GameConfigurationServiceImpl();
			gameConfigurationService.configureGame(gameConfiguration);
			
			log.info("------doPost() method ended--------");
		}
		catch(Exception ex)
		{
			log.warn("------doPost() method exception occured--------");
			ex.printStackTrace();
		}
	}
}