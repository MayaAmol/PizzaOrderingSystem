/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : AdministratorImpl.java
 * Description   : This file is used to do operation on Customer.
 * Version       : 1.0
 * Created date  : Apr 26, 2016
 */


package com.wipro.pizza.service;


import java.util.ArrayList;
import java.util.List;

import com.wipro.pizza.bean.FoodBean;
import com.wipro.pizza.bean.StoreBean;
import com.wipro.pizza.dao.FoodDAO;
import com.wipro.pizza.dao.FoodDAOImpl;
import com.wipro.pizza.dao.ProfileDAOImpl;
import com.wipro.pizza.dao.StoreDAO;
import com.wipro.pizza.dao.StoreDAOImpl;


/**
 * This calss is used to do operation on Customer.
 * 
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public class AdministratorImpl implements Administrator {
	public static final org.apache.log4j.Logger LOG=org.apache.log4j.Logger.getLogger(AdministratorImpl.class);
	@Override
	public String addStore (StoreBean store) {
		LOG.debug("In addStore() method");
		String result = "FAIL";
		String two = store.getName().substring(0, 2).toUpperCase();
		StoreDAOImpl storeDAO = new StoreDAOImpl();
		String seq = storeDAO.findSequenceID();
		String storeID = two + seq;
		LOG.debug("USER ID:" + storeID);
		store.setStoreID(storeID);
		store.setName(store.getName());
		store.setStreet(store.getStreet());
		store.setMobileNo(store.getMobileNo());
		store.setCity(store.getCity());
		store.setState(store.getState());
		store.setPincode(store.getPincode());
		String status = storeDAO.createStore(store);
		if ("SUCCESS".equals(status)) {
			result = storeID;
		} else {
			result = "Error";
		}
		LOG.debug("Result from addStore() : " + result);
		return result;
	}
	@Override
	public boolean modifyStore (StoreBean store) {
		StoreDAO dao = new StoreDAOImpl();
		return dao.updateStore(store);
	}
	@Override
	public int removeStore (ArrayList<String> storeID) {
		StoreDAO dao = new StoreDAOImpl();
		return dao.deleteStore(storeID);
	}
	@Override
	public StoreBean viewStore (String storeID) {
		StoreDAO dao = new StoreDAOImpl();
		return dao.findByID(storeID);
	}
	@Override
	public List<StoreBean> viewAllStore () {
		StoreDAO dao = new StoreDAOImpl();
		return dao.findAll();
	}
	@Override
	public String addFood (FoodBean food) {
		LOG.debug("In addStore() method");
		String result = "FAIL";
		String two = food.getName().substring(0, 2).toUpperCase();
		FoodDAOImpl foodDAO = new FoodDAOImpl();
		String seq = foodDAO.findSequenceID();
		String storeID = two + seq;
		LOG.debug("USER ID:" + storeID);
		food.setFoodID(storeID);
		food.setName(food.getName());
		food.setType(food.getType());
		food.setFoodSize(food.getFoodSize());
		food.setQuantity(food.getQuantity());
		food.setPrice(food.getPrice());
		String status = foodDAO.createfood(food);
		if ("SUCCESS".equals(status)) {
			result = storeID;
		} else {
			result = "Error";
		}
		LOG.debug("Result from addStore() : " + result);
		return result;
	}
	@Override
	public boolean modifyFood (FoodBean food) {
		boolean result = false;
		LOG.debug("modifyFood() of admin");
		FoodDAOImpl foodDAO = new FoodDAOImpl();
		result = foodDAO.updatefood(food);
		LOG.debug("res from delete() true/false::" + result);
		if (result) {
			LOG.debug("modify food details");
		}
		return result;
	}
	@Override
	public boolean modifyFood (String foodID, int quantity) {
		boolean result = false;
		FoodDAOImpl foodDAO = new FoodDAOImpl();
		result = foodDAO.updatefood(foodID, quantity);
		return result;
	}
	@Override
	public boolean removeFood (ArrayList<String> l) {
		
		boolean result = false;
		LOG.debug("delete id in food admin = "+l);
		LOG.debug("removeFood() of user");
		FoodDAOImpl foodDAO = new FoodDAOImpl();
		foodDAO.deletefood(l);
		LOG.debug("res from delete() true/false::" + result);
		if (l != null) {
			result = true;
			LOG.debug("delet cred");
		}

		return result;
	}
	@Override
	public FoodBean viewFood (String foodId) {
		FoodBean result = null;
		FoodDAO foodDAO = new FoodDAOImpl();
		FoodBean food = new FoodBean();
		food = foodDAO.findByID(foodId);

		if (food != null) {
			LOG.debug("in viewFood() of food;");
			result = food;
		}

		return result;
		
	}
	@Override
	public List<FoodBean> viewAllFood () {
		FoodDAO dao = new FoodDAOImpl();
		List<FoodBean> l = dao.findAll();
		LOG.debug("in viewAll() food.......;");
		if (l != null) {
			LOG.debug("in viewAll(); of food");
		}
		return l;
	}
	@Override
	public String changeOrderStatus (String orderId) {
		return null;
	}
	
}
