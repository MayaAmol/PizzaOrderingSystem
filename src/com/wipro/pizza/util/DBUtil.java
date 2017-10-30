/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : DBUtil.java
 * Description   : This file is used to Connect to database.
 * Version       : 1.0
 * Created date  : Apr 26, 2016
 */


package com.wipro.pizza.util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;

import com.wipro.pizza.dao.ProfileDAOImpl;


/**
 * This calss is used to Connect to database.
 * 
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public class DBUtil {

	static Connection con;
	public static Connection getDBConnection (String driverType) {
		final org.apache.log4j.Logger LOG =org.apache.log4j.Logger.getLogger(ProfileDAOImpl.class);
		
		try {
			FileInputStream file = new FileInputStream("D:/RLL/ProjectTeam10/Pizza/src/jdbc.properties");
			Properties property = new Properties();
			property.load(file);
			String driver = property.getProperty("driver");
			String url = property.getProperty("url");
			String username = property.getProperty("username");
			String password = property.getProperty("password");
			/*LOG.debug("driver = "+driver);
			LOG.debug("url = "+url);
			LOG.debug("username = "+username);
			LOG.debug("password = "+password);*/
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			LOG.debug("Connected sucessfully");
		} catch (ClassNotFoundException e) {
			LOG.debug("Exception in Driver loading");
			LOG.error(e);
		} catch (SQLException e) {
			LOG.debug("Exception in connection");
			LOG.error(e);
		} catch (FileNotFoundException e) {
			
			LOG.error(e);
		} catch (IOException e) {
			
			LOG.error(e);
		}
		return con;
	}
	
}
