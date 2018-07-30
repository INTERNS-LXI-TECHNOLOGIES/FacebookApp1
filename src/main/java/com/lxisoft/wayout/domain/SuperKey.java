package com.lxisoft.wayout.domain;
/**
*@author Anjali
*model class for SuperKey
*
*/
public class SuperKey{
    
    /**
     * Unique id of superKeyId
     */
	private Long superKeyId;
	
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

	/**
	 * setter for superKeyId
	 * 
	 * @param superKeyId
	 *            unique id of a superKey
	 */
    
	public void setSuperKeyId(long superKeyId)
	{
		//log.info("SuperKey class..........................setSuperKeyId................starts");

		this.superKeyId = superKeyId;

		//log.info("SuperKey class..........................setSuperKeyId..................ends");

	}
	
	/**
	 * getter for superKeyId
	 * 
	 * @return superKeyId
	 *            unique id of a superKey
	 *
	 */

	public Long getSuperKeyId()
	{
		//log.info("SuperKey class..........................getSuperKeyId...............starts/ends");

		return this.superKeyId;
	}
}