/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : PaymentDAOImpl.java
 * Description   : This file is used for implementing PaymentDAO methods.
 * Version       : 1.0
 * Created date  : Apr 26, 2016
 */
package com.wipro.pizza.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.pizza.bean.FoodBean;
import com.wipro.pizza.bean.PaymentBean;
import com.wipro.pizza.bean.ProfileBean;
import com.wipro.pizza.util.DBUtil;
import com.wipro.pizza.util.DateConverterfun;


/**
 * This calss is used for implementing paymentDAO methods.
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public class PaymentDAOImpl implements PaymentDAO {
	public static final org.apache.log4j.Logger LOG=org.apache.log4j.Logger.getLogger(PaymentDAOImpl.class);

	@Override
	public String createPayment (PaymentBean payment) {
		
		return null;
	}
	@Override
	public int deletePayment (ArrayList<String> paymentID) {
		
		return 0;
	}
	@Override
	public boolean updatePayment (PaymentBean payment) {
		
		return false;
	}
	@Override
	public PaymentBean findByID (String userID) {
		LOG.debug("in findByID() of storeDAO");
		PaymentBean payment = new PaymentBean();
		Connection con = DBUtil.getDBConnection("");
		LOG.debug(" find by id creditcard details::" + userID);
		String sql = "select * from POS_TBL_CREDITCARD where userID=?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, userID);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				System.out.println("in rs.next");
				payment.setCreditCardNumber(rs.getString(1));
				payment.setValidFrom(rs.getString(2));
				payment.setValidTo(rs.getString(3));
				
			}
			LOG.debug("result from findById() paymentDAO = " + payment);
		} catch (SQLException e) {
			LOG.debug("Exception in get payment from database");
			LOG.error(e);
		}
		return payment;
	}
	@Override
	public ArrayList<PaymentBean> findAll () {
		
		return null;
	}
	
}
