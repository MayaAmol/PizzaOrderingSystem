/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : Customer.java
 * Description   : This file is used to do customer operation.
 * Version       : 1.0
 * Created date  : Apr 26, 2016
 */
package com.wipro.pizza.service;

import java.util.ArrayList;
import java.util.List;

import com.wipro.pizza.bean.CartBean;
import com.wipro.pizza.bean.OrderBean;
import com.wipro.pizza.bean.PaymentBean;
import com.wipro.pizza.bean.StoreBean;

/**
 * This calss is used to do customer operation.
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public interface Customer {
	/**
	 * This method is used to add store details.
	 * 
	 * @param cartBean to get cart details.
	 * @return  1 or 0
	 */
	int addToCart(CartBean cartBean);
	/**
	 * This method is used to add store details.
	 * 
	 * @param cartBean to get cart details.
	 * @return boolean as an output
	 */
	boolean modifyCart(CartBean cartBean);
	/**
	 * This method is used to add store details.
	 * 
	 * @param orderBean to get order details.
	 * @param cartbean to get cart details.
	 * @return "SUCCESS", "FAIL", “ERROR”
	 */
	String confirmOrder(OrderBean orderBean, ArrayList<CartBean> cartbean);
	/**This method is used to add store details.
	 * 
	 * @param orderId to get order details.
	 * @return "SUCCESS", "FAIL", “ERROR”
	 */
	String cancelOrder(String orderId);
	/**This method is used to add store details.
	 * 
	 * @param city
	 * @return arraylist of CartBean
	 */
	ArrayList<StoreBean> viewStore(String city);
	/**
	 * This method is used to add store details.
	 * 
	 * @param userid
	 * @return arraylist of CartBean
	 */
	List<CartBean> viewCart(String userID);
	/**
	 * This method is used to add store details.
	 * 
	 * @return arraylist of 
	 */
	ArrayList <OrderBean> viewOrder();
	/**
	 * @param l
	 * @return
	 */
	/**
	 * @param l
	 * @return
	 */
	int removeCart (ArrayList<String> l);
	/**
	 * @param userID
	 * @return
	 */
	PaymentBean viewCreditCard (String userID);
}
