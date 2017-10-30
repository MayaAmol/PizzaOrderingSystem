/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : Cart.java
 * Description   : This file is used to Perform CRUDE Operations on POS_TBL_CART table.
 * Version       : 1.0
 * Created date  : Apr 26, 2016
 */
package com.wipro.pizza.dao;

import java.util.ArrayList;
import java.util.List;

import com.wipro.pizza.bean.CartBean;

/**
 * This  Interface is used to Perform CRUDE Operations POS_TBL_CART table..
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public interface CartDAO {
	
	/**
	 * This method is used to perform INSERT operation on cart.
	 * 
	 * @param cart
	 * @return
	 */
	String createCart(CartBean cart);
	/**
	 * This method used to perform DELETE operation on cart.
	 * 
	 * @param cartID
	 * @return
	 */
	int deleteCart(ArrayList<String> cartID );
	/**
	 * This method used to perform UPDATE operation on cart.
	 * 
	 * @param cart
	 * @return
	 */
	boolean updateCart(CartBean cart);
	/**
	 * This method used to find cart details by ID.
	 * 
	 * @param cartID
	 * @return
	 */
	CartBean findByID(String cartID);
	/**
	 * This method used to get all rows from cart
	 * 
	 * @return
	 */
	List<CartBean> findAll();
	List<CartBean> findAll(String userID);
	public String findSequenceID ();
}
