package com.lxisoft.wayout.domain;
import java.util.*;
/**
*@author Vishnu MD
*To Find the current location of Prisoner in a Hall.
*/
public class Prisoner
{
	private ArrayList<Superkey> superKeys=new ArrayList<Superkey>();
	private Hall currentLocation=new Hall();
	/**
	*@param keys
	*Setting the superKeys
	*/
	public void setSuperKey(ArrayList<String> keys)
	{  
		this.superKeys=keys;
	}
	/**
	*return superkeys
	*Returning the value of superKeys
	*/
	public ArrayList<String> getSuperKey()
	{
		return superKeys;
	}
	/**
	*@param location
	*Setting the current location of prisoner
	*/
	public void setCurrenLocation(Hall location)	
	{
	    this .currentLocation=location;

	}
	/**
	*return currentLocation
	*Returning the current location of the prisoner
	*/
	public Hall getCurrentLocation()
	{
         return  	currentLocation;
	}
}