package com.lxisoft.wayout.domain;

import java.util.*;
import java.util.logging.*;

/**
* This class is for control Hall
*
* @author Dheeraj das
*
* @version 1.0
*/
public class Hall
{
	/**
	*This is for checking exit hall
	*/
	private boolean isExitHall;
	
	/**
	*This is a list of doors
	*/
	private List<Door> doors ;
	
	/**
	*This is a unique id of hall
	*/
	private long hallId;

	/**
	*Reference to Logger class to get log messages
	*/
	private static final Logger log = Logger.getLogger(Hall.class.getName());
	
	/**
	*This is a setter which set the exit hall
	*
	*@param isExitHall - the value of exit hall to set 
	*/
	public void setExitHall(boolean isExitHall)
	{
		log.info("Hall class..........................setExitHall................starts");
		
		this.isExitHall = isExitHall;
		
		log.info("Hall class..........................setExitHall................ends");
	}
	
	/**
	*This is a getter which return the exit hall 
	*
	*@return isExitHall - the value of exit hall to get
	*/
	public boolean isExitHall()
	{
		log.info("Hall class..........................isExitHall................starts/ends");
		
		return isExitHall;
	}
	
	/**
	* This is a setter which sets the list of doors
	*
	* @param doors - the list of doors to set
	*/
	public void setDoors(List<Door> doors)
	{
		log.info("Hall class..........................setDoors................starts");
		
		this.doors = doors;
		
		log.info("Hall class..........................setDoors................ends");
	}
	
	/**
	* This is a getter which returns the list of doors
	*
	* @return doors - the list of doors to get
	*/
	public List<Door> getDoors()
	{
		log.info("Hall class..........................getDoors................starts/ends");
		
		return doors;
	}	

	/**
	* This is a setter which sets the hallId
	*
	* @param hallId - the hallId to set
	*/
	public void setHallId(long hallId)
	{
		log.info("Hall class..........................setHallId................starts");
		
		this.hallId = hallId;
		
		log.info("Hall class..........................setHallId................ends");
	}
	
	/**
	* This is a getter which returns the hallId
	*
	* @return hallId - the hallId to get
	*/
	public long getHallId()
	{
		log.info("Hall class..........................getHallId................starts/ends");
		
		return hallId;
	}
	
	/**
	*This is a equals method to override
	*
	*@return bool - the boolean value for equals
	*/
	public boolean equals(Object obj) 
	{
		log.info("Hall class..........................equals................starts/ends");
		
		return ((obj != null) && (obj instanceof Hall) && (this.getHallId() == ((Hall)obj).getHallId())); 
	}

}