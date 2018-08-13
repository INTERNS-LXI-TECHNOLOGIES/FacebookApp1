//Import required java libraries
package com.lxisoft.wayout.domain;

import java.util.*;

import java.util.logging.*;

/**
* This UserModel class is used to set and get the variables.

*@author Deepthi E

*@author Balagopal V

*/

public class User implements Comparable<User>
{
	
	private final static Logger logger = Logger.getLogger(User.class.getName());
	/**
	 * The variable userName is used to hold a String value userName.

	 * The variable password is used to hold a String value password.
	 */
	 
	private String username,password,role;

	/**
	 *Set the value of userName.
	 
	 *@param username variable used to pass the value of userName.
	 
	 */
	public void setUsername(String username)
	{
		logger.fine("Entered into the method setUsername "+logger.getName());
	
		this.username=username;
	
		logger.fine("Exit from the method setUsername "+logger.getName());
	}
	/**
	 *Retrieve the value of userName.
	 
	 *@return userName variable used to return the String value userName.
	 */
	public String getUsername()
	{
		logger.fine("Entered into the method getUsername "+logger.getName());
		
		return username;
	}
	/**
	 *Set the value of password.
	 
	 *@param password variable used to pass the value of password.
	 */
	public void setPassword(String password)
	{
		logger.fine("Entered into the method setPassword "+logger.getName());
		
		this.password=password;
		
		logger.fine("Exit from the method setPassword "+logger.getName());
	}
	/**
	 *Retrieve the value of password.
	 
	 *@return password variable used to return the String value password.
	 */
	public String getPassword()
	{
		logger.fine("Entered into the method getPassword "+logger.getName());
		
		return password;
	}
	/**
	 *Set the value of role.
	 
	 *@param role variable used to pass the value of role.
	 */
	public void setRole(String role)
	{
		logger.fine("Entered into the method setRole "+logger.getName());
		
		this.role=role;
		
		logger.fine("Exit from the method setRole "+logger.getName());
	
	}
	/**
	 *Retrieve the value of role.
	 
	 *@return role variable used to return the String value role.
	 */
	public String getRole()
	{
		logger.fine("Entered into the method getRole "+logger.getName());
		
		return role;
	}
	public int compareTo(User user)
	{  
		return this.username.compareTo(user.getUsername());  
	}  
	}