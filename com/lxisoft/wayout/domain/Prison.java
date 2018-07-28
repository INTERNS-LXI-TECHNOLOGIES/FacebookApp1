package com.lxisoft.wayout.domain;

/**
*Setting and getting of  variable hall in class Prison.
*@author Manoj.
*/

public class Prison
{ 
	
/**
*Declaration of variable  hall of type Hall.
*/
    
	private Hall hall;

/**
*Setting hall.
*@param hall Passing parameter hall.
*/
	public void setHall(Hall hall)
	{
	this.hall=hall;
	}
/**
*Getting hall.
*@return hall Returning the value hall.
*/
	public Hall getHall()
	{

	return this.hall;
	}

}
