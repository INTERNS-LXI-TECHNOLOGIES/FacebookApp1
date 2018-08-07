package com.lxisoft.wayout.web;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.Logger.*;
import org.apache.log4j.Logger;
import com.lxisoft.wayout.model.GameConfiguration;
import java.io.IOException;

public class GameConfigurationServlet extends HttpServlet
{
	private static final Logger log = Logger.getLogger(GameConfigurationServlet.class.getName());
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		try
		{
			log.info("------doPost() method started--------");
			Integer keysCount = Integer.parseInt(request.getParameter("keysCount"));
			Integer hallsCount = Integer.parseInt(request.getParameter("hallsCount"));
			Integer questionTime = Integer.parseInt(request.getParameter("questionTime"));
			Integer gameTime = Integer.parseInt(request.getParameter("gameTime"));
			String gameMode = request.getParameter("gameMode");
		
			GameConfiguration gameConfiguration = new GameConfiguration();
			gameConfiguration.setKeysCount(keysCount);
			gameConfiguration.setHallsCount(hallsCount);
			gameConfiguration.setQuestionTime(questionTime);
			gameConfiguration.setGameTime(gameTime);
			gameConfiguration.setGameMode(gameMode);
			log.info("------doPost() method ended--------");
		}
		catch(Exception ex)
		{
			log.warn("------doPost() method exception occured--------");
			ex.printStackTrace();
		}
	}
}