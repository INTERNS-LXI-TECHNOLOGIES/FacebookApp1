package com.lxisoft.wayout.domain;
import java.util.*;
/**
*@author Vishnu MD
*To Find the current location of Prisoner in a Hall.
*/
public class Prisoner
{
	private ArrayList<Superkey> superKeys=new ArrayList<Superkey>();
	private Hall currentlocation=new Hall();
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

}
		