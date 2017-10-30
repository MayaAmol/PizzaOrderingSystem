/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : Profile.java
 * Description   : This file is used to do Profile Operation.
 * Version       : 1.0
 * Created date  : Apr 26, 2016
 */
package com.wipro.pizza.dao;

import java.util.ArrayList;
import java.util.List;

import com.wipro.pizza.bean.ProfileBean;

/**
 * This Interface is used to do Profile Operation.
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public interface ProfileDAO {
	
	/**
	 * 
	 * @param Profile
	 * @return
	 */
	String createProfile(ProfileBean profile);
	/**
	 * 
	 * @param ProfileID
	 * @return
	 */
	int deleteProfile(ArrayList<String> profileID );
	/**
	 * 
	 * @param Profile
	 * @return
	 */
	boolean updateProfile(ProfileBean profile);
	/**
	 * @param ProfileID
	 * @return
	 */
	ProfileBean findByID(String profileID);
	/**
	 * 
	 * @return
	 */
	List<ProfileBean> findAll();
	/**
	 * 
	 * @return
	 */
	String findSequenceID ();
	
	public ProfileBean findByEmail (String emailID);
}
