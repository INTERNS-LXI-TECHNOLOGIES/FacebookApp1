package com.lxisoft.wayout.service.impl;
import com.lxisoft.wayout.service.*;

/**
*
*import required java libraries
*
**/

import java.util.*;
/**
* importing log4j 
*
**/
import org.apache.log4j.Logger;


/**importing all repository class**/

import com.lxisoft.wayout.repository.*;

/**importing  all domain classes**/

import com.lxisoft.wayout.domain.*;

/**importing all model classes**/

import com.lxisoft.wayout.model.*;

/**
*service implementation for managing Security questions
*@author Neeraja.M 
*@version 1.0
**/

/**
*
* Referance to UserRepository
*
*/ 


public class UserServiceImpl implements UserService{

	UserRepository userRepository=new UserRepository();

public void addUser(User user){

userRepository.addNewUser(user);
}

public User findOne(String username){
	User user=userRepository.findOneUser(username);
	return user;
}

public void editUser(User user,String oldUsername){
	userRepository.updateUser(user,oldUsername);
}

public void deleteUser(User user){
	userRepository.delete(user);
}

public TreeSet<User> findAllUser(){
TreeSet<User> allUsers=(TreeSet<User>)userRepository.findAllUser();
return allUsers;
}

}