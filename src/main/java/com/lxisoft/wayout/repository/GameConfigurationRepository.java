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

public class GameConfigurationRepository
{
	Connection connection;
	DataSource dataSource;
	Context context;
	PreparedStatement ps;
	ResultSet rs;
	private static final Logger log = Logger.getLogger(GameConfigurationRepository.class.getName()); 
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
	public int insert(GameConfiguration gameConfiguration)
	{
		log.info("-----GameConfigurationRepository insert started---------");
		int a=0;
		try
		{
			connection = dataSource.getConnection();
			ps = connection.prepareStatement("insert into game_configuration(keys_count,halls_count,question_time,game_time,game_mode)values('"+gameConfiguration.getKeysCount()+"','"+gameConfiguration.getHallsCount()+"','"+gameConfiguration.getQuestionTime()+"','"+gameConfiguration.getGameTime()+"','"+gameConfiguration.getGameMode()+"'");
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