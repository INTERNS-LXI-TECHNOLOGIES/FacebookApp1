package com.lxisoft.wayout.service;
/**
* service interface for adding new user
* 
*@author Neeraja.M
*
*@version $0.2$
**/
import com.lxisoft.wayout.model.*;
import com.lxisoft.wayout.domain.*;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import java.util.*;
import org.apache.log4j.Logger;


public interface UserService 
{
/**
* save an user
*@param user this is the new user
**/
public void addUser(User user);


/**
* to get an user
*@param username this is the username of the user
*
*@return User
**/
public User findOne(String username);

/**
* to edit user details
*@param user this is the User
*
*@param oldUsername this is the old username of the user
**/
public void editUser(User user,String oldUsername);

/**
* to delete user details
*@param user this is the User
*
**/
public void deleteUser(User user);

public TreeSet<User> findAllUser();



}