/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : CredentialsBean.java
 * Description   : This file is used to set/get Credential Details.
 * Version       : 1.0
 * Created date  : Apr 26, 2016
 */


package com.wipro.pizza.bean;


/**
 * This calss is used to set/get Profile Details
 * 
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public class CredentialBean {

	private String userID;
	private String password;
	private String userType;
	private int loginStatus;
	/**
	 * @return the userID
	 */
	public String getUserID () {
		return userID;
	}
	/**
	 * @param userID
	 *            the userID to set
	 */
	public void setUserID (String userID) {
		this.userID = userID;
	}
	/**
	 * @return the password
	 */
	public String getPassword () {
		return password;
	}
	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword (String password) {
		this.password = password;
	}
	/**
	 * @return the userType
	 */
	public String getUserType () {
		return userType;
	}
	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType (String userType) {
		this.userType = userType;
	}
	/**
	 * @return the loginStatus
	 */
	public int getLoginStatus () {
		return loginStatus;
	}
	/**
	 * @param loginStatus
	 *            the loginStatus to set
	 */
	public void setLoginStatus (int loginStatus) {
		this.loginStatus = loginStatus;
	}

	@Override
	public String toString () {
		return "CredentialsBean [userID=" + userID + ", password=" + password + ", userType=" + userType
				+ ", loginStatus=" + loginStatus + "]";
	}
}
