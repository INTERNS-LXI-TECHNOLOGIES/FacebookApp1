package com.lxisoft.wayout.domain;
import java.util.*;
import java.util.logging.*;
/**
* This class is for control prison
*
* @author Aparna,Manoj
*
* @version 1.0
*/
public class Prison
{
	/**
	*This is a reference to prisoner 
	*/
	private Prisoner prisoner;
	
	/**
	*This is a list to halls
	*/
	private List<Hall> halls;
	
	/**
	*Reference to Logger class to get log messages
	*/
	private static final Logger log = Logger.getLogger(Prison.class.getName());
	
	/**
	* This is a setter which sets the prisoner
	*
	*@param prisoner - the prisoner to  set
	*/
	public void setPrisoner(Prisoner prisoner)
	{
		log.info("Prison class..........................setPrisoner................starts");
		
		this.prisoner = prisoner;
		
		log.info("Prison class..........................setPrisoner................ends");
	}
	
	/**
	*This is a getter which returns the prisoner
	*
	*@return prisoner - the prisoner to get
	*/
	public Prisoner getPrisoner()
	{
		log.info("Prison class..........................getPrisoner................starts/ends");
		
		return this.prisoner;
	}
	
	/**
	* This is a setter which sets the list of halls
	*
	*@param halls - the list of halls to set
	*/
	public void setHalls(List<Hall> halls)
	{
		log.info("Prison class..........................setHalls................starts");
		
		this.halls = halls;
		
		log.info("Prison class..........................setHalls................ends");
	}
	
	/**
	*This is a getter which returns the list of halls
	*
	*@return halls - the list of halls to get
	*/
	public List<Hall> getHalls()
	{
		log.info("Prison class..........................getHalls................starts/ends");
		
		return this.halls;
	}
}