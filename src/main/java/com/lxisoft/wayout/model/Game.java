package com.lxisoft.wayout.model;

import com.lxisoft.wayout.domain.*;

import java.util.logging.*;
/**
*@author Ruhail
*
*model class for Game
*
*/
public class Game
{
	/**
	*prisoner who has to escape in game.
	*/
	private Prisoner prisoner;
	/**
	*number of keys in hand of prisoner.
	*/
	private int numberOfKeys;
	/**
     * Reference to Logger class to get log messages
     */
	private static final Logger log=Logger.getLogger(Game.class.getName());
	/**
	 * setter for prisoner
	 * @param prisoner the man who is trapped at the prison
	 */
	public void setPrisoner(Prisoner prisoner)
	{
		log.info("Game class..........................setPrisoner................starts");

		this.prisoner=prisoner;

		log.info("Game class..........................setPrisoner................ends");
	}
	/**
	 * getter for prisoner
	 * @return prisoner return prisoner object
	 */
	public Prisoner getPrisoner()
	{
		log.info("Game class..........................getPrisoner................starts");

		return this.prisoner;
		
	}
	/**
	 * setter for numberOfKeysInHand.
	 * @param numberOfKeys no of keys in hand of prison .
	 */
	public void setNumberOfKeysInHand(int numberOfKeys)
	{
		log.info("Game class..........................setNumberOfKeysInHand................starts");

		this.numberOfKeys=numberOfKeys;

		log.info("Game class..........................setNumberOfKeysInHand................ends");
	}
	/**
	 * getter for numberOfKeysInHand.
	 * @return  numberOfKeys get no of keys.
	 */
	public int getNumberOfKeys()
	{
		log.info("Game class..........................getNumberOfKeysInHand................starts");

		return this.numberOfKeys;
		
	}
}

