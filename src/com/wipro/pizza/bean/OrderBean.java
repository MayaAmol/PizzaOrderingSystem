/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : OrderBean.java
 * Description   : This file is used to set/get Credential Details.
 * Version       : 1.0
 * Created date  : Apr 26, 2016
 */


package com.wipro.pizza.bean;


import java.util.Date;


/**
 * This calss is used to set/get Profile Details
 * 
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public class OrderBean {

	private String orderID;
	private String userID;
	private Date orderDate;
	private String storeID;
	private int cartID;
	private double totalPrice;
	private String orderStatus;
	private String street;
	private String city;
	private String state;
	private String pincode;
	private String mobileNo;
	/**
	 * @return the orderID
	 */
	public String getOrderID () {
		return orderID;
	}
	/**
	 * @param orderID
	 *            the orderID to set
	 */
	public void setOrderID (String orderID) {
		this.orderID = orderID;
	}
	/**
	 * @return the userID
	 */
	public String getUserID () {
		return userID;
	}
	/**
	 * @param userID
	 *            the userID to set
	 */
	public void setUserID (String userID) {
		this.userID = userID;
	}
	/**
	 * @return the orderDate
	 */
	public Date getOrderDate () {
		return orderDate;
	}
	/**
	 * @param orderDate
	 *            the orderDate to set
	 */
	public void setOrderDate (Date orderDate) {
		this.orderDate = orderDate;
	}
	/**
	 * @return the storeID
	 */
	public String getStoreID () {
		return storeID;
	}
	/**
	 * @param storeID
	 *            the storeID to set
	 */
	public void setStoreID (String storeID) {
		this.storeID = storeID;
	}
	/**
	 * @return the cartID
	 */
	public int getCartID () {
		return cartID;
	}
	/**
	 * @param cartID
	 *            the cartID to set
	 */
	public void setCartID (int cartID) {
		this.cartID = cartID;
	}
	/**
	 * @return the totalPrice
	 */
	public double getTotalPrice () {
		return totalPrice;
	}
	/**
	 * @param totalPrice
	 *            the totalPrice to set
	 */
	public void setTotalPrice (double totalPrice) {
		this.totalPrice = totalPrice;
	}
	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus () {
		return orderStatus;
	}
	/**
	 * @param orderStatus
	 *            the orderStatus to set
	 */
	public void setOrderStatus (String orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * @return the street
	 */
	public String getStreet () {
		return street;
	}
	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet (String street) {
		this.street = street;
	}
	/**
	 * @return the city
	 */
	public String getCity () {
		return city;
	}
	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity (String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState () {
		return state;
	}
	/**
	 * @param state
	 *            the state to set
	 */
	public void setState (String state) {
		this.state = state;
	}
	/**
	 * @return the pincode
	 */
	public String getPincode () {
		return pincode;
	}
	/**
	 * @param pincode
	 *            the pincode to set
	 */
	public void setPincode (String pincode) {
		this.pincode = pincode;
	}
	/**
	 * @return the mobileNo
	 */
	public String getMobileNo () {
		return mobileNo;
	}
	/**
	 * @param mobileNo
	 *            the mobileNo to set
	 */
	public void setMobileNo (String mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString () {
		return "OrderBean [orderID=" + orderID + ", userID=" + userID + ", orderDate=" + orderDate + ", storeID="
				+ storeID + ", cartID=" + cartID + ", totalPrice=" + totalPrice + ", orderStatus=" + orderStatus
				+ ", street=" + street + ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", mobileNo="
				+ mobileNo + "]";
	}
	
}
