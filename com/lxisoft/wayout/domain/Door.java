package com.lxisoft.wayout.domain;

import java.util.logging.*;

/**
* This class is mainly used to set and get the instance variable.
* @author Balagopal v
* @author Prabinraj t.p
*/

public class Door{
/**
* creating a reference for Logger.
*/
	private final static Logger logger = Logger.getLogger(Door.class.getName());
	
/**
* variable is used to hold the value of the opening hall.
*/
	private Hall openingHall;
	
/** 
* variable used to hold the security question which belongs to a door.
*/
	private SecurityQuestion securityQuestion;
	
/**
* variable used to hold the Id of the door
*/
	private long doorId;
	
/** 
* variable used to hold a boolean value to check if the door is closed or not.
*/
	private boolean isDoorOpen;
	
/**
* set the variable openingHall.
* @param openingHall the location that holds the value of passsed argument.
*/
	
	public void setOpeningHall(Hall openingHall){
		logger.info("Entered into the method setOpeningHall "+logger.getName());
		this.openingHall = openingHall;
		logger.info("Exit from the method setOpeningHall "+logger.getName());
	}
	
/**
* get the value of varible of openingHall.
* @return openingHall the variable that returns the value of opening hall.
*/
	
	public Hall getOpeningHall(){
		logger.info("Entered into the method getOpeningHall "+logger.getName());
		 return this.openingHall;
	}
	
/**
* set the variable securityQuestion.
* @param securityQuestion the location that holds the value of passsed argument.
*/
	
	public void setSecurityQuestions(SecurityQuestion securityQuestion){
		logger.info("Entered into the method setSecurityQuestions "+logger.getName());
		this.securityQuestion = securityQuestion;
		logger.info("Exit from the method setSecurityQuestions "+logger.getName());
	}
	
/**
* get the value of varible of securityQuestion.
* @return securityQuestion the variable that returns security question. 
*/
	
	public SecurityQuestion getSecurityQuestion(){
		logger.info("Entered into the method getSecurityQuestion "+logger.getName());
		return this.securityQuestion;
	}
	

	
/**
* set the boolean varibale doorStatus.
* @param isDoorOpen location that holds the value of passed arguments.
*/
	
	public void setIsDoorOpen(boolean isDoorOpen){
		logger.info("Entered into the method setIsDoorOpen "+logger.getName());
		this.isDoorOpen = isDoorOpen;
		logger.info("Exit from the method setIsDoorOpen "+logger.getName());
	}
	
	
/**
* get the value of boolean varible doorStatus
* @return isDoorOpen the variable that returns a value that says if the door is open or not.
*/
	
	public boolean isDoorOpen(){
		logger.info("Entered into the method isDoorOpen "+logger.getName());
		return this.isDoorOpen;
	}
	
/** 
* set the value of long variable doorid.
* @param doorId the location that holds the value of door id.
*/
	public void setDoorId(long doorId ){
	    logger.info("Entered into the method setDoorId "+logger.getName());
		this.doorId=doorId;
		logger.info("Exit from the method setDoorId "+logger.getName());
    }

/**
* get the value of long variable doorid.
* @return doorId the variable that returns the door Id of the door.
*/ 
   
   public long getDoorId()
   { 
     logger.info("Entered into the method getDoorId "+logger.getName());
   	 return this.doorId;
   }   

}