package com.lxisoft.wayout.domain;
import java.util.*;
import java.util.logging.Logger;
import java.util.logging.Level;
/**
*@author Arya
*It is a  model class for SecurityQuestion
*/
public class SecurityQuestion
{
	Logger logger = Logger.getLogger(SecurityQuestion.class.getName());
	
	private String Question;
	
	private ArrayList<String> Options=new ArrayList<String>();
	private String Answer;
	/**
	*@param question
	*is used to set the value for question
	*/
	public void setQuestion(String question)
	{
		logger.info("enter into method setQuestion"+logger.getName());
		this.Question=question;
		logger.info("leave from method setQuestion"+logger.getName());
	}
	/**
	*@return Question
	*retrive the value of Question
	*/
	public String getQuestion()
	{
		logger.info("enter into method getQuestion"+logger.getName());
		logger.info("leave from method getQuestion"+logger.getName());
		return Question;
	}
	/**
	*@param options
	*method to set the options
	*/
	public void setOptions(ArrayList<String> options)
	{
		logger.info("enter into method setOptions"+logger.getName());
		this.Options=options;
		logger.info("leave from method setOptions"+logger.getName());
	}
	/**
	*@return Options
	*retrive the value of Options
	*/
	public ArrayList<String> getOptions()
	{
		logger.info("enter into method getOptions"+logger.getName());
		logger.info("leave from method getOptions"+logger.getName());
		return Options;
	}
	/**
	*@param answer
	*method to set the answer
	*/
	public void setAnswer(String answer)
	{
		logger.info("enter into method setAnswer"+logger.getName());
		this.Answer=answer;
		logger.info("leave from method setAnswer"+logger.getName());
	}
	/**
	*@return Answer
	*method to retrive the value Answer
	*/
	public String getAnswer()
	{
		logger.info("enter into method getAnswer"+logger.getName());
		logger.info("leave from method getAnswer"+logger.getName());
		return Answer;
	}
}