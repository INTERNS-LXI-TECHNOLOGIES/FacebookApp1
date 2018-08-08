package com.lxisoft.wayout.service;
import com.lxisoft.wayout.model.GameConfiguration;

/**
*@author Ruhail
*servlet class to take data for game configuration repository; 
*
*@version 1.0
*@since 08-08-2018
*/
public interface GameConfigurationService
{
	/**
	*abstract method 
	*/ 
	public void configureGame(GameConfiguration gameConfiguration);
}