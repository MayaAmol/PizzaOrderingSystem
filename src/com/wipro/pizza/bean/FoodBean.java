/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : FoodBean.java
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
public class FoodBean {

	
	private String foodID;
	private String name;
	private String type;
	private String foodSize;
	private int quantity;
	private double price;
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
	 * @return the foodSize
	 */
	public String getFoodSize () {
		return foodSize;
	}
	/**
	 * @param foodSize
	 *            the foodSize to set
	 */
	public void setFoodSize (String foodSize) {
		this.foodSize = foodSize;
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
	 * @return the price
	 */
	public double getPrice () {
		return price;
	}
	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice (double price) {
		this.price = price;
	}
	@Override
	public String toString () {
		return "FoodBean [foodID=" + foodID + ", name=" + name + ", type=" + type + ", foodSize=" + foodSize
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}
}
