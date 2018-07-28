package com.lxisoft.wayout.domain;
import java.util.*;
import java.util.logging.*;

/** 
* This class is for control security question
*
* @author Dheeraj das
*
* @version 1.0
*
*/
public class SecurityQuestion
{
	/**
	*This is a image url for security question
	*/
	private String imageUrl;
	
	/**
	*This is a unique id for security question
	*/
	private long questionId;

	/**
	*This is a question for security
	*/
	private String question;
	
	/**
	*This is a answer for security question
	*/
	private String answer;
	
	/**
	*This is a set of options for security question
	*/
	private Set<String> options;  
	
	/**
    * Reference to Logger class to get log messages
    */  
    private static final Logger log=Logger.getLogger(SecurityQuestion.class.getName());
   
    /**
	*This ia setter which set the image url
	*
	*@param imageUrl - the image url to set
	*/
	public void setImageUrl(String imageUrl)
	{
		this.imageUrl = imageUrl;
	}
	
	/**
	*This is a getter which returns the image url
	*
	*@return imageUrl - the image url to get
	*/
	public String getImageUrl()
	{
		return imageUrl;
	}
   
	/**
	*This is a setter which sets the question id
	*
	*@param questionId - the question id to set
	*/
	public void setQuestionId(long questionId)
	{
		log.info("SecurityQuestion class..........................setQuestionId................starts");
		
		this.questionId = questionId;
		
		log.info("SecurityQuestion class..........................setQuestionId................ends");
	}

	/**
	*This is a getter which return the question id
	*
	*@return questionId - the question id to return
	*/
	public long getQuestionId()
	{
		log.info("SecurityQuestion class..........................getQuestionId................starts/ends");

		return questionId;
	}
	
	/**
	* This is a setter which sets the question
	*
	* @param question - the question to set
	*/
	public void setQuestion(String question)
	{
		log.info("SecurityQuestion class..........................setQuestion................starts");

		this.question = question;
		
		log.info("SecurityQuestion class..........................setQuestion................ends");

	}
	
	/**
	* This is a getter which returns the question
	*
	* @return question - the question to get
	*/
	public String getQuestion()
	{
		log.info("SecurityQuestion class..........................getQuestion................starts/ends");

		return question;
		
	}
	
	/**
	* This is a setter which sets the answer
	*
	* @param answer - the answer to set
	*/
	public void setAnswer(String answer)
	{
		log.info("SecurityQuestion class..........................setAnswer................starts");
		
		this.answer = answer;
		
		log.info("SecurityQuestion class..........................setAnswer................ends");
		
	}
	
	/**
	* This is a getter which returns the answer
	*
	* @return answer - the answer to get
	*/
	public String getAnswer()
	{
		log.info("SecurityQuestion class..........................getAnswer................starts/ends");

		return answer;
	}
	
	/**
	* This is a setter which sets the options of set
	*
	* @param options - the option to set 
	*/
	public void setOptions(Set<String> options)
	{
		log.info("SecurityQuestion class..........................setOptions................starts");

		this.options = options;
		
		log.info("SecurityQuestion class..........................setOptions................ends");

	}
	
	/**
	* This is a getter which returns the options
	*
	* @return options - the options to get
	*/
	public Set<String> getOptions()
	{
		log.info("SecurityQuestion class..........................getOptions................starts/ends");

		return options;
	}	
	
	/**
	*This is a equals method to override
	*
	*@return bool - the boolean value for equals
	*
	*@param obj - takes a parameter of type Object and compares it for equals
	*/
	public boolean equals(Object obj) 
	{
		log.info("SecurityQuestion class..........................equals................starts/ends");

		return ((obj != null) && (obj instanceof SecurityQuestion) && (this.getQuestionId() == ((SecurityQuestion)obj).getQuestionId())); 
	}
}