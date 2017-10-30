/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : User.java
 * Description   : This file is used to perform Authentication and Authorization operations.
 * Version       : 1.0
 * Created date  : Apr 26, 2016
 */


package com.wipro.pizza.util;


import com.wipro.pizza.bean.CredentialBean;
import com.wipro.pizza.bean.PaymentBean;
import com.wipro.pizza.bean.ProfileBean;


/**
 * This calss is used to perform Authentication and Authorization operations.
 * 
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public interface User {

	/**
	 * This method is used to perform login operation.
	 * 
	 * @param credentials
	 *            to get credential details.
	 * @return String "A", "C", "FAIL", “INVALID” as an output.
	 */
	String login (CredentialBean cred);
	/**
	 * This method is used to perform logout operation.
	 * 
	 * @param userID
	 *            to get login ID of User.
	 * @return boolean as an output.
	 */
	boolean logout (String userID);
	/**
	 * This method is used to perform change password operation.
	 * 
	 * @param credential
	 *            to get credential details.
	 * @param newPassword
	 *            get new password
	 * @return "SUCCESS", "FAIL", “INVALID”
	 */
	String changePassword (CredentialBean cred, String newPassword);
	/**
	 * @param profile
	 *            to get profile details.
	 * @return <userId of length 6> / "FAIL".
	 */
	String register (ProfileBean profile);
	public ProfileBean viewProfile (String userID);
	public String searchEmial (String emailID); 
}
