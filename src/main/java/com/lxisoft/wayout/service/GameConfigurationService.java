package com.lxisoft.wayout.service;
import com.lxisoft.wayout.model.GameConfiguration;
import java.util.logging.*;
import com.lxisoft.wayout.repository.GameConfigurationRepository;

public class GameConfigurationService 
{
	private static final Logger log = Logger.getLogger(GameConfigurationService.class.getName()); 
	GameConfigurationRepository repo=new GameConfigurationRepository();
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