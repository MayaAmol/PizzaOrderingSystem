/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : StoreDAOImpl.java
 * Description   : This file is used for implementing storeDAO methods.
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

import com.wipro.pizza.bean.StoreBean;
import com.wipro.pizza.util.DBUtil;


/**
 * This calss is used for implementing storeDAO methods.
 * 
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public class StoreDAOImpl implements StoreDAO {
	public static final org.apache.log4j.Logger LOG=org.apache.log4j.Logger.getLogger(StoreDAOImpl.class);
	boolean flag = false;
	@Override
	public String createStore (StoreBean store) {
		String res = "FAIL";
		try {
			Connection con = DBUtil.getDBConnection("");
			LOG.debug("Inside createStore() ");
			PreparedStatement pst = con.prepareStatement("insert into POS_TBL_PIZZASTORE values(?,?,?,?,?,?,?)");
			pst.setString(1, store.getStoreID());
			pst.setString(2, store.getName());
			pst.setString(3, store.getStreet());
			pst.setString(4, store.getMobileNo());
			pst.setString(5, store.getCity());
			pst.setString(6, store.getState());
			pst.setString(7, store.getPincode());
			int cnt = pst.executeUpdate();
			if (cnt == 1) {
				LOG.debug("Inserted Sucessfully store");
				res = "SUCCESS";
			}
		} catch (SQLException e) {
			LOG.error(e);
		}
		return res;
	}
	@Override
	public int deleteStore (List<String> storeIDList) {
		int res = 0;
		String id = null;
		LOG.debug("Inside delete() in login ID =" +storeIDList);
		Connection con = DBUtil.getDBConnection("");
		String sql = "delete from POS_TBL_PIZZASTORE where storeid=?";
		try {
			String storeID[] = storeIDList.toArray(new String[storeIDList.size()]);
			for (String k : storeID) {
				id = k;
				LOG.debug(k);
			}
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			LOG.debug("rs in cred delete "+rs);
			if(rs.next()){
				res = 1;
				LOG.debug("inside login delete rs = "+rs);
				LOG.debug("delete complete in credential");
				}

		} catch (SQLException e) {
			LOG.debug("Exception in deletion");
			LOG.error(e);
		}
		return res;
	}
	@Override
	public boolean updateStore (StoreBean store) {
		LOG.debug("inside updateStore()....");
		try {
			Connection con = DBUtil.getDBConnection("");
			String query = "UPDATE POS_TBL_PIZZASTORE SET name=?, street=?, mobileno=?, city=?, state=?, pincode=? where storeID=?";
			String storeID = store.getStoreID();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, store.getName());
			pst.setString(2, store.getStreet());
			pst.setString(3, store.getMobileNo());
			pst.setString(4, store.getCity());
			pst.setString(5, store.getState());
			pst.setString(6, store.getPincode());
			pst.setString(7, storeID);
			int a = pst.executeUpdate();
			LOG.debug("a::::" + a);
			LOG.debug("id ::" + store.getStoreID());
			flag = true;
		} catch (SQLException e) {
			LOG.debug("Exception in updation");
			LOG.error(e);
		}
		LOG.debug("result from updateStore() " + flag);
		return flag;
	}
	@Override
	public StoreBean findByID (String storeID) {
		LOG.debug("in findByID() of storeDAO");
		StoreBean store = new StoreBean();
		Connection con = DBUtil.getDBConnection("");
		LOG.debug("syso find by id ::" + storeID);
		String sql = "select * from POS_TBL_PIZZASTORE where storeid=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, storeID);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				store = new StoreBean();
				store.setStoreID(rs.getString(1));
				store.setName(rs.getString(2));
				store.setStreet(rs.getString(3));
				store.setMobileNo(rs.getString(4));
				store.setCity(rs.getString(5));
				store.setState(rs.getString(6));
				store.setPincode(rs.getString(7));
			}
			LOG.debug("result from findById() credDAO = " + store);
		} catch (SQLException e) {
			LOG.debug("Exception in get credentials from database");
			LOG.error(e);
		}
		return store;
	}
	@Override
	public List<StoreBean> findAll () {
		StoreBean beans = null;
		List<StoreBean> l = new ArrayList<StoreBean>();
		try {
			Connection con = DBUtil.getDBConnection("");
			String q = "select * from POS_TBL_PIZZASTORE";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(q);
			
			while (rs.next()) {
				beans = new StoreBean();
				beans.setStoreID(rs.getString(1));
				beans.setName(rs.getString(2));
				beans.setStreet(rs.getString(3));
				beans.setMobileNo(rs.getString(4));
				beans.setCity(rs.getString(5));
				beans.setState(rs.getString(6));
				beans.setPincode(rs.getString(7));

				LOG.debug("view all name:" + beans.getName());
				l.add(beans);

			}

		} catch (SQLException e) {
			LOG.debug("Exception In fetchimg all records");
			LOG.error(e);
		}
		return l;
	}
	public String findSequenceID () {
		String result = "100000";
		Connection con = DBUtil.getDBConnection("");
		String sql = "select POS_SEQ_STOREID.NEXTVAL from dual";
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
		StoreDAOImpl s = new StoreDAOImpl();
		s.findByID("PI1001");
		s.updateStore(s.findByID("PI1001"));
	}
}
