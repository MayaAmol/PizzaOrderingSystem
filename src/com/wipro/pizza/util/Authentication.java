/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : Authentication.java
 * Description   : This file is used to Authenticate the valid user.
 * Version       : 1.0
 * Created date  : Apr 26, 2016
 */


package com.wipro.pizza.util;


import com.wipro.pizza.bean.CredentialBean;


/**
 * This Interface is used to Authenticate the valid user.
 * 
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public interface Authentication {

	/**
	 * method is used to Authenticate
	 * 
	 * @param credentials
	 *            to get credentials details.
	 * @return boolean as an output.
	 */
	boolean authenticate (CredentialBean credentials);
	/**
	 * method is used to authorize the user
	 * 
	 * @param userId
	 *            to get user ID
	 * @return "SUCCESS", "FAIL", “ERROR”
	 */
	String authorize (String userId);
	/**
	 * method is used to change login status
	 * 
	 * @param credentials
	 *            to get credential details.
	 * @param loginStatus
	 *            to get user ID
	 * @return boolean as an output.
	 */
	boolean changeLoginStatus (CredentialBean credentials, int loginStatus);
}
