package com.lxisoft.wayout.service.impl;

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
/**
*importing the servic interface
**/
import com.lxisoft.wayout.service.*;

/**importing  SecurityQuestionRepository**/

import com.lxisoft.wayout.repository.AdminRepository;

/**importing  domains**/

import com.lxisoft.wayout.domain.*;



/**
*service implementation for managing Security questions
*@author Sooraj pn 
*@version 1.0
**/
public class AdminServiceImpl implements AdminService{

/**
* Reference to QuestionRepository
**/

private AdminRepository adminRepository=new AdminRepository();

/**
* Reference to Lo gger class to get loggings
**/

private static final Logger log=Logger.getLogger(SecurityQuestionServiceImpl.class.getName());

/**
*implementation for update SecurityQuestion method
*@param user
**/
public void promoteUser(User user)
	{

		log.info("========Enter into AdminServiceImpl/promoteUser()========");

		adminRepository.update(user);

		log.info("========Exiting from AdminServiceImpl/promoteUser()========");

	}

}