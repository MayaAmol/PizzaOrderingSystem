/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : FoodDAOImpl.java
 * Description   : This file is used for implementing foodDAO methods.
 * Version       : 1.0
 * Created date  : Apr 26, 2016
 */


package com.wipro.pizza.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wipro.pizza.bean.CartBean;
import com.wipro.pizza.bean.FoodBean;
import com.wipro.pizza.bean.FoodBean;
import com.wipro.pizza.util.DBUtil;


/**
 * This calss is used for implementing foodDAO methods.
 * 
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public class FoodDAOImpl implements FoodDAO {
	public static final org.apache.log4j.Logger LOG=org.apache.log4j.Logger.getLogger(FoodDAOImpl.class); 

	@Override
	public String createfood (FoodBean food) {
		String res = "FAIL";
		try {
			Connection con = DBUtil.getDBConnection("");
			LOG.debug("Inside createcredential() ");
			PreparedStatement pst = con.prepareStatement("insert into POS_TBL_FOOD values(?,?,?,?,?,?)");
			pst.setString(1, food.getFoodID());
			pst.setString(2, food.getName());
			pst.setString(3, food.getType());
			pst.setString(4, food.getFoodSize());
			pst.setInt(5, food.getQuantity());
			pst.setDouble(6, food.getPrice());
			int cnt = pst.executeUpdate();
			if (cnt == 1) {
				LOG.debug("Inserted Sucessfully");
				res = "SUCCESS";
			}
		} catch (SQLException e) {
			LOG.error(e);
		}
		return res;
	}
	@Override
	public int deletefood (ArrayList<String> foodIDList) {
		int res = 0;
		String id = null;
		LOG.debug("Inside deleteFood() in login ID =");
		Connection con = DBUtil.getDBConnection("");
		String foodID[] = foodIDList.toArray(new String[foodIDList.size()]);
		for (String k : foodID) {
			id = k;
			LOG.debug(k);
		}
		String sql = "delete from POS_TBL_FOOD where foodID=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			LOG.debug("rs in food delete " + rs);
			if (rs.next()) {
				res = 1;
				LOG.debug("delete complete in food table");
			}
		} catch (SQLException e) {
			LOG.debug("Exception in deletion");
			LOG.error(e);
		}
		return res;
	}
	@Override
	public boolean updatefood (FoodBean food) {
		boolean flag = false;
		LOG.debug("inside updateCart()....");
		LOG.debug("id ::" + food.getFoodID());
		try {
			Connection con = DBUtil.getDBConnection("");
			String query = "UPDATE POS_TBL_FOOD SET  name=?, type=?, foodsize=?, quantity=?, price=? where foodID=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, food.getName());
			pst.setString(2, food.getType());
			pst.setString(3, food.getFoodSize());
			pst.setInt(4, food.getQuantity());
			pst.setDouble(5, food.getPrice());
			pst.setString(6, food.getFoodID());
			int a = pst.executeUpdate();
			LOG.debug("a = ");
			if (a != 0) {
				LOG.debug("id ::" + food.getFoodID());
				flag = true;
			}
		} catch (SQLException e) {
			LOG.debug("Exception in updation");
			LOG.error(e);
		}
		LOG.debug("result from updateCart() " + flag);
		return flag;
	}
	
	@Override
	public boolean updatefood (String foodID,int quantity) {
		boolean flag = false;
		LOG.debug("inside updateCart()....");
		try {
			Connection con = DBUtil.getDBConnection("");
			String query = "UPDATE POS_TBL_FOOD SET  quantity=? where foodID=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, quantity);
			pst.setString(2, foodID);
			int a = pst.executeUpdate();
			LOG.debug("a = ");
			if (a != 0) {
				LOG.debug("id ::" + foodID);
				flag = true;
			}
		} catch (SQLException e) {
			LOG.debug("Exception in updation");
			LOG.error(e);
		}
		LOG.debug("result from updateCart() " + flag);
		return flag;
	}
	@Override
	public FoodBean findByID (String foodID) {
		LOG.debug("in findByID() of storeDAO");
		FoodBean food = new FoodBean();
		Connection con = DBUtil.getDBConnection("");
		LOG.debug("syso find by id ::" + foodID);
		String sql = "select * from POS_TBL_FOOD where foodid=?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, foodID);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				food.setFoodID(rs.getString(1));
				food.setName(rs.getString(2));
				food.setType(rs.getString(3));
				food.setFoodSize(rs.getString(4));
				food.setQuantity(rs.getInt(5));
				food.setPrice(rs.getInt(6));
				
			}
			LOG.debug("result from findById() credDAO = " + food);
		} catch (SQLException e) {
			LOG.debug("Exception in get food from database");
			LOG.error(e);
		}
		return food;
	}
	@Override
	public List<FoodBean> findAll () {
		FoodBean beans = null;
		List<FoodBean> l = new ArrayList<FoodBean>();
		try {
			Connection con = DBUtil.getDBConnection("");
			String query = "select * from POS_TBL_FOOD";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				beans = new FoodBean();
				beans.setFoodID(rs.getString(1));
				beans.setName(rs.getString(2));
				beans.setType(rs.getString(3));
				beans.setFoodSize(rs.getString(4));
				beans.setQuantity(rs.getInt(5));
				beans.setPrice(rs.getInt(6));
				LOG.debug("view all food name:" + beans.getFoodID());
				l.add(beans);
			}
		} catch (SQLException e) {
			LOG.debug("Exception In fetchimg all records in food");
			LOG.error(e);
		}
		return l;
	}
	public String findSequenceID () {
		String result = "100000";
		Connection con = DBUtil.getDBConnection("");
		String sql = "select POS_SEQ_FOODID.NEXTVAL from dual";
		try {
			Statement pst = con.createStatement();
			ResultSet rs = pst.executeQuery(sql);
			if (rs.next()) {
				result = rs.getString(1);
			}
		} catch (SQLException e) {
			LOG.error(e);
		}
		return result;
	}
	
}
