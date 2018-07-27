package com.lxisoft.wayout.service;
/*// import required java libaries*/
import java.util.*;
/* import all nessery models**/
import com.lxisoft.wayout.domain.SecurityQuestion;
/**
* service interface for maping questions
* 
*@author Sooraj pn
*
*@version $0.1$
**/

public interface SecurityQuestionService{

/**
*Get all questions
*
*@return the Set of questions
**/ 
//public Set<Question> getAllquestions();

/**
* save a Question
*@param question this is the question we are going to add Question
**/

public void addSecurityQuestion(SecurityQuestion question);

/**
*Update a question
*
*@param  question this question is replaced by the current Question
*
**/

public void updateSecurityQuestion(SecurityQuestion question);

/**
*Delete a Question 
*
*@param question  this question is deleted
**/

public void deleteSecurityQuestion(SecurityQuestion question);

/**
* find a Question 
*
*@param id find the curresponding Question by given id
*
*@return securityQuestion
**/
public SecurityQuestion findSecurityQuestion(Long id);

/**
* get all Question 
*
*@return setOfSecurityQuestions 
**/
public Set<SecurityQuestion> findAllSecurityQuestion();


}