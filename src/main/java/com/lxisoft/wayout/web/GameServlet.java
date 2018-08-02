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
	   
		  log.info("********************GameServlet**********************doGet---------> start"+request.getParameter("isAccessDenied")+request.getParameter("doorId"));

		  HttpSession session=request.getSession();  
		  
		  Door door=null;

		  Object object=session.getAttribute("model");

		  if((object==null) || !(object instanceof Game))
          {  
            try
            {
			game=loadGame();
		    }
            catch(Exception ex)
	        {
		      ex.printStackTrace(); 
	        }
 
          }
		  else if(request.getParameter("isAccessDenied")!=null&&request.getParameter("isAccessDenied").equals("true"))
		  {
		     game=(Game)object;

		     if(request.getParameter("doorId")!=null)
		  		door=getDoorByDoorId(Long.parseLong(request.getParameter("doorId")));

			 door.setIsAccessDenied(true); 
		  }
			 
     	  else  
     	  { 
     	  	game=(Game)object;

     	  	if(request.getParameter("doorId")!=null)
		  		door=getDoorByDoorId(Long.parseLong(request.getParameter("doorId")));

		  	resetDoorId(door); //Door id should be reset to its previous value if prisoner comes back through back door  
             playGameWithSuperKey(door);
     	  }
		  
		  
		  session.setAttribute("model",game);
		  
		  

		  if(game.getPrisoner().getCurrentLocation().isExitHall())
		    {
                 // forward to jsp page with request parameters 
		           request.getRequestDispatcher("win.jsp").forward(request,response);
		           return; 

		    }   
		  
		  	
		   // forward to jsp page with request parameters 
		   log.info("********************GameServlet**********************doGet---------> end");
		   request.getRequestDispatcher("game.jsp").forward(request,response);     
	   
   }

  

   /**
     * Create a game model and its validation with SuperKey
     *
     * @param door
     *            door object of Door class    
     *
     */


   public void playGameWithSuperKey(Door door)
   { 

   	  log.info("******GameServlet**************playGameWithSuperKey**********************---------> start");
       
        if(!door.isOpen())
      		{
      			door.setIsOpen(true);
      			
      			if(game.getNumberOfKeys()>0)
      				game.setNumberOfKeys((game.getNumberOfKeys())-1);
      			
      			List<SuperKey> superkeys=game.getPrisoner().getSuperKeys();

      	   	    for(SuperKey superKey:superkeys)
      	        {
      	   	    	
      	        if(superKey.isUsed()==false)
      	        {
      	        	superKey.setIsUsed(true);
      	            
      	            break;
      	        }

      	       }
      			
      		}
      	    changeState(door);

      		          
     log.info("********GameServlet************playGameWithSuperKey**********************---------> end");
   }

   /**
    * change the state of prisoner
    *
    * @param door
    *            door is the Door class object
    */
   
   public void changeState(Door door)
   {
	   log.info("*****GameServlet***************changeState**********************---------> start");
	   
	   if(door.getOpeningHall()!=null) {
	   Hall temp= game.getPrisoner().getCurrentLocation();
	   
	   game.getPrisoner().setCurrentLocation(door.getOpeningHall());
	   
	   door.setOpeningHall(temp);
	   
	   if((game.getPrisoner().getCurrentLocation().getBackDoor())==null&&game.getPrisoner().getCurrentLocation().getHallId()!=0)
	   {
		   game.getPrisoner().getCurrentLocation().setBackDoor(door);
		   if(game.getPrisoner().getCurrentLocation().getDoors()!=null)
		   	door.setDoorId((long)(game.getPrisoner().getCurrentLocation().getDoors().size()));
		   else
		   	door.setDoorId((long)0);
	   }
	   }
	   log.info("******GameServlet**************changeState**********************---------> end");
	   
   }
   
   /**
    * get the door by DoorId
    *
    * @param doorId
    *            doorId is the id of Door class 
    * @return Door its a door object           
    */
   
   public Door getDoorByDoorId(Long doorId)
   {
	   log.info("*****GameServlet***************getDoorByDoorId**********************---------> start");
	   
	   List<Door> doors=game.getPrisoner().getCurrentLocation().getDoors();	

/*	   if(game.getPrisoner().getCurrentLocation().getDoors()!=null && game.getPrisoner().getCurrentLocation().getBackDoor()!=null)
	   {
	   		if(game.getPrisoner().getCurrentLocation().getBackDoor().getDoorId()==doorId)
	   			return game.getPrisoner().getCurrentLocation().getBackDoor();
	   	}*/
       for(Door door:doors)
    	   
         if(doorId==(door.getDoorId()))
        	 
         return door;
        	 
       return game.getPrisoner().getCurrentLocation().getBackDoor(); //returns back door if there is no other door with this id
        	           
   }

    /**
    * get the door by DoorId
    *
    * @param door
    *            door whose doorId to be reset           
    */
   
   public void resetDoorId(Door door)
   {
	   log.info("_____________________________ start_________________________"+door.getDoorId());
	   
	   if(door.getOpeningHall()!=null&&door.getOpeningHall().getDoors()!=null) {
		   List<Door> doors=door.getOpeningHall().getDoors();

		   long i;

		   outerloop:
		   for(i=0;i<doors.size();i++) { // Loop to find the previous id if there is one
	       	
	       		for(Door d:doors)
	    	   
	         		if(i==(d.getDoorId()))
	         		{
	         			log.info("***"+i+" door id"+d.getDoorId());
	         			continue outerloop;
	         		}
	         	door.setDoorId(i);	
	         	break;
	        }
	     }
       log.info("_____________________________ end_________________________"+door.getDoorId());  	           
   }
   
   /**
   * Create a game model and its validation with answerKey
   *
   * @param request
   *            http request
   * @param response
   *            http response
   */


    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException

   {
		  log.info("********************GameServlet**********************doPost---------> start");

		  HttpSession session=request.getSession();  
		  
		  
		  Door door;
		  Object object=session.getAttribute("model");

		  if((object==null) || !(object instanceof Game))
           {

			try
            {
			game=loadGame();
		    }
            catch(Exception ex)
	        {
		      ex.printStackTrace(); 
	        }

		   }

		  else
			 {
             
			  game=(Game)object;
             door=getDoorByDoorId(Long.parseLong(request.getParameter("doorId")));	  
			  if(request.getParameter("option").equals(door.getSecurityQuestion().getAnswer()))
	       	    {
	       	    	door.setIsOpen(true);   
	           	    
	           	    changeState(door);

	       	    }
	       	    else
	       	    
	       	    	door.setIsAccessDenied(true);
	       	                  
             }
			
		  session.setAttribute("model",game);

		  if((game.getPrisoner().getCurrentLocation().isExitHall()))
		    {
                 // forward to jsp page with request parameters 
		           request.getRequestDispatcher("win.html").forward(request,response); 
		           return;
		    }         
   
		          // forward to jsp page with request parameters 
		           request.getRequestDispatcher("game.jsp").forward(request,response);     
			 
			 
		  log.info("********************GameServlet**********************doPost---------> end");
	   
	   
   }
    
    /**
     * Create a game model and sets all instance at loading game time
     *
     * @return game object
     * 
     * @exception Exception throw the Exception
     */
    
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
		int exitHallCount=1;
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

		List<Hall> halls1=prison.getHalls();
		for(Hall hall: halls1) {
			log.info("______________________________________"+hall.getHallId()+" "+hall.isExitHall());
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
					if(listOfQuestions.size()>0) {
						SecurityQuestion securityQuestion=listOfQuestions.get(randomNumber);
						door.setSecurityQuestion(securityQuestion);
						listOfQuestions.remove(securityQuestion);
					}
					
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
		while(i<1)
		{
			SuperKey key = new SuperKey();
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