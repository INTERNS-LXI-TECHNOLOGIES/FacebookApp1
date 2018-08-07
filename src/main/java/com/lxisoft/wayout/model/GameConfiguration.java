package com.lxisoft.wayout.model;
public class GameConfiguration
{
	private Integer keysCount;
	private Integer hallsCount;
	private Integer questionTime;
	private Integer gameTime;
	private String gameMode;
	
	public void setKeysCount(Integer keysCount)
	{
		this.keysCount = keysCount;
	}
	public Integer getKeysCount()
	{
		return this.keysCount;
	}
	public void setHallsCount(Integer hallsCount)
	{
		this.hallsCount = hallsCount;
	}
	public Integer getHallsCount()
	{
		return this.hallsCount;
	}
	public void setQuestionTime(Integer questionTime)
	{
		this.questionTime = questionTime;
	}
	public Integer getQuestionTime()
	{
		return this.questionTime;
	}
	public void setGameTime(Integer gameTime)
	{
		this.gameTime = gameTime;
	}
	public Integer getGameTime()
	{
		return this.gameTime;
	}
	public void setGameMode(String gameMode)
	{
		this.gameMode = gameMode;
	}
	public String getGameMode()
	{
		return this.gameMode;
	}
}