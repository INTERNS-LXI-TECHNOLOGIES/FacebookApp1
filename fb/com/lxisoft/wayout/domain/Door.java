package com.lxisoft.wayout.domain;

/**
* This class is mainly used to set and get the instance variable.
* @author Balagopal v
* @author Prabinraj t.p
*/

public class Door{
/**
* variable declaration
*/
	private Hall openingHall;
	private Security securityQuestion;
	private long doorId;
	private boolean doorStatus;
	
/**
* set the variable openingHall.
* @param openingHall the location that holds the vale of passsed argument.
*/
	
	public void setOpeningHall(Hall openingHall){
		this.openingHall = openingHall;
	}
	
/**
* get the value of varible of openingHall.
* @return openingHall.
*/
	
	public Hall getOpeningHall(){
		 return this.openingHall;
	}
	
/**
* set the variable securityQuestion.
* @param securityQuestion the location that holds the value of passsed argument.
*/
	
	public void setSecurityQuestions(Security securityQuestion){
		this.securityQuestion = securityQuestion;
	}
	
/**
* get the value of varible of securityQuestion.
* @return securityQuestion.
*/
	
	public Security getSecurityQuestion(){
		return this.securityQuestion;
	}
	

	
/**
* set the boolean varibale doorStatus.
* @param doorStatus location that holds the value of passed arguments.
*/
	
	public void setIsDoorOpen(boolean doorStatus){
		this.doorStatus = doorStatus;
	}
	
	
/**
* get the value of boolean varible doorStatus
*@return doorStatus
*/
	
	public boolean isDoorOpen(){
		return this.doorStatus;
	}
	
/** 
* set the value of long variable doorid.
* @param doorId
*/
	public void setDoorId(long doorId )
	{
		this.doorId=doorId;
    }

/**
* get the value of long variable doorid.
*@return doorId
*/ 
   
   public long getDoorId()
   {
   	return this.doorId;
   }   

}