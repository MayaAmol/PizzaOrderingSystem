/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : ProfileDAOImpl.java
 * Description   : This file is used for implementing ProfileDAO methods.
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
import java.sql.Date;

import com.wipro.pizza.bean.ProfileBean;
import com.wipro.pizza.util.DBUtil;


/**
 * This calss is used for implementing profileDAO methods.
 * 
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public class ProfileDAOImpl implements ProfileDAO {
	public static final org.apache.log4j.Logger LOG=org.apache.log4j.Logger.getLogger(ProfileDAOImpl.class);
	private static java.sql.Date convertUtilDateToSql(java.util.Date uDate) {
		LOG.debug("This is convertUtilDateToSql() method");
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		return sDate;
	}
	@Override
	public String createProfile (ProfileBean profile) {
		String res = "FAIL";
		try {
			Connection con = DBUtil.getDBConnection("");
			LOG.debug("Inside RegistrationBean() ");
			PreparedStatement pst = con
					.prepareStatement("insert into POS_TBL_USER_PROFILE values(?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, profile.getUserID());
			pst.setString(2, profile.getFirstName());
			pst.setString(3, profile.getLastName());
			pst.setDate(4, convertUtilDateToSql(profile.getDateOfBirth()));
			pst.setString(5, profile.getGender());
			pst.setString(6, profile.getStreet());
			pst.setString(7, profile.getLocation());
			pst.setString(8, profile.getCity());
			pst.setString(9, profile.getState());
			pst.setString(10, profile.getPincode());
			pst.setString(11, profile.getMobileNo());
			pst.setString(12, profile.getEmailID());
			int cnt = pst.executeUpdate();
			if (cnt == 1) {
				LOG.debug("Inserted Sucessfully");
				res = "SUCCESS";
			}
			LOG.debug("Result from insertRegister() is " + res);
		} catch (SQLException e) {
			LOG.debug("Exception in registeer");
			LOG.error(e);
		}
		return res;
	}
	@Override
	public int deleteProfile (ArrayList<String> profileID) {
		return 0;
	}
	@Override
	public boolean updateProfile (ProfileBean profile) {
		boolean flag = false;
		LOG.debug("inside updateCart()....");
		try {
			Connection con = DBUtil.getDBConnection("");
			String query = "UPDATE POS_TBL_USER_PROFILE SET ............=? where userID=?";
			String userID = profile.getUserID();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, userID);
			pst.setString(2, profile.getUserID());
			int a = pst.executeUpdate();
			LOG.debug("a::::" + a);
			LOG.debug("id ::" + profile.getUserID());
			flag = true;
		} catch (SQLException e) {
			LOG.debug("Exception in updation");
			LOG.error(e);
		}
		LOG.debug("result from updateCart() " + flag);
		return flag;
	}
	@Override
	public ProfileBean findByID (String userID) {
		LOG.debug("in findByID() of profileDAO");
		ProfileBean profile = new ProfileBean();
		Connection con = DBUtil.getDBConnection("");
		LOG.debug("syso find by id ::" + userID);
		String sql = "select * from POS_TBL_USER_PROFILE where userID=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, userID);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				profile.setUserID(rs.getString(1));
				profile.setFirstName(rs.getString(2));
				profile.setLastName(rs.getString(3));
				profile.setDateOfBirth(rs.getDate(4));
				profile.setGender(rs.getString(5));
				profile.setStreet(rs.getString(6));
				profile.setLocation(rs.getString(7));
				profile.setCity(rs.getString(8));
				profile.setState(rs.getString(9));
				profile.setPincode(rs.getString(10));
				profile.setMobileNo(rs.getString(11));
				profile.setEmailID(rs.getString(12));
			}
			LOG.debug("result from findById() profileDAO = " + profile);
		} catch (SQLException e) {
			LOG.debug("Exception in get profile from database");
			LOG.error(e);
		}
		return profile;
	}
	@Override
	public List<ProfileBean> findAll () {
		ProfileBean profile = null;
		List<ProfileBean> l = new ArrayList<ProfileBean>();
		try {
			Connection con = DBUtil.getDBConnection("");
			String query = "select * from POS_TBL_USER_PROFILE";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				profile.setUserID(rs.getString(1));
				profile.setFirstName(rs.getString(2));
				profile.setLastName(rs.getString(3));
				profile.setDateOfBirth(rs.getDate(4));
				profile.setGender(rs.getString(5));
				profile.setStreet(rs.getString(6));
				profile.setLocation(rs.getString(7));
				profile.setCity(rs.getString(8));
				profile.setState(rs.getString(9));
				profile.setPincode(rs.getString(10));
				profile.setMobileNo(rs.getString(11));
				profile.setEmailID(rs.getString(12));

				LOG.debug("view all profile name:" + profile.getFirstName());
				l.add(profile);

			}

		} catch (SQLException e) {
			LOG.debug("Exception In fetchimg all records in profile");
			LOG.error(e);
		}
		return l;
	}
	@Override
	public String findSequenceID () {
		String result = "";
		Connection con = DBUtil.getDBConnection("");
		String sql = "select POS_SEQ_USERID.NEXTVAL from dual";
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
	public ProfileBean findByEmail (String emailID) {
		Connection con = DBUtil.getDBConnection("");
		ProfileBean mybean = null;
		String sql = "select * from POS_TBL_USER_PROFILE where emailID=?";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, emailID);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				mybean = new ProfileBean();
				mybean.setUserID(rs.getString(1));
				mybean.setPassword(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mybean;
	}
	
}
