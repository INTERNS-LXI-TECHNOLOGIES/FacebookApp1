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
import com.lxisoft.wayout.service.SecurityQuestionService;

/**importing  SecurityQuestionRepository**/

import com.lxisoft.wayout.repository.SecurityQuestionRepository;

/**importing  SecurityQuestion**/

import com.lxisoft.wayout.domain.SecurityQuestion;

/**
*service implementation for managing Security questions
*@author Sooraj pn 
*@version 1.0
**/
public class SecurityQuestionServiceImpl implements SecurityQuestionService{

/**
* Reference to QuestionRepository
**/

private SecurityQuestionRepository securityQuestionRepository=new SecurityQuestionRepository();

/**
* Reference to Lo gger class to get loggings
**/

private static final Logger log=Logger.getLogger(SecurityQuestionServiceImpl.class.getName());

/**
*implementation for addSecurityQuestion method
**/
public void addSecurityQuestion(SecurityQuestion securityQuestion){
	log.info("========Enter into questionServce/addSecurityQuestion()========");
	
	log.info("========Exiting from questionServce/addSecurityQuestion()========");
	securityQuestionRepository.save(securityQuestion);
}

/**
*implementation for deleteSecurityQuestion method
**/
public void deleteSecurityQuestion(SecurityQuestion securityQuestion){
	log.info("========Enter into questionServce/deleteSecurityQuestion()========");
	
	log.info("========Exiting from questionServce/deleteSecurityQuestion()========");
	securityQuestionRepository.delete(securityQuestion);
}

/**
*implementation for update SecurityQuestion method
**/
public void updateSecurityQuestion(SecurityQuestion securityQuestion){
	log.info("========Enter into questionServce/updateSecurityQuestion()========");
	securityQuestionRepository.update(securityQuestion);
	log.info("========Exiting from questionServce/updateSecurityQuestion()========");
}

public SecurityQuestion findSecurityQuestion(Long id){
	log.info("========Enter into questionServce/findSecurityQuestion()========");
	
	log.info("========Exiting from questionServce/findSecurityQuestion()========");
	return securityQuestionRepository.findOne(id);
}

public Set<SecurityQuestion> findAllSecurityQuestion(){

	log.info("========Enter into questionServce/findAllSecurityQuestion()========");
	
	log.info("========Exiting from questionServce/findAllSecurityQuestion()========");
	return securityQuestionRepository.findAll();

	}
}


