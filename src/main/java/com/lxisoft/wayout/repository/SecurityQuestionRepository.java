package com.lxisoft.wayout.repository;

/**import required java**/
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import java.util.logging.*;
import org.apache.log4j.Logger;
import com.lxisoft.wayout.domain.*;
import javax.naming.*;
import javax.sql.DataSource;

/**
*class defines database connection 
*and also declares all crude operation in database
*@author Sooraj pn
*@version $1.0$
**/

public class SecurityQuestionRepository{

	/*
	* Refernce for the datasource
	*/

	private DataSource dataSource;

	/*
	*Reference to the connection 
	*/
	private Connection connection;

	/**
	*Reference to the Stetement 
	**/

	PreparedStatement stmt;

	Statement statement;

	/**
	*Reference to the Context
	*/

	private Context context;

	/**
	*Reference to the logger
	*
	**/

	private Logger logger=Logger.getLogger(SecurityQuestionRepository.class.getName());

	/**
	*an intial block that give basic database connection
	**/
	{
		logger.info("]]]]]]]]]]]]]]]]]]]SecurityQuestionRepository/initial block starting[[[[[[[[[[[[[[[[[[");
		try
		{
			context=new InitialContext();
			dataSource=(DataSource)context.lookup("java:comp/env/jdbc/datasource");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("]]]]]]]]]]]]]]]]]]]SecurityQuestionRepository/initial block ending[[[[[[[[[[[[[[[[[[");

	}


	/**
	*to add a SecurityQuestion 
	*@param securityQuestion to an security question to database
	**/


	public void save(SecurityQuestion securityQuestion){
		
		ResultSet rs = null;
		int optionId=0,questionId=0;
		Set<Integer> optionIds=new HashSet<Integer>();
		
		try
		{
 
			logger.info("============Entered into SecurityQuestionRepository/addSecurityQuestion()===========");
			
			connection=dataSource.getConnection();
			
			Set<String> options=securityQuestion.getOptions();
			
			for(String opt:options){
				
				System.out.println(opt);
			}
				for(String opt:options){
			
					stmt=connection.prepareStatement("Insert into question_option (opt) values(?)",Statement.RETURN_GENERATED_KEYS);
					stmt.setString(1,opt);
					stmt.executeUpdate();
					rs=stmt.getGeneratedKeys();
					
					if(rs != null && rs.next()){
					
						optionId=rs.getInt(1);
					}
					optionIds.add(optionId);
					
					stmt.close();
			}
			
			logger.info("============question options inserted===========");
			
			stmt=connection.prepareStatement("INSERT INTO security_question (image_path,question,answer) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,securityQuestion.getImageUrl());
			stmt.setString(2,securityQuestion.getQuestion());
			stmt.setString(3,securityQuestion.getAnswer());
			
			stmt.executeUpdate(); 
			rs = stmt.getGeneratedKeys();
			
			if(rs != null && rs.next()){
                questionId=rs.getInt(1);
            }
			
			saveToSecurityQuestionOptions(questionId,optionIds);
           
			connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("============Exited from  SecurityQuestionRepository/addSecurityQuestion()===========");

	}


	/**
	*to delete SecurityQuestion
	*@param securityQuestion the given question is deleted;
	**/

	public void delete(SecurityQuestion securityQuestion){

	PreparedStatement stmt;
	
		logger.info("============Entered into SecurityQuestionRepository/delete()===========");
		try
		{
			
			connection=dataSource.getConnection();
			stmt=connection.prepareStatement("delete from security_question where id=?");
			stmt.setLong(1,securityQuestion.getQuestionId());
			
			stmt.executeUpdate();
			
			connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("============Exit from SecurityQuestionRepository/delete()===========");
	}

	/**
	* @param securityQuestion securityQuestion to be updated
	**/

	public void update(SecurityQuestion securityQuestion){

		logger.info("============Entered into SecurityQuestionRepository/updateSecurityQuestion()===========");
 		delete(securityQuestion);
		save(securityQuestion);		
		logger.info("============Exited from  SecurityQuestionRepository/update()===========");
		
	}
	/**
	* to find SecurityQuestion by using an unique key
	* @param id id of securityQuestion
	* @return securityQuestion 
	**/

public SecurityQuestion findOne(Long id){
		SecurityQuestion securityQuestion=new SecurityQuestion();
		PreparedStatement stmt;
		
		logger.info("============Entered into SecurityQuestionRepository/findOne() with id="+id+"===========");
		try
		{
			connection=dataSource.getConnection();
			stmt=connection.prepareStatement("select sq.id,sq.image_path,sq.question,sq.answer,GROUP_CONCAT(DISTINCT qo.opt SEPARATOR ',') as opt from question_option qo inner join security_question_options sqo on qo.id = sqo.option_id inner join security_question sq on sqo.question_id = sq.id where sq.id=? group by sq.id");
			
			stmt.setLong(1,id);
			
			ResultSet resultSet=stmt.executeQuery();
			while(resultSet.next())
			{

					securityQuestion.setQuestionId((long)resultSet.getInt("id"));
					securityQuestion.setImageUrl(resultSet.getString("image_path"));
					securityQuestion.setQuestion(resultSet.getString("question"));
					securityQuestion.setAnswer(resultSet.getString("answer"));
					String questionOptions=resultSet.getString("opt");
					
					Set<String> opt=new HashSet<String>(Arrays.asList(questionOptions.split(",")));
					
					securityQuestion.setOptions(opt);		
					
			}
			connection.close();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("============Exited from  SecurityQuestionRepository/findOne()===========");
		
		return securityQuestion;
	}


	/**
	*to find SecurityQuestion
	*@return securityQuestions
	**/
		public Set<SecurityQuestion> findAll(){

	//SecurityQuestion securityQuestion=new SecurityQuestion();
	
		Set<SecurityQuestion> securityQuestions=new HashSet<SecurityQuestion>();
		List<String> options=new ArrayList<String>();
		logger.info("============Entered into SecurityQuestionRepository/findAll() with no id==========");
		try
		{
			context=new InitialContext();
			dataSource=(DataSource)context.lookup("java:comp/env/jdbc/datasource");
			connection=dataSource.getConnection();
			statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select sq.id,sq.image_path,sq.question,sq.answer,GROUP_CONCAT(DISTINCT qo.opt SEPARATOR ',') as opt from security_question sq inner join security_question_options sqo on sqo.question_id = sq.id inner join question_option qo on sqo.option_id = qo.id group by sq.id");
			
			
			while(resultSet.next())
				
				{	
					SecurityQuestion securityQuestion=new SecurityQuestion();
	
					securityQuestion.setQuestionId((long)resultSet.getInt("id"));
					securityQuestion.setImageUrl(resultSet.getString("image_path"));
					securityQuestion.setQuestion(resultSet.getString("question"));
					securityQuestion.setAnswer(resultSet.getString("answer"));
					String questionOptions=resultSet.getString("opt");
					
					Set<String> opt=new HashSet<String>(Arrays.asList(questionOptions.split(",")));
					//options.addAll(opt);
		
					securityQuestion.setOptions(opt);		
					securityQuestions.add(securityQuestion);
				
				}				
				
			for(SecurityQuestion securityquestion:securityQuestions){
				System.out.println("*************"+securityquestion.getQuestionId());
				System.out.println("*************"+securityquestion.getQuestion());
				System.out.println("*************"+securityquestion.getAnswer());
				System.out.println("*************"+securityquestion.getImageUrl());
				System.out.println("*************"+securityquestion.getOptions());
					
			}
					
			connection.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();			
			logger.info("eeeeeeeeeeeeeeeeeeeeee"+e);
		}
		logger.info("============Exited from  SecurityQuestionRepository/findAll()===========");
		
		return securityQuestions;
	}

	public void saveToSecurityQuestionOptions(int questionId,Set<Integer> optionIds){
		
		for(Integer optionId:optionIds){
			
			try{
			stmt=connection.prepareStatement("Insert into security_question_options (question_id,option_id) values(?,?)");
			stmt.setInt(1,questionId);
			stmt.setInt(2,optionId);
			
			stmt.executeUpdate();
			stmt.close();
	
			}catch(Exception ex){
				ex.printStackTrace();
				logger.info("eeeeeeeeeeeeeeeeeeeeee"+ex);
	
			}
		}
	}
} 
 