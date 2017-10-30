/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : CredentialDAOImpl.java
 * Description   : This file is used to for implementing Credential DAO methods.
 * Version       : 1.0
 * Created date  : Apr 26, 2016
 */


package com.wipro.pizza.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.pizza.bean.CredentialBean;
import com.wipro.pizza.servlet.CredentialServlet;
import com.wipro.pizza.util.DBUtil;


/**
 * This calss is used to for implementing Credential DAO methods.
 * 
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public class CredentialDAOImpl implements CredentialDAO {
	public static final org.apache.log4j.Logger LOG=org.apache.log4j.Logger.getLogger(CredentialDAOImpl.class); 
	
	boolean flag = false;
	@Override
	public String createcredential (CredentialBean credential) {
		
		String res = "FAIL";
		try{
			
			Connection con = DBUtil.getDBConnection("");
			LOG.debug("Inside createcredential() ");
	
			PreparedStatement pst = con.prepareStatement("insert into POS_TBL_USER_CREDENTIALS values(?,?,?,?)");
			
			pst.setString(1, credential.getUserID());
			pst.setString(2, credential.getPassword());
			pst.setString(3, credential.getUserType());
			pst.setInt(4, credential.getLoginStatus());
			
			int cnt = pst.executeUpdate();
			if(cnt == 1){
				LOG.debug("Inserted Sucessfully");
				res = "SUCCESS";
			}
		} catch (SQLException e) {
			LOG.error(e);
		}
		
		return res;
	}
	@Override
	public int deletecredential (ArrayList<String> credentialID) {
		return 0;
	}
	@Override
	public boolean updatecredential (CredentialBean cred) {
		LOG.debug("inside updatecredential()....");
		try {
			Connection con = DBUtil.getDBConnection("");
			String query = "UPDATE POS_TBL_USER_CREDENTIALS SET loginstatus=? where userid =?";
			int loginStatus = cred.getLoginStatus();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, loginStatus);
			pst.setString(2, cred.getUserID());
			int a = pst.executeUpdate();
			LOG.debug("a::::"+a);
			LOG.debug("id ::" +cred.getUserID()+" ststus:: "+loginStatus);
			flag = true;
		} catch (SQLException e) {
			LOG.debug("Exception in updation");
			LOG.error(e);
		}
		LOG.debug("result from updatecredential() " + flag);
		return flag;
	}
	@Override
	public CredentialBean findByID (String userID) {
		LOG.debug("in findByID() of userDAO");
		CredentialBean cred = new CredentialBean();
		Connection con = DBUtil.getDBConnection("");
		LOG.debug("syso find by id ::" + userID);
		String sql = "select * from POS_TBL_USER_CREDENTIALS where userid=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, userID);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				cred = new CredentialBean();
				cred.setUserID(rs.getString(1));
				cred.setPassword(rs.getString(2));
				cred.setUserType(rs.getString(3));
				cred.setLoginStatus(rs.getInt(4));
			}
			LOG.debug("result from findById() credDAO = " + cred);
		} catch (SQLException e) {
			LOG.debug("Exception in get credentials from database");
			LOG.error(e);
		}
		return cred;
	}
	@Override
	public ArrayList<CredentialBean> findAll () {
		return null;
	}
	public static void main (String[] args) {
		CredentialDAOImpl c = new CredentialDAOImpl();
		CredentialBean cred = new CredentialBean();
		c.findByID("wipro");
		c.updatecredential(cred);
		
	}
	@Override
	public boolean updatecredential (CredentialBean cred, String newPassword) {
		LOG.debug("inside updatecredential() password change....");
		try {
			Connection con = DBUtil.getDBConnection("");
			String query = "UPDATE POS_TBL_USER_CREDENTIALS SET password=? where userid =?";
			String userID = cred.getUserID();
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, newPassword);
			pst.setString(2, cred.getUserID());
			int a = pst.executeUpdate();
			LOG.debug("a::::"+a);
			LOG.debug("id ::" +cred.getUserID()+" pass:: "+newPassword);
			flag = true;
		} catch (SQLException e) {
			LOG.debug("Exception in updation");
			LOG.error(e);
		}
		LOG.debug("result from updatecredential() password change" + flag);
		return flag;
	}
}
