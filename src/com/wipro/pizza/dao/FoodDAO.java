/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : FoodDAO.java
 * Description   : This file is used to do operation on food.
 * Version       : 1.0
 * Created date  : Apr 26, 2016
 */
package com.wipro.pizza.dao;

import java.util.ArrayList;
import java.util.List;

import com.wipro.pizza.bean.FoodBean;

/**
 * This Interface is used to perform  operations on food
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public interface FoodDAO {
	/**
	 *  method is used to add food details
	 * @param food to get food details
	 * @return "SUCCESS", "FAIL", “ERROR”
	 */
	String createfood(FoodBean food);
	/**
	 * method is used to delete food details
	 * @param l to get food details
	 * @return 1 or 0
	 */
	 int deletefood(ArrayList<String> l );
	/**
	 * method is used to update food details
	 * @param food to get food details
	 * @return boolean as an output
	 */
	boolean updatefood(FoodBean food);
	/**
	 * method is used to find food details by id
	 * @param foodID to get food details
	 * @return Food Details
	 */
	FoodBean findByID(String foodID);
	/**
	 * method is used to list of all foods.
	 * @param newParam TODO
	 * @return list of all foods
	 */
	List<FoodBean> findAll();
	boolean updatefood (String foodID, int quantity);
	
}
