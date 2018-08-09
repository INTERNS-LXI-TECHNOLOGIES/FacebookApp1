package com.lxisoft.wayout.repository;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import java.util.logging.*;
import org.apache.log4j.Logger;
import com.lxisoft.wayout.model.GameConfiguration;
import javax.naming.*;
import javax.sql.DataSource;


/**
*@author Ruhail
*servlet class to take data for game configuration repository; 
*
*@version 1.0
*@since 08-08-2018
*/ 
public class GameConfigurationRepository
{
	/**
	*Connection reference
	*/ 
	Connection connection;
	/**
	*DataSource reference
	*/ 
	DataSource dataSource;
	/**
	*Contaxt reference
	*/ 
	Context context;
	/**
	*PreparedStatement reference
	*/ 
	PreparedStatement ps;
	/**
	*ResultSet reference
	*/ 
	ResultSet rs;
	/**
	*Logger reference
	*/ 
	private static final Logger log = Logger.getLogger(GameConfigurationRepository.class.getName()); 
	
	/**
	 * constructor for setting up database connection lookup.
	 */
	public GameConfigurationRepository()
	{
		log.info("-----GameConfigurationRepository costructor started---------");
		try
		{
			context=new InitialContext();
			dataSource=(DataSource)context.lookup("java:comp/env/jdbc/datasource");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		log.info("-----GameConfigurationRepository costructor ended---------");
	}
	/**
	 * method for selecting one raw from game_configuration table
	 *@param gameConfiguration
	 *@return 1 or 0
	 */
	public int findOne(GameConfiguration gameConfiguration)
	{
		log.info("-----GameConfigurationRepository findOne started---------");
		try
		{
			connection = dataSource.getConnection();
			ps = connection.prepareStatement("select * from game_configuration where game_mode='"+gameConfiguration.getGameMode()+"'");
			rs = ps.executeQuery();
			if(rs.next())
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return 0;
		}
	}
	/**
	 * method for updating one raw in game_configuration table
	 *@param gameConfiguration
	 *@return a
	 */
	public int update(GameConfiguration gameConfiguration)
	{
		log.info("-----GameConfigurationRepository update started------------------");
		int a=0;
		try
		{
			connection = dataSource.getConnection();
			ps = connection.prepareStatement("update game_configuration set keys_count='"+gameConfiguration.getKeysCount()+"',halls_count='"+gameConfiguration.getHallsCount()+"',question_time = '"+gameConfiguration.getQuestionTime()+"',game_time='"+gameConfiguration.getGameTime()+"',game_mode='"+gameConfiguration.getGameMode()+"' where game_mode='"+gameConfiguration.getGameMode()+"'");
			a = ps.executeUpdate();
			log.info("-----GameConfigurationRepository update ended---------");
		}
		catch(Exception ex)
		{
			log.warn("-----GameConfigurationRepository cupdate exception---------");
			ex.printStackTrace();
		}
		return a;
	}
	/**
	 * method for inserting one raw to game_configuration table
	 *@param gameConfiguration
	 *@return a
	 */
	public int insert(GameConfiguration gameConfiguration)
	{
		log.info("-----GameConfigurationRepository insert started---------");
		int a=0;
		try
		{
			connection = dataSource.getConnection();
			ps = connection.prepareStatement("insert into game_configuration(keys_count,halls_count,question_time,game_time,game_mode) values('"+gameConfiguration.getKeysCount()+"','"+gameConfiguration.getHallsCount()+"','"+gameConfiguration.getQuestionTime()+"','"+gameConfiguration.getGameTime()+"','"+gameConfiguration.getGameMode()+"')");
			a = ps.executeUpdate();
			log.info("-----GameConfigurationRepository insert ended---------");
		}
		catch(Exception ex)
		{
			log.warn("-----GameConfigurationRepository insert exception---------");
			ex.printStackTrace();
		}
		return a;
	}
}