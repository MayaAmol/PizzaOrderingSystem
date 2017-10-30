/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : Administrator.java
 * Description   : This file is used to do operation on Customer.
 * Version       : 1.0
 * Created date  : Apr 26, 2016
 */


package com.wipro.pizza.service;


import java.util.ArrayList;
import java.util.List;

import com.wipro.pizza.bean.CredentialBean;
import com.wipro.pizza.bean.FoodBean;
import com.wipro.pizza.bean.StoreBean;
import com.wipro.pizza.dao.CredentialDAOImpl;
import com.wipro.pizza.dao.ProfileDAOImpl;
import com.wipro.pizza.dao.StoreDAOImpl;


/**
 * This Interface is used to do operation on Customer.
 * 
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public interface Administrator {

	/**
	 * This method is used to add store details.
	 * 
	 * @param storebean
	 *            to get store details.
	 * @return "SUCCESS", "FAIL", “ERROR”
	 */
	public String addStore (StoreBean store);
	/**
	 * This method is used to modify store details.
	 * 
	 * @param storebean
	 *            to get store details.
	 * @return boolean as an output.
	 */
	boolean modifyStore (StoreBean store);
	/**
	 * This method is used to remove store.
	 * 
	 * @param storeId
	 *            to get store ID.
	 * @return Integer as an output 0 or 1.
	 */
	int removeStore (ArrayList<String> storeId);
	/**
	 * This method is used to View store details.
	 * 
	 * @param storeId
	 *            to get store ID.
	 * @return storeBean
	 */
	StoreBean viewStore (String storeId);
	/**
	 * This method is used to view all store details.
	 * 
	 * @return Arraylist of storeBean
	 */
	List<StoreBean> viewAllStore ();
	/**
	 * This method is used to add store details.
	 * 
	 * @param foodbean
	 *            to get food details.
	 * @return "SUCCESS", "FAIL", “ERROR”
	 */
	String addFood (FoodBean food);
	/**
	 * This method is used to add food details.
	 * 
	 * @param foodbean
	 *            to get food details.
	 * @return boolean as an output.
	 */
	boolean modifyFood (FoodBean food);
	/**
	 * This method is used to add food details.
	 * 
	 * @param storeId
	 *            to get store details.
	 * @param l
	 *            to get food details.
	 * @return boolean as an output.
	 */
	boolean removeFood (ArrayList<String> l);
	/**
	 * This method is used to add food details.
	 * 
	 * @param foodId
	 *            to get food details.
	 * @return FoodBean
	 */
	FoodBean viewFood (String foodId);
	/**
	 * This method is used to add food details.
	 * 
	 * @param storeId
	 * @return ArrayList of FoodBean
	 */
	List<FoodBean> viewAllFood ();
	/**
	 * This method is used to add food details.
	 * 
	 * @param orderId
	 *            to get order details.
	 * @return "SUCCESS", "FAIL"
	 */
	String changeOrderStatus (String orderId);
	boolean modifyFood (String foodID, int quantity);
}
