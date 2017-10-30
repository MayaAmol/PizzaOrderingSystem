/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : OrderDAO.java
 * Description   : This file is used to do operation on store.
 * Version       : 1.0
 * Created date  : Apr 26, 2016
 */
package com.wipro.pizza.dao;

import java.util.ArrayList;

import com.wipro.pizza.bean.PaymentBean;

/**
 * This Interface is used to do operation on store.
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public interface PaymentDAO {
	/**
	 * @param Payment
	 * @return
	 */
	String createPayment(PaymentBean payment);
	/**
	 * @param PaymentID
	 * @return
	 */
	int deletePayment(ArrayList<String> paymentID );
	/**
	 * @param Payment
	 * @return
	 */
	boolean updatePayment(PaymentBean payment);
	/**
	 * @param PaymentID
	 * @return
	 */
	PaymentBean findByID(String paymentID);
	/**
	 * @return
	 */
	ArrayList<PaymentBean> findAll();
}
