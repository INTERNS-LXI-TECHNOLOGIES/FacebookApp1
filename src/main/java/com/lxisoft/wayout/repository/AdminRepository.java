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

public class AdminRepository{

	/*
	* Reference for the datasource
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

	private Logger logger=Logger.getLogger(AdminRepository.class.getName());

	/**
	*an intial block that give basic database connection
	**/
	{
		logger.info("]]]]]]]]]]]]]]]]]]]AdminRepository/initial block starting[[[[[[[[[[[[[[[[[[");
		try
		{
			context=new InitialContext();
			dataSource=(DataSource)context.lookup("java:comp/env/jdbc/datasource");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		logger.info("]]]]]]]]]]]]]]]]]]]adminRepository/initial block ending[[[[[[[[[[[[[[[[[[");

	}
	/**
	*to add a SecurityQuestion 
	*@param user to an security question to database
	**/
	public void update(User user)
	{
		
		logger.info("============Entered into adminRepository/update===========");
		try
		{
			connection=dataSource.getConnection();
			Statement statement=connection.createStatement();
			statement.execute("update user_roles set role='"+user.getRole()+"' where username='"+user.getUsername()+"';");
			connection.close();
			//statement.execute("update user_roles set role='"+user.getRole()+"' where username='"+user.getUsername()+"';");
		}
		catch(Exception ex)
		{
			logger.info("============exception in update method/AdminRepository===========");
			ex.printStackTrace();
		}	
		logger.info("============Exited from adminRepository/update===========");
	}
	
} 