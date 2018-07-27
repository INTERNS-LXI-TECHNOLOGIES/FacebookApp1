package com.lxisoft.wayout.domain;

import java.util.*;

/**
*@author Anjali
*
*model class for Prisoner
*
*/
public class Prisoner
{
	/**
	*super keys the prisoner has
	*/
	private List<SuperKey> superkey;

	/**
	*variable to locate the prisoner
	*/
	private Hall currentLocation;
	
	/**
	*@param superkey
	*method to set superkeys to the prisoner
	*/
	public void setSuperKey(List<SuperKey> superkey)
	{

		this.superkey=superkey;
		
	}
	

	/**
	*@return superkey
	*method to get superkeys to the prisoner
	*/
	public List<SuperKey> getSuperKey()
	{

	return superkey;

	}
	
	/**
	*@param currentLocation
	*method to set currentLocation of the prisoner
	*/
	public void setCurrentLocation(Hall currentLocation){
		
		this.currentLocation=currentLocation;
		
	}
	
	/**
	*@return currentLocation
	*method to get currentLocation of the prisoner
	*/
	public Hall getCurrentLocation(){
		
		return currentLocation;
	}
	
	

}