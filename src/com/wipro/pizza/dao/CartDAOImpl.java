/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : CartDAOImpl.java
 * Description   : This file is used for implementing cart DAO methods.
 * Version       : 1.0
 * Created date  : Apr 26, 2016
 */


package com.wipro.pizza.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wipro.pizza.bean.CartBean;
import com.wipro.pizza.util.DBUtil;
import com.wipro.pizza.util.DateConverterfun;


/**
 * This calss is used for implementing cart DAO methods.
 * 
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public class CartDAOImpl implements CartDAO {

	public static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(CartDAOImpl.class);
	@Override
	public String createCart (CartBean cart) {
		String res = "FAIL";
		try {
			Connection con = DBUtil.getDBConnection("");
			LOG.debug("Inside createCart() ");
			PreparedStatement pst = con.prepareStatement("insert into POS_TBL_CART values(?,?,?,?,?,?,?)");
			pst.setInt(1, cart.getCartID());
			pst.setString(2, cart.getUserID());
			pst.setString(3, cart.getFoodID());
			pst.setString(4, cart.getType());
			pst.setInt(5, cart.getQuantity());
			pst.setInt(6, cart.getCost());
			pst.setDate(7, (Date) cart.getOrderDate());
			int cnt = pst.executeUpdate();
			if (cnt == 1) {
				LOG.debug("Inserted Sucessfully in createCart()");
				res = "SUCCESS";
			}
		} catch (SQLException e) {
			LOG.error(e);
		}
		return res;
	}
	@Override
	public int deleteCart (ArrayList<String> cartIDList) {
		int res = 0;
		String id = null;
		LOG.debug("Inside deleteCart()  =");
		Connection con = DBUtil.getDBConnection("");
		String cartID[] = cartIDList.toArray(new String[cartIDList.size()]);
		for (String k : cartID) {
			id = k;
			LOG.debug(k);
			String sql = "delete from POS_TBL_CART where cartID=?";
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, id);
				ResultSet rs = pst.executeQuery();
				LOG.debug("rs in cart delete " + rs);
				if (rs.next()) {
					res = 1;
					LOG.debug("delete complete in cart table");
				}
			} catch (SQLException e) {
				LOG.debug("Exception in deletion cart");
				LOG.error(e);
			}
		}
		return res;
	}
	@Override
	public boolean updateCart (CartBean cart) {
		boolean flag = false;
		LOG.debug("inside updateCart()....");
		try {
			Connection con = DBUtil.getDBConnection("");
			LOG.debug("Quantity()" + cart.getQuantity());
			LOG.debug("updated cost()" + cart.getCost());
			String query = "UPDATE POS_TBL_CART SET quantity=?,Cost=? where cartID=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, cart.getQuantity());
			pst.setInt(2, cart.getCost());
			pst.setInt(3, cart.getCartID());
			int a = pst.executeUpdate();
			LOG.debug("a::::" + a);
			flag = true;
		} catch (SQLException e) {
			LOG.debug("Exception in updation");
			LOG.error(e);
		}
		LOG.debug("result from updateCart() " + flag);
		return flag;
	}
	@Override
	public CartBean findByID (String userID) {
		LOG.debug("in findByID() of storeDAO");
		CartBean cart = new CartBean();
		Connection con = DBUtil.getDBConnection("");
		LOG.debug("syso find by id ::" + userID);
		String sql = "select * from POS_TBL_CART where userID=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, userID);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				cart.setCartID(rs.getInt(1));
				cart.setUserID(rs.getString(2));
				cart.setFoodID(rs.getString(3));
				cart.setType(rs.getString(4));
				cart.setQuantity(rs.getInt(5));
				cart.setCost(rs.getInt(6));
				cart.setOrderDate(rs.getDate(7));
			}
			LOG.debug("result from findById() credDAO = " + cart);
		} catch (SQLException e) {
			LOG.debug("Exception in get cart from database");
			LOG.error(e);
		}
		return cart;
	}
	@Override
	public List<CartBean> findAll () {
		CartBean beans = null;
		List<CartBean> l = new ArrayList<CartBean>();
		try {
			// String userID =
			Connection con = DBUtil.getDBConnection("");
			String query = "select * from POS_TBL_CART";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				beans = new CartBean();
				beans.setCartID(rs.getInt(1));
				beans.setUserID(rs.getString(2));
				beans.setFoodID(rs.getString(3));
				beans.setType(rs.getString(4));
				beans.setQuantity(rs.getInt(5));
				beans.setCost(rs.getInt(6));
				beans.setOrderDate(rs.getDate(7));
				LOG.debug("view all cart name:" + beans.getFoodID());
				l.add(beans);
			}
		} catch (SQLException e) {
			LOG.debug("Exception In fetchimg all records in cart");
			LOG.error(e);
		}
		return l;
	}
	@Override
	public List<CartBean> findAll (String userID) {
		CartBean beans = null;
		List<CartBean> l = new ArrayList<CartBean>();
		try {
			Connection con = DBUtil.getDBConnection("");
			String query = "select * from POS_TBL_CART where userID=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, userID);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				beans = new CartBean();
				beans.setCartID(rs.getInt(1));
				beans.setUserID(rs.getString(2));
				beans.setFoodID(rs.getString(3));
				beans.setType(rs.getString(4));
				beans.setQuantity(rs.getInt(5));
				beans.setCost(rs.getInt(6));
				LOG.debug("view all cart name:" + beans.getFoodID());
				l.add(beans);
			}
		} catch (SQLException e) {
			LOG.debug("Exception In fetchimg all records in cart");
			LOG.error(e);
		}
		return l;
	}
	public String findSequenceID () {
		String result = "";
		Connection con = DBUtil.getDBConnection("");
		String sql = "select POS_SEQ_CARTID.NEXTVAL from dual";
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
	public static void main (String[] args) {
		CartDAOImpl s = new CartDAOImpl();
		s.findByID("C1001");
	}
}
