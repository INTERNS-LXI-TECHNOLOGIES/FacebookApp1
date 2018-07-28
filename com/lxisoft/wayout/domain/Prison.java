package com.lxisoft.wayout.domain;
import java.util.logging.Logger;
import java.util.logging.Level;



/**
*Setting and getting of  variables prisoner and hall in class Prison.
*@author Aparna.
*@author Manoj.
*/

public class Prison
{ 
/**
*.creation of reference to Logger.
*/
	private final static Logger log=Logger.getLogger(Prison.class.getName());
	
/**
*Declaration of variable prisoner of type Prisoner.
*/
    private Prisoner prisoner;
/**
*Declaration of variable and hall of type Hall.
*/
	private Hall hall;
/**
*Setting prisoner.
*@param prisoner (Passing parameter prisoner).
*/
    public void setPrisoner(Prisoner prisoner)
    {
		log.info("Entered into method setPrisoner" +log.getName());

			this.prisoner=prisoner;
		log.info("Exit from method setPrisoner" +log.getName());
	
	}
/**
*Getting prisoner.
*@return prisoner (Returning the value prisoner).
*/
	
			public Prisoner getPrisoner()
		{
			log.info("Entered into method getPrisoner" +log.getName());
				return this.prisoner;
		
		}
/**
*Setting hall.
*@param hall (Passing parameter hall).
*/
			public void setHall(Hall hall)
		{
			log.info("Entered into method setHall" +log.getName());
				this.hall=hall;
			log.info("Exit from method setHall" +log.getName());
		}
/**
*Getting hall.
*@return hall (Returning the value hall).
*/
	public Hall getHall()
	{
		log.info("Entered into method getHall" +log.getName());

	    return this.hall;
	}

}
