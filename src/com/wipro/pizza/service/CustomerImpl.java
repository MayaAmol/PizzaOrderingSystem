/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : CustomerImpl.java
 * Description   : This file is used to set/get Credential Details.
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
import com.wipro.pizza.dao.CartDAO;
import com.wipro.pizza.dao.CartDAOImpl;
import com.wipro.pizza.dao.OrderDAO;
import com.wipro.pizza.dao.OrderDAOImpl;
import com.wipro.pizza.dao.PaymentDAO;
import com.wipro.pizza.dao.PaymentDAOImpl;


/**
 * This calss is used to set/get Profile Details.
 * 
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public class CustomerImpl implements Customer {

	public static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(CustomerImpl.class);
	String result = "FAIL";
	int res = 0;
	@Override
	public int addToCart (CartBean cart) {
		LOG.debug("In addToCart() method");
		CartDAO cartDAO = new CartDAOImpl();
		String cartID = cartDAO.findSequenceID();
		LOG.debug("CART ID:" + cartID);
		cart.setCartID(Integer.parseInt(cartID));
		String status = cartDAO.createCart(cart);
		if (status.equals("SUCCESS")) {
			res = 1;
		}
		LOG.debug("Result from addToCart() 0/1 :: " + res);
		return res;
	}
	@Override
	public boolean modifyCart (CartBean cart) {
		boolean result = false;
		LOG.debug("modifyFood() of admin");
		CartDAO cartDAO = new CartDAOImpl();
		result = cartDAO.updateCart(cart);
		LOG.debug("res from delete() true/false::" + result);
		if (result) {
			LOG.debug("modify food details");
		}
		return result;
	}
	@Override
	public String confirmOrder (OrderBean orderBean, ArrayList<CartBean> cartbean) {
		LOG.debug("In confirmOrder() method");
		String status = "FAIL";
		OrderDAO orderDAO = new OrderDAOImpl();
		
		orderBean.setStoreID("GE1001");
		for (CartBean cart : cartbean) {
			String orderID = orderDAO.findSequenceID();
			LOG.debug("order ID:" + orderID);
			System.out.println("cart ID order" + cart.getCartID());
			orderBean.setOrderID(orderID);
			orderBean.setCartID(cart.getCartID());
			orderBean.setTotalPrice(cart.getCost());
			status = orderDAO.createOrder(orderBean);
			if("SUCCESS".equals(status)){
				result = "SUCCESS" ;
			}
		}
		return result;
	}
	@Override
	public String cancelOrder (String orderId) {
		return null;
	}
	@Override
	public ArrayList<StoreBean> viewStore (String city) {
		return null;
	}
	@Override
	public List<CartBean> viewCart (String userID) {
		LOG.debug("inside viewCart (String userID) ID::" + userID);
		CartDAOImpl dao = new CartDAOImpl();
		return dao.findAll(userID);
	}
	@Override
	public ArrayList<OrderBean> viewOrder () {
		return null;
	}
	@Override
	public int removeCart (ArrayList<String> l) {
		int result = 0;
		LOG.debug("delete id in cart cust= " + l);
		LOG.debug("removeCart() of user");
		CartDAO cartDAO = new CartDAOImpl();
		cartDAO.deleteCart(l);
		LOG.debug("res from delete() true/false::" + result);
		if (l != null) {
			result = 1;
			LOG.debug("delet cred");
		}
		return result;
	}
	@Override
	public PaymentBean viewCreditCard (String userID) {
		LOG.debug("inside viewCard (String userID) ID::" + userID);
		PaymentDAO payment = new PaymentDAOImpl();
		return payment.findByID(userID);
	}
}
