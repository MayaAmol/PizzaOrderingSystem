/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : CartBean.java
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
public class CartBean {

	
	private int cartID;
	private String userID;
	private String foodID;
	private String type;
	private int quantity;
	private int cost;
	private Date orderDate;
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
	 * @return the foodID
	 */
	public String getFoodID () {
		return foodID;
	}
	/**
	 * @param foodID
	 *            the foodID to set
	 */
	public void setFoodID (String foodID) {
		this.foodID = foodID;
	}
	/**
	 * @return the type
	 */
	public String getType () {
		return type;
	}
	/**
	 * @param type
	 *            the type to set
	 */
	public void setType (String type) {
		this.type = type;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity () {
		return quantity;
	}
	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity (int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the cost
	 */
	public int getCost () {
		return cost;
	}
	/**
	 * @param cost
	 *            the cost to set
	 */
	public void setCost (int cost) {
		this.cost = cost;
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
	
	@Override
	public String toString () {
		return "CartBean [cartID=" + cartID + ", userID=" + userID + ", foodID=" + foodID + ", type=" + type
				+ ", quantity=" + quantity + ", cost=" + cost + ", orderDate=" + orderDate + "]";
	}
}
