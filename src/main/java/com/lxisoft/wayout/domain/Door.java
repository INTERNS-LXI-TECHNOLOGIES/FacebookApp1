//Import required java libraries
package com.lxisoft.wayout.domain;

import java.util.logging.*;
/**
 * define Door enitity in the game. 
 * 
 * @author Balagopal,Prabinraj
 * 
 * @version $version-stub$
 *
 */
public class Door
{
	/**
     *  Hall to which door opens  
     */
	private Hall openingHall;

	/**
     * Reference to SecurityQuestion class
     */

	private SecurityQuestion securityQuestion;

	/**
     * Unique id of doorId
     */

    private Long doorId;

    /**
     * The Boolean value corresponding to the door current status
     */

    private boolean isAccessDenied=false;

    /**
     * The boolean value corresponding to the door open/close status
     */

    private boolean isOpen=false;

    /**
     * Reference to Logger class to get log messages
     */
      
    private static final Logger log=Logger.getLogger(Door.class.getName());
    
    /**
	 * setter for openingHall
	 * 
	 * @param openingHall
	 *            openingHall of a prison
	 */

	public void setOpeningHall(Hall openingHall)
	{
		log.info("Door class..........................setOpeningHall................starts");

		this.openingHall = openingHall;

		log.info("Door class..........................setOpeningHall..................ends");
	}
	
	/**
	 * getter for openingHall
	 * 
	 * @return openingHall openingHall of a prison
	 *
	 */

	public Hall getOpeningHall()
	{
		log.info("Door class..........................getOpeningHall................starts/ends");

		return this.openingHall;
	}


    /**
	 * setter for securityQuestion
	 * 
	 * @param securityQuestion
	 *            securityQuestion of a door
	 */
    
	public void setSecurityQuestion(SecurityQuestion securityQuestion)
	{
		log.info("Door class..........................setSecurityQuestion................starts");

		this.securityQuestion = securityQuestion;

		log.info("Door class..........................setSecurityQuestion..................ends");
	}
	
	/**
	 * getter for securityQuestion
	 * 
	 * @return securityQuestion
	 *            securityQuestion of a door
	 *
	 */

	public SecurityQuestion getSecurityQuestion()
	{
		log.info("Door class..........................getSecurityQuestion................starts/ends");

		return this.securityQuestion;
	}

	/**
	 * setter for doorId
	 * 
	 * @param doorId
	 *            unique id of a door
	 */
    
	public void setDoorId(Long doorId)
	{
		log.info("Door class..........................setDoorId................starts");

		this.doorId = doorId;

		log.info("Door class..........................setDoorId..................ends");

	}
	
	/**
	 * getter for doorId
	 * 
	 * @return doorId
	 *            unique id of a door
	 *
	 */

	public Long getDoorId()
	{
		log.info("Door class..........................getDoorId................starts/ends");

		return this.doorId;
	}

    /**
	 * setter for status of door
	 * 
	 * @param isAccessDenied
	 *            block status of a door
	 */

	public void setIsAccessDenied(boolean isAccessDenied)
	{
		log.info("Door class...........setIsAccessDenied................starts");

		this.isAccessDenied=isAccessDenied;

		log.info("Door class...........setIsAccessDenied..................ends");
		
	}

	/**
	 * getter for status of door
	 * 
	 * @return isAccessDenied
	 *            block status of a door
	 *
	 */
	
	public boolean isAccessDenied()
	{
		log.info("Door class.............isAccessDenied...................starts/ends");

		return this.isAccessDenied;
	}

    /**
	 * setter for status of door
	 * 
	 * @param isOpen
	 *            open status of a door
	 */

	public void setIsOpen(boolean isOpen)
	{
		log.info("Door class...........setIsOpen................starts");

		this.isOpen=isOpen;

		log.info("Door class...........setIsOpen..................ends");
		
	}

	/**
	 * getter for status of door
	 * 
	 * @return isOpen
	 *            open status of a door
	 *
	 */
	
	public boolean isOpen()
	{
		log.info("Door class.............isOpen...................starts/ends");

		return this.isOpen;
	}
	
	/**
	 * implementation of equals method 
	 * 
	 * @param obj
	 *            Indicates whether some other object is "equal to" this one
	 *
	 *@return bool - the boolean value for equals
	 *
	 */

	public boolean equals(Object obj)
	{
		log.info("Door class...........equals()...................................starts/ends");

	    return ((obj != null) && (obj instanceof Door) && this.doorId==((Door)obj).doorId);		
			 
	}	

}