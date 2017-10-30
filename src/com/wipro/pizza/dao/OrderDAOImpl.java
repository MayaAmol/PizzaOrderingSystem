/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : OrderDAOImpl.java
 * Description   : This file is used to set/get Credential Details.
 * Version       : 1.0
 * Created date  : Apr 29, 2016
 */


package com.wipro.pizza.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.wipro.pizza.bean.OrderBean;
import com.wipro.pizza.util.DBUtil;


/**
 * This calss is used to set/get Profile Details.
 * 
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 29, 2016
 * @since 1.0
 */
public class OrderDAOImpl implements OrderDAO {

	public static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(OrderDAOImpl.class);
	@Override
	public String createOrder (OrderBean order) {
		String res = "FAIL";
		try {
			Connection con = DBUtil.getDBConnection("");
			LOG.debug("Inside createOrder() ");
			PreparedStatement pst = con.prepareStatement("insert into POS_TBL_ORDER values(?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, order.getOrderID());
			pst.setString(2, order.getUserID());
			pst.setDate(3, (Date) order.getOrderDate());
			pst.setString(4, order.getStoreID());
			pst.setDouble(5, order.getTotalPrice());
			pst.setString(6, order.getOrderStatus());
			pst.setInt(7, order.getCartID());
			pst.setString(8, order.getStreet());
			pst.setString(9, order.getCity());
			pst.setString(10, order.getState());
			pst.setString(11, order.getPincode());
			pst.setString(12, order.getMobileNo());
			int cnt = pst.executeUpdate();
			if (cnt == 1) {
				LOG.debug("Inserted Sucessfully order");
				res = "SUCCESS";
			}
		} catch (SQLException e) {
			LOG.error(e);
		}
		return res;
	}
	@Override
	public int deleteOrder (ArrayList<String> orderID) {
		return 0;
	}
	@Override
	public boolean updateOrder (OrderBean order) {
		return false;
	}
	@Override
	public OrderBean findByID (String orderID) {
		return null;
	}
	@Override
	public ArrayList<OrderBean> findAll () {
		return null;
	}
	public String findSequenceID () {
		String result = "";
		Connection con = DBUtil.getDBConnection("");
		String sql = "select POS_SEQ_ORDERID.NEXTVAL from dual";
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
