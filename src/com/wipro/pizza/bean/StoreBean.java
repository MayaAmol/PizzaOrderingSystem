/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : StoreBean.java
 * Description   : This file is used to set/get Credential Details.
 * Version       : 1.0
 * Created date  : Apr 26, 2016
 */


package com.wipro.pizza.bean;


/**
 * This calss is used to set/get Profile Details
 * 
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public class StoreBean {

	private String storeID;
	private String name;
	private String street;
	private String mobileNo;
	private String city;
	private String state;
	private String pincode;
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
	 * @return the name
	 */
	public String getName () {
		return name;
	}
	/**
	 * @param name
	 *            the name to set
	 */
	public void setName (String name) {
		this.name = name;
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
	@Override
	public String toString () {
		return "StoreBean [storeID=" + storeID + ", name=" + name + ", street=" + street + ", mobileNo=" + mobileNo
				+ ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}
	
}
