

package com.wipro.pizza.util;


import org.apache.jasper.tagplugins.jstl.core.Out;

import com.wipro.pizza.bean.CredentialBean;
import com.wipro.pizza.bean.PaymentBean;
import com.wipro.pizza.bean.ProfileBean;
import com.wipro.pizza.dao.CartDAOImpl;
import com.wipro.pizza.dao.CredentialDAO;
import com.wipro.pizza.dao.CredentialDAOImpl;
import com.wipro.pizza.dao.ProfileDAO;
import com.wipro.pizza.dao.ProfileDAOImpl;
import com.wipro.pizza.util.User;


/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : UserImpl.java
 * Description   : This file is used to set/get Credential Details.
 * Version       : 1.0
 * Created date  : Apr 26, 2016
 */
/**
 * This calss is used to set/get Profile Details
 * 
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public class UserImpl implements User {

	public static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(ProfileDAOImpl.class);
	String result = "FAIL";
	@Override
	public String login (CredentialBean cred) {
		LOG.debug("login() of user");
		AuthenticationImpl authen = new AuthenticationImpl();
		boolean flag = authen.authenticate(cred);
		result = "INVALID";
		if (flag) {
			// returns user type
			result = authen.authorize(cred.getUserID());
			if (!authen.changeLoginStatus(cred, 1)) {
				result = "INVALID";
			}
		}
		if (!(result.equals("INVALID")) && !(result.equals("LOGGEDIN"))) {
			if (result.equals("A") && cred.getPassword().equals("wipro")) {
				result = "CHANGE";
			}
		}
		return result;
	}
	@Override
	public boolean logout (String userID) {
		AuthenticationImpl authen = new AuthenticationImpl();
		CredentialBean cred = new CredentialBean();
		cred.setUserID(userID);
		boolean flag = authen.changeLoginStatus(cred, 0);
		return flag;
	}
	@Override
	public String changePassword (CredentialBean credential, String newPassword) {
		CredentialDAOImpl credDao = new CredentialDAOImpl();
		boolean res = credDao.updatecredential(credential, newPassword);
		if (res) {
			result = "SUCCESS";
		}
		LOG.debug("result changePass() in userImpl");
		return result;
	}
	@Override
	public String register (ProfileBean profile) {
		LOG.debug("In register() method");
		String result = "FAIL";
		String two = profile.getFirstName().substring(0, 2).toUpperCase();
		ProfileDAOImpl profileDAO = new ProfileDAOImpl();
		CredentialDAOImpl credDAO = new CredentialDAOImpl();
		CredentialBean credential = new CredentialBean();
		String email = profile.getEmailID();
		System.out.println("email serch returns:" + searchEmial(email));
		
			String seq = profileDAO.findSequenceID();
			String userID = two + seq;
			LOG.debug("USER ID:" + userID);
			profile.setUserID(userID);
			credential.setUserID(userID);
			credential.setPassword(profile.getPassword());
			credential.setUserType("C");
			credential.setLoginStatus(0);
			String status = credDAO.createcredential(credential);
			if (status.equals("SUCCESS")) {
				status = profileDAO.createProfile(profile);
				if (status.equals("SUCCESS")) {
					result = userID;
				}
			}
		
		LOG.debug("Result from register() : " + result);
		return result;
	}
	public String searchEmial (String emailID) {
		String result = "EXIST";
		ProfileDAO dao = new ProfileDAOImpl();
		ProfileBean bean = dao.findByEmail(emailID);
		if (bean == null) {
			result = "NOT_EXIST";
		}
		return result;
	}
	@Override
	public ProfileBean viewProfile (String userID) {
		LOG.debug("inside viewCart (String userID) ID::"+userID);
		ProfileDAOImpl dao = new ProfileDAOImpl();
		return dao.findByID(userID);
	}
}
