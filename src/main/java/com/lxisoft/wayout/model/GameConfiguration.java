package com.lxisoft.wayout.model;

/**
*@author Ruhail
*java model class named GameConfiguration 
*
*@version 1.0
*@since 08-08-2018
*/ 

public class GameConfiguration
{
	/**
	*Count of keys to be added
	*/ 
	private Integer keysCount;
	/**
	*Count of halls to be added
	*/ 
	private Integer hallsCount;
	/**
	*Time of question display
	*/ 
	private Integer questionTime;
	/**
	*Time of game
	*/ 
	private Integer gameTime;
	/**
	*game model
	*/ 
	private String gameMode;
	/**
	 * setter for keys count
	 * @param keysCount for number of super keys
	 */
	public void setKeysCount(Integer keysCount)
	{
		this.keysCount = keysCount;
	}
	/**
	 * getter for keys count
	 * @return keysCount 
	 */
	public Integer getKeysCount()
	{
		return this.keysCount;
	}
	/**
	 * setter for halls count
	 * @param hallsCount for number of halls in prison
	 */
	public void setHallsCount(Integer hallsCount)
	{
		this.hallsCount = hallsCount;
	}
	/**
	 * getter for halls count
	 * @return hallsCount 
	 */
	public Integer getHallsCount()
	{
		return this.hallsCount;
	}
	/**
	 * setter for  question time
	 * @param questionTime for appearing question in window
	 */
	public void setQuestionTime(Integer questionTime)
	{
		this.questionTime = questionTime;
	}
	/**
	 * getter for questionTime
	 * @return questionTime
	 */
	public Integer getQuestionTime()
	{
		return this.questionTime;
	}
	/**
	 * setter for  game time
	 * @param gameTime for game time limit
	 */
	public void setGameTime(Integer gameTime)
	{
		this.gameTime = gameTime;
	}
	/**
	 * getter for game time
	 * @return gameTime
	 */
	public Integer getGameTime()
	{
		return this.gameTime;
	}
	/**
	 * setter for  game mode
	 * @param gameMode for game mode.
	 */
	public void setGameMode(String gameMode)
	{
		this.gameMode = gameMode;
	}
	/**
	 * getter for game mode
	 * @return gameMode
	 */
	public String getGameMode()
	{
		return this.gameMode;
	}
}