package com.lxisoft.wayout.web;

// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.util.logging.*;
import com.lxisoft.wayout.domain.*;
import com.lxisoft.wayout.model.*;
import com.lxisoft.wayout.service.impl.*;

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
	   try
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
	   catch(Exception ex)
	   {
		   
	   }

   }


   public Game playGame()
   {
      return game;
   }
   
   public Game loadGame()throws Exception
	{
		log.info("-----------GameServlet-----------loadGame()---------starts");
		Game game;
		
		/*Creating prison and list of prison halls with unique id of type long.
		local variable 'hallsToCreate' of type int is for loop controll to create specific number of halls.
		*/
		Prison prison = new Prison();
		List<Hall> halls = new ArrayList<Hall>();
		int hallsToCreate=0;
		long hallId=0l;
		while(hallsToCreate<13)
		{
			Hall hall=new Hall();
			hall.setHallId(hallId);
			halls.add(hall);
			hallId++;
			hallsToCreate++;
		}
		//wiring created halls to prison
		prison.setHalls(halls);
		/*setting up some outer halls as exit hall without locked doors to escape prisoner
		'exitHallCount' variable is used to controll while loop to set up 4 halls as exit halls
		creating random number to determin which door to be used as exit door.*/
		int exitHallCount=0;
		List<Hall> hallsForExit=prison.getHalls();
		while(exitHallCount<4)
		{
			log.info("-----------GameServlet-----------loadGame()------setting hall to exit in loop-----starts");
			int randomNo = (int)(Math.random()*(hallsForExit.size()));
			if(randomNo>3)
			{
					Hall h = hallsForExit.get(randomNo);
					h.setExitHall(true);
					exitHallCount++;
			}
		}
		
		/*Creating 'SecurityQuestionServiceImpl' class object reference and calling its 'findAllSecurityQuestion()' method to get 
		security question to allocate all doors
		converting set collection to list collection to take question using index.*/
		
		SecurityQuestionServiceImpl securityQuestionServiceImpl = new  SecurityQuestionServiceImpl();
		Set<SecurityQuestion> questions=securityQuestionServiceImpl.findAllSecurityQuestion();
		List<SecurityQuestion> listOfQuestions = new ArrayList<SecurityQuestion>(questions);
		
		/*creating 3 doors for each hall which is not exit hall
		'openToHall' local variable is used for setting up the door opening hall.*/
		
		int openToHall=1;
		List<Hall> pHalls=prison.getHalls();
		for(Hall hall:pHalls)
		{
			List<Door> doors=new ArrayList<Door>();
			
			/*local variable 'd' is used to controll loop which creates 3 each doors for halls which is not exit.
			local variable 'doorId' of type long is to setting up unique id for each door and setting securityQuestion to each door.
			*/
			int d=0;
			long doorId=0l;
			if(hall.isExitHall()==false)
			{
				//loop for creating doors.
				
				while(d<3)
				{
					Door door = new Door();
					door.setDoorId(doorId);
					
					//Creating random number to take question randomly from list and remove the taken question from list.  
					
					int randomNumber=(int)(Math.random()*listOfQuestions.size());
					SecurityQuestion securityQuestion=listOfQuestions.get(randomNumber);
					door.setSecurityQuestion(securityQuestion);
					listOfQuestions.remove(securityQuestion);
					
					//Setting up opening halls of doors.
					
					if(openToHall<pHalls.size())
					{
						door.setOpeningHall(pHalls.get(openToHall));
					}
					else
					{
						door.setOpeningHall(null);
					}
					d++;
					doorId++;
					doors.add(door);
					openToHall++;
				}
					hall.setDoors(doors);
			}
		}
			/*creating prisoner object of prison and 3 super keys for him.
		'i' is used to controll loop*/
		Prisoner prisoner = new Prisoner();
		List<SuperKey> superKeys = new ArrayList<SuperKey>();
		int i=0;
		long keyId=0l;
		while(i<3)
		{
			SuperKey key = new SuperKey();
			key.setSuperKeyId(keyId);
			superKeys.add(key);	
			i++;
		}
		prisoner.setSuperKeys(superKeys);
		List<Hall> prisonHalls=prison.getHalls();
		
		//setting up prisoner current location which is first hall.
		
		prisoner.setCurrentLocation(prisonHalls.get(0));
		prison.setPrisoner(prisoner);
		
		game = new Game();//creating game model object to pass to playGame() method. 
		game.setPrisoner(prison.getPrisoner());
		game.setNumberOfKeys(3);
		log.info("-----------GameServlet-----------loadGame()---------ends");
		return game;
	}

}