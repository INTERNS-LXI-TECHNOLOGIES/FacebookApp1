package com.lxisoft.wayout.domain;

/**
* This class is mainly used to set and get the instance variable.
* @author Balagopal v
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
*/
	
	public Hall getOpeningHall(){
		 return this.openingHall;
	}
	
/**
* set the variable securityQuestion.
* @param securityQuestion the location that holds the value of passsed argument.
*/
	
	public void setSecurityQuestions(Security securityQuestion){
		this.securityQuestions = securityQuestions;
	}
	
/**
* get the value of varible of securityQuestion.
*/
	
	public Security getSecurityQuestion(){
		return this.securityQuestion;
	}
	

	
/**
* set the boolean varibale doorStatus.
* @param doorId location that holds the value of passed arguments.
*/
	
	public void setIsDoorOpen(boolean doorstatus){
		this.doorStatus = doorStatus;
	}
	
	
/**
* get the value of boolean varible doorStatus
*/
	
	public boolean isDoorOpen(){
		return this.doorStatus;
	}
	
	
}