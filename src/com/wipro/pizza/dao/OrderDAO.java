/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : OrderDAO.java
 * Description   : This file is used to do operation on Order.
 * Version       : 1.0
 * Created date  : Apr 26, 2016
 */


package com.wipro.pizza.dao;


import java.util.ArrayList;

import com.wipro.pizza.bean.OrderBean;


/**
 * This Interface is used to do operation on Order.
 * 
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public interface OrderDAO {

	/**
	 * @param Order
	 * @return
	 */
	String createOrder (OrderBean order);
	/**
	 * @param OrderID
	 * @return
	 */
	int deleteOrder (ArrayList<String> orderID);
	/**
	 * @param Order
	 * @return
	 */
	boolean updateOrder (OrderBean order);
	/**
	 * @param OrderID
	 * @return
	 */
	OrderBean findByID (String orderID);
	/**
	 * @return
	 */
	ArrayList<OrderBean> findAll ();
	
	public String findSequenceID ();
}
