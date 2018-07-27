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
	*to add a SecurityQuestion 
	*@param securityQuestion save to database
	**/

	public void addSecurityQuestion(SecurityQuestion securityQuestion){

		try
		{
 
			logger.info("============Entered into SecurityQuestionRepository/addSecurityQuestion()===========");
			context=new InitialContext();
			dataSource=(DataSource)context.lookup("java:comp/env/jdbc/datasource");
			connection=dataSource.getConnection();
			statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from securityQuestion;");
			Long id=1l;
			while(resultSet.next())
			{

				id=(resultSet.getInt(1)+1l);	

			}
			List<String>options=new ArrayList(securityQuestion.getOptions());
			statement.execute("insert into contacts values("+id+",'"+securityQuestion.getQuestion()+"','"+options.get(0)+"','"+options.get(1)+"','"+options.get(2)+"','"+securityQuestion.getAnswer()+")");
			
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
	*@param securityQuestion;
	**/

	public void deleteSecurityQuestion(SecurityQuestion securityQuestion){

		logger.info("============Entered into SecurityQuestionRepository/addSecurityQuestion()===========");
		try
		{
			context=new InitialContext();
			dataSource=(DataSource)context.lookup("java:comp/env/jdbc/datasource");
			connection=dataSource.getConnection();
			statement=connection.createStatement();
			
			statement.execute("delete from answerkey where id="+securityQuestion.getQuestionId()+"");
			
			connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	/**
	* to delete SecurityQuestion
	* @param securityQuestion securityQuestion to be updated
	**/

	public void updateSecurityQuestion(SecurityQuestion securityQuestion){

		logger.info("============Entered into SecurityQuestionRepository/updateSecurityQuestion()===========");
		try
		{

				context=new InitialContext();
				dataSource=(DataSource)context.lookup("java:comp/env/jdbc/datasource");
				connection=dataSource.getConnection();
				statement=connection.createStatement();
				List<String>options=new ArrayList(securityQuestion.getOptions());
				statement.execute("update answerkey set Question='"+securityQuestion.getQuestion()+"',Option1='"+options.get(0)+"',Option2='"+options.get(1)+"',Option3='"+options.get(2)+"',Option4='"+options.get(3)+"',Answer='"+securityQuestion.getAnswer()+"' where id="+securityQuestion.getQuestionId()+");");
				connection.close();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		
		logger.info("============Exited from  SecurityQuestionRepository/updateSecurityQuestion()===========");
		
	}
	/**
	* to find SecurityQuestion
	* @param id id of securityQuestion
	* @return securityQuestion 
	**/

public SecurityQuestion findSecurityQuestion(Long id){
		SecurityQuestion securityQuestion=new SecurityQuestion();
		logger.info("============Entered into SecurityQuestionRepository/updateSecurityQuestion() with id="+id+"===========");
		try
		{
			context=new InitialContext();
			dataSource=(DataSource)context.lookup("java:comp/env/jdbc/datasource");
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
					options.add(resultSet.getString(6));
					securityQuestion.setOptions(options);
					securityQuestion.setAnswer(resultSet.getString(7));

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

public Set<SecurityQuestion> findAllSecurityQuestion(){

		Set<SecurityQuestion>securityQuestions=new TreeSet<SecurityQuestion>();
		logger.info("============Entered into SecurityQuestionRepository/updateSecurityQuestion() with no id==========");
		try
		{
			context=new InitialContext();
			dataSource=(DataSource)context.lookup("java:comp/env/jdbc/datasource");
			connection=dataSource.getConnection();
			statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from answerkey;" );
			while(resultSet.next())
			{

		
				SecurityQuestion securityQuestion=new SecurityQuestion();
				securityQuestion.setQuestionId(resultSet.getInt(1));
				securityQuestion.setQuestion(resultSet.getString(2));
				Set<String>options=new TreeSet<String>();
				options.add(resultSet.getString(3));
				options.add(resultSet.getString(4));
				options.add(resultSet.getString(5));
				options.add(resultSet.getString(6));
				securityQuestion.setOptions(options);
				securityQuestion.setAnswer(resultSet.getString(7));
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
