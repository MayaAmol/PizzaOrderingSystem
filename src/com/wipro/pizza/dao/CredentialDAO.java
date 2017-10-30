/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : CredentialDAO.java
 * Description   : This file is used to perform CRUDE operations on POS_TBL_USER_CREDENTIALS table.
 * Version       : 1.0
 * Created date  : Apr 26, 2016
 */
package com.wipro.pizza.dao;

import java.util.ArrayList;

import com.wipro.pizza.bean.CredentialBean;

/**
 * This Interface is used to  perform CRUDE operations on POS_TBL_USER_CREDENTIALS table.
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public interface CredentialDAO {
	
	/**
	 * This method is used to perform INSERT operation on Credential..
	 * @param credential
	 * @return
	 */
	String createcredential(CredentialBean credential);
	/**
	 *This method is used to perform DELETE operation on Credential.. 
	 * @param credentialID
	 * @return
	 */
	int deletecredential(ArrayList<String> credentialID );
	/**
	 * This method is used to perform UPDATE operation on Credential..
	 * @param credential
	 * @return
	 */
	boolean updatecredential(CredentialBean credential);
	/**
	 *This method is used to perform UPDATE operation on Credential.. 
	 * @param credentialID
	 * @return
	 */
	
	boolean updatecredential(CredentialBean credential, String newPassword); 
	CredentialBean findByID(String credentialID);
	/**
	 * @return
	 */
	ArrayList<CredentialBean> findAll();
	
}
