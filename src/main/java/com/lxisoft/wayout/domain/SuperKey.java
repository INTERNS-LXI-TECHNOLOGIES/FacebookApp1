package com.lxisoft.wayout.domain;
/**
*@author Anjali
*model class for SuperKey
*
*/
public class SuperKey{
	
	/**
	*variable to check whether super keys are used
	*/
	private boolean isUsed;
	
	/**
	*@param isUsed
	*method to set super keys from prisoner
	*/
	public void setIsUsed(boolean isUsed){
		
		this.isUsed=isUsed;
		
	}
	
	/**
	*@return isUsed
	*method to get super keys from prisoner
	*/
	public boolean isUsed(){
		
		return isUsed;
	}
}