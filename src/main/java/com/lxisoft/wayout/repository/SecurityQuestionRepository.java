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

		try
		{
 
			logger.info("============Entered into SecurityQuestionRepository/addSecurityQuestion()===========");
			
			connection=dataSource.getConnection();
			statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from securityQuestion;"); 
			Long id=securityQuestion.getQuestionId();
			if(id==0)
			{
				id=1l;
				while(resultSet.next())
				{

					id=(resultSet.getInt(1)+1l);	

				}
			}
			List<String>options=new ArrayList(securityQuestion.getOptions());
			statement.execute("insert into securityQuestion values("+id+",'"+securityQuestion.getQuestion()+"','"+options.get(0)+"','"+options.get(1)+"','"+options.get(2)+"','"+securityQuestion.getAnswer()+")");
			
			connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("============Exited from  SecurityQuestionRepository/addSecurityQuestion()===========");

	}


	/**
	*to dlete SecurityQuestion
	*@param securityQuestion the given question is deleted;
	**/

	public void delete(SecurityQuestion securityQuestion){

		logger.info("============Entered into SecurityQuestionRepository/addSecurityQuestion()===========");
		try
		{
			
			connection=dataSource.getConnection();
			statement=connection.createStatement();
			
			statement.execute("delete from securityQuestion where id="+securityQuestion.getQuestionId()+"");
			
			connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	/**
	* @param securityQuestion securityQuestion to be updated
	**/

	public void update(SecurityQuestion securityQuestion){

		logger.info("============Entered into SecurityQuestionRepository/updateSecurityQuestion()===========");
 		logger.info("OOOOOOOOsecurityQuestion"+securityQuestion+"OOOOOOOO");
		delete(securityQuestion);
		save(securityQuestion);		
		logger.info("============Exited from  SecurityQuestionRepository/updateSecurityQuestion()===========");
		
	}
	/**
	* to find SecurityQuestion by using an unique key
	* @param id id of securityQuestion
	* @return securityQuestion 
	**/

public SecurityQuestion findOne(Long id){
		SecurityQuestion securityQuestion=new SecurityQuestion();
		logger.info("============Entered into SecurityQuestionRepository/updateSecurityQuestion() with id="+id+"===========");
		try
		{
			connection=dataSource.getConnection();
			statement=connection.createStatement();

			ResultSet resultSet=statement.executeQuery("select from securityQuestion where id="+id);
			while(resultSet.next())
			{

					securityQuestion.setQuestionId(resultSet.getInt(1));
					securityQuestion.setQuestion(resultSet.getString(2));
					Set<String>options=new TreeSet<String>();
					options.add(resultSet.getString(3));
					options.add(resultSet.getString(4));
					options.add(resultSet.getString(5));
					securityQuestion.setOptions(options);
					securityQuestion.setAnswer(resultSet.getString(6));

			}
			connection.close();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("============Exited from  SecurityQuestionRepository/updateSecurityQuestion()===========");
		
		return securityQuestion;
	}


	/**
	*to find SecurityQuestion
	*@return securityQuestions
	**/

public Set<SecurityQuestion> findAll(){

		Set<SecurityQuestion>securityQuestions=new TreeSet<SecurityQuestion>();
		logger.info("============Entered into SecurityQuestionRepository/updateSecurityQuestion() with no id==========");
		try
		{
			connection=dataSource.getConnection();
			statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from securityquestion;" );
			while(resultSet.next())
			{

		
				SecurityQuestion securityQuestion=new SecurityQuestion();
				securityQuestion.setQuestionId(resultSet.getInt(1));
				securityQuestion.setQuestion(resultSet.getString(2));
				Set<String>options=new TreeSet<String>();
				options.add(resultSet.getString(3));
				options.add(resultSet.getString(4));
				options.add(resultSet.getString(5));
				securityQuestion.setOptions(options);
				securityQuestion.setAnswer(resultSet.getString(6));
				logger.info("============"+securityQuestion+"===========");
				securityQuestions.add(securityQuestion);
			}
			connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();			
				logger.info("eeeeeeeeeeeeeeeeeeeeee"+e);
		}
		logger.info("============Exited from  SecurityQuestionRepository/updateSecurityQuestion()===========");
		
		return securityQuestions;
	}


} 
 