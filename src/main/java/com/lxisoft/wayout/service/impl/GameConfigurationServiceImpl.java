package com.lxisoft.wayout.service.impl;
import com.lxisoft.wayout.model.GameConfiguration;
import java.util.logging.*;
import com.lxisoft.wayout.repository.GameConfigurationRepository;
import com.lxisoft.wayout.service.GameConfigurationService;

public class GameConfigurationServiceImpl implements GameConfigurationService
{
	/**
	*Logger reference
	*/ 
	private static final Logger log = Logger.getLogger(GameConfigurationServiceImpl.class.getName()); 
	/**
	*GameConfigurationRepository object reference
	*/ 
	GameConfigurationRepository repo=new GameConfigurationRepository();
	/**
	*Mthod for calling repository class methods for certain table manipulation
	@param gameConfiguration
	*/ 
	public void configureGame(GameConfiguration gameConfiguration)
	{
		int res=repo.findOne(gameConfiguration);
		if(res==1)
		{
			repo.update(gameConfiguration);
		}
		else
		{
			repo.insert(gameConfiguration);
		}
	}
}