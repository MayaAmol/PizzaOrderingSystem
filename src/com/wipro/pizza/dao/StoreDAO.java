/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : Store.java
 * Description   : This file is used to do Operation on store.
 * Version       : 1.0
 * Created date  : Apr 26, 2016
 */


package com.wipro.pizza.dao;


import java.util.List;

import com.wipro.pizza.bean.StoreBean;


/**
 * This Interface is used to do Operation on store.
 * 
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public interface StoreDAO {

	/**
	 * 
	 * @param Store
	 * @return
	 */
	String createStore (StoreBean store);
	/**
	 * 
	 * @param StoreID
	 * @return 0 or 1 as an output.
	 */
	int deleteStore (List<String> storeID);
	/**
	 * 
	 * @param Store
	 * @return
	 */
	boolean updateStore (StoreBean store);
	/**
	 * @param StoreID
	 * @return
	 */
	StoreBean findByID (String storeID);
	/**
	 * 
	 * @return
	 */
	List<StoreBean> findAll ();
}
