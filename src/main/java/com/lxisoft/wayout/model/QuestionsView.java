package com.lxisoft.wayout.model;

import com.lxisoft.wayout.domain.*;

import java.util.*;

import java.util.logging.*;
/**
*@author Sarangi Balu
*
*model class for QuestionsView
*
*/

public class QuestionsView
{
	
	/**
	*This is a current and last no of page
	*/
	private int lastPageNo,currentPageNo=1;

	/**
	*This is a set of securityQuestion
	*/

	private Set<SecurityQuestion> securityQuestionSet;

	/**
     * Reference to Logger class to get log messages
     */
      
    private static final Logger log=Logger.getLogger(QuestionsView.class.getName());
    

	/**
	 * setter for pageNo
	 * 
	 * @param pageNo
	 *            pageNo of a Question
	 */

	public  void setCurrentPageNo(int pageNo)
	{

        log.info("QuestionsView class..........................setCurrentPageNo................starts");

		this.currentPageNo=pageNo;

		log.info("QuestionsView class..........................setCurrentPageNo..................ends");

	}

	/**
	 * getter for currentPageNo
	 * 
	 * @return currentPageNo currentPageNo of a Question
	 *
	 */	

	public int getCurrentPageNo()
	{
        
        log.info("QuestionsView class..........................getCurrentPageNo................starts");

		return this.currentPageNo;

	}

	/**
	 * setter for pageNo
	 * 
	 * @param pageNo
	 *            pageNo of a Question
	 */
	
    public void setLastPageNo(int pageNo)
	{
        log.info("QuestionsView class..........................setLastPageNo................starts");

		this.lastPageNo=pageNo;

		log.info("QuestionsView class..........................setLastPageNo..................ends");
        

	}

	/**
	 * getter for lastPageNo
	 * 
	 * @return lastPageNo lastPageNo of a Question
	 *
	 */	
	public int getLastPageNo()
	{
        log.info("QuestionsView class..........................getLastPageNo................starts");

		return this.lastPageNo;

	}
	

	/**
	* This is a setter which sets the set of securityQuestion
	*
	* @param securityQuestionSet - the set of securityQuestion to set
	*/
	public void setSecurityQuestionSet(Set<SecurityQuestion> securityQuestionSet)
	{
		log.info("QuestionsView class..........................setDoors................starts");
		
		this.securityQuestionSet = securityQuestionSet;
		
		log.info("QuestionsView class..........................setDoors................ends");
	}
	
	/**
	* This is a getter which returns the set of securityQuestion
	*
	* @return securityQuestionSet - the list of securityQuestion to get
	*
	*/
	public Set<SecurityQuestion> getSecurityQuestionSet()
	{
		log.info("QuestionsView class..........................getDoors................starts");
		
		return this.securityQuestionSet;
	}	


}