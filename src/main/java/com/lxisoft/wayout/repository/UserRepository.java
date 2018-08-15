package com.lxisoft.wayout.repository;

/**import required java**/
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import java.util.logging.*;
import org.apache.log4j.Logger;
import com.lxisoft.wayout.domain.*;
import com.lxisoft.wayout.model.*;
import javax.naming.*;
import javax.sql.DataSource;

/**
*class defines database connection 
*and also declares all crude operation of User
*@author Neeraja M
*@version $0.2$
**/

public class UserRepository{


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

	PreparedStatement stmt;

	Statement statement;

	/**
	*Reference to the Context
	*/

	private Context context;

	/**
	*Reference to the User
	*/


	User user=new User();

	/**
	*Reference to the logger
	*
	**/

	private Logger logger=Logger.getLogger(SecurityQuestionRepository.class.getName());

	/**
	*an intial block that give basic database connection
	**/
	{
		logger.info("]]]]]]]]]]]]]]]]]]]UserRepository/initial block starting[[[[[[[[[[[[[[[[[[");
		try
		{
			context=new InitialContext();
			dataSource=(DataSource)context.lookup("java:comp/env/jdbc/datasource");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("]]]]]]]]]]]]]]]]]]]UserRepository/initial block ending[[[[[[[[[[[[[[[[[[");

	}

public void addNewUser(User user){
	logger.info("============Entered into addNewUser method in UserRepository===========");
	PreparedStatement stmt;
	String username=user.getUsername();
	String password=user.getPassword();
	String userRole=user.getRole();

	try
		{
			logger.info("============Entered into try block of save method UserRepository===========");
			//ResultSet rs1;
			connection=dataSource.getConnection();
			stmt=connection.prepareStatement("insert into users(username,password) values('"+username+"','"+password+"'); insert into user_roles(username,userrole)values('"+username+"','"+userRole+"');");
			int a = stmt.executeUpdate();
			//stmt=connection.prepareStatement("insert into user_roles(username,userrole)values('"+username+"','"+userRole+"');");
			//int rs1=stmt.executeUpdate();
			connection.close();
			logger.info("============completed addNewUser method in UserRepository===========");
		}
		catch(Exception e){
			logger.info("============exception in addNewUser method in UserRepository===========");
			e.printStackTrace();

		}
}

public User findOneUser(String username){
	logger.info("============entering  findOneUser method in UserRepository===========");
	PreparedStatement stmt;
	ResultSet rs;
	try{
		logger.info("============entering try block of FindOneUser method in UserRepository===========");
		connection=dataSource.getConnection();
		stmt=connection.prepareStatement("select users.username,users.password,user_roles.role from users inner join user_roles where users.username='"+username+"' && user_roles.username='"+username+"';");
		rs=stmt.executeQuery();
	while(rs.next()){
		String t_username=rs.getString(1);
		String password=rs.getString(2);
		String role=rs.getString(3);

		user.setUsername(t_username);
		user.setPassword(password);
		user.setRole(role);
		logger.info("============exiting try block of updateUser method in UserRepository===========");
	}
	connection.close();

}
catch(Exception e){
	e.printStackTrace();
}
logger.info("============exiting findOneUser method in UserRepository===========");
return user;




}

public void updateUser(User user,String oldUsername){
	logger.info("============entering updateUser method in UserRepository===========");
	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.."+oldUsername);
	PreparedStatement stmt1;
	PreparedStatement stmt2;
	try{
		logger.info("============entering try block of the updateUser method in UserRepository===========");

		connection=dataSource.getConnection();
		String username=user.getUsername();
		String password=user.getPassword();
		stmt1=connection.prepareStatement("update users set username='"+user.getUsername()+"',password='"+user.getPassword()+"'where username='"+oldUsername+"';" );
		stmt2=connection.prepareStatement("update user_roles set username='"+user.getUsername()+"', role='admin' where username='"+oldUsername+"';");
		int a=stmt1.executeUpdate();
		int b=stmt2.executeUpdate();
		connection.close();
		logger.info("============exiting try block of the updateUser method in UserRepository===========");
	}
	catch(Exception e){
		e.printStackTrace();
	}
	logger.info("============exiting  updateUser method in UserRepository===========");


}

public void delete(User user){
	logger.info("============entering updateUser method in UserRepository===========");
	PreparedStatement stmt;
	ResultSet rs;
	try{
		logger.info("============entering try block of updateUser method in UserRepository===========");
		connection=dataSource.getConnection();
		stmt=connection.prepareStatement("delete from users where username='"+user.getUsername()+"';delete from user_roles where username='"+user.getUsername()+"';");
		rs=stmt.executeQuery();
		logger.info("============exiting try block of updateUser method in UserRepository===========");
	}
	catch(Exception e){
		e.printStackTrace();
	}
	logger.info("============exiting updateUser method in UserRepository===========");
}

public TreeSet<User> findAllUser(){
	logger.info("============entering findAllUser method in UserRepository===========");

	TreeSet<User> userset=new TreeSet<User>();
	PreparedStatement stmt;
		try{
			logger.info("============entering try block of findAllUser method in UserRepository===========");
			connection=dataSource.getConnection();

			stmt=connection.prepareStatement("select users.username,users.password,user_roles.role from users inner join user_roles on users.username=user_roles.username;");

			ResultSet rs2=stmt.executeQuery();
			
			while(rs2.next()){
				User user=new User();
				String username=rs2.getString(1);
				String password=rs2.getString(2);
				String role=rs2.getString(3);

				user.setUsername(username);
				user.setPassword(password);
				user.setRole(role);
				userset.add(user);


		}
		connection.close();
		logger.info("============exiting try block of findAllUser method in UserRepository===========");

	}
		catch(Exception e){
			e.printStackTrace();
		}
		logger.info("============exiting findAllUser method in UserRepository===========");

		return userset;
		
	}

	
}
