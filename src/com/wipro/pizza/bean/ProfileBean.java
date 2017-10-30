/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : ProfileBean.java
 * Description   : This file is used to set/get Profile Details.
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
public class ProfileBean {

	private String userID;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String gender;
	private String street;
	private String location;
	private String city;
	private String state;
	private String pincode;
	private String mobileNo;
	private String emailID;
	private String password;
	
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
	 * @return the firstName
	 */
	public String getFirstName () {
		return firstName;
	}
	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName (String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName () {
		return lastName;
	}
	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName (String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth () {
		return dateOfBirth;
	}
	/**
	 * @param dob
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth (Date dob) {
		this.dateOfBirth = dob;
	}
	/**
	 * @return the gender
	 */
	public String getGender () {
		return gender;
	}
	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender (String gender) {
		this.gender = gender;
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
	 * @return the location
	 */
	public String getLocation () {
		return location;
	}
	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation (String location) {
		this.location = location;
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
	/**
	 * @return the emailID
	 */
	public String getEmailID () {
		return emailID;
	}
	/**
	 * @param emailID
	 *            the emailID to set
	 */
	public void setEmailID (String emailID) {
		this.emailID = emailID;
	}
	/**
	 * @return the password
	 */
	public String getPassword () {
		return password;
	}
	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword (String password) {
		this.password = password;
	}
	@Override
	public String toString () {
		return "ProfileBean [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", street=" + street + ", location="
				+ location + ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", mobileNo=" + mobileNo
				+ ", emailID=" + emailID + ", password=" + password + "]";
	}
	
}
