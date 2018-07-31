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
	private Boolean isUsed;
	
	/**
	*@param isUsed
	*method to set super keys from prisoner
	*/
	public void setIsUsed(Boolean isUsed){
		
		this.isUsed=isUsed;
		
	}
	
	/**
	*@return isUsed
	*method to get super keys from prisoner
	*/
	public Boolean isUsed(){
		
		return this.isUsed;
	}

	/**
	 * setter for superKeyId
	 * 
	 * @param superKeyId
	 *            unique id of a superKey
	 */
    
	public void setSuperKeyId(Long superKeyId)
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
	
	/**
	*Overriding equals method to check equality of super keys.
	*
	*@return boolean value.
	*
	*@param obj of Object time.
	*/
	public boolean equals(Object obj)
	{
	
	//log.info("SuperKey class...........equals()...................................starts/ends");

	return ((obj != null) && (obj instanceof SuperKey) && this.getSuperKeyId()==((SuperKey)obj).getSuperKeyId());
		
	}
}