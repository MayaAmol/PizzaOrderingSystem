/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : AuthenticationImpl.java
 * Description   : This file is used toAuthenticate the valid user.
 * Version       : 1.0
 * Created date  : Apr 26, 2016
 */


package com.wipro.pizza.util;


import com.wipro.pizza.bean.CredentialBean;
import com.wipro.pizza.dao.CredentialDAOImpl;
import com.wipro.pizza.dao.ProfileDAOImpl;


/**
 * This calss is used to Authenticate the valid user.
 * 
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public class AuthenticationImpl implements Authentication {
	public static final org.apache.log4j.Logger LOG=org.apache.log4j.Logger.getLogger(ProfileDAOImpl.class);

	String result = "FAIL";
	boolean flag = false;
	@Override
	public boolean authenticate (CredentialBean cred) {
		LOG.debug("inside Authentication() implementation");
		CredentialDAOImpl credDao = new CredentialDAOImpl();
		CredentialBean DBBean = new CredentialBean();
		DBBean = credDao.findByID(cred.getUserID());
		String userid = DBBean.getUserID();
		if (!(userid == null) && DBBean.getPassword().equals(cred.getPassword())) {
			flag = true;
		}
		LOG.debug(" Authentication() returns " + flag);
		return flag;
	}
	@Override
	public String authorize (String userID) {
		LOG.debug("inside authorize() ");
		CredentialDAOImpl credDao = new CredentialDAOImpl();
		CredentialBean cred = new CredentialBean();
		cred = credDao.findByID(userID);
		if (cred.getLoginStatus() == 1) {
			result = "LOGGEDIN";
		}
		else{
			result = cred.getUserType();
		}
			
		LOG.debug("result from authorize() ::: " + result);
		return result;
	}
	@Override
	public boolean changeLoginStatus (CredentialBean cred, int loginStatus) {
		CredentialDAOImpl credDao = new CredentialDAOImpl();
		cred.setLoginStatus(loginStatus);
		return credDao.updatecredential(cred);
	}
}
