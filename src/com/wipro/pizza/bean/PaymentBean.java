/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : PaymentBean.java
 * Description   : This file is used to set/get Credential Details.
 * Version       : 1.0
 * Created date  : Apr 26, 2016
 */
package com.wipro.pizza.bean;


/**
 * This calss is used to set/get Profile Details.
 * @author Maya
 * @author Seenu
 * @version 1.0, Apr 26, 2016
 * @since 1.0
 */
public class PaymentBean {
	
	private String creditCardNumber;
	private String validFrom;
	private String validTo;
	private int balance;
	
	/**
	 * @return the creditCardNumber
	 */
	public String getCreditCardNumber () {
		return creditCardNumber;
	}
	
	/**
	 * @param creditCardNumber the creditCardNumber to set
	 */
	public void setCreditCardNumber (String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
	/**
	 * @return the validFrom
	 */
	public String getValidFrom () {
		return validFrom;
	}
	
	/**
	 * @param validFrom the validFrom to set
	 */
	public void setValidFrom (String validFrom) {
		this.validFrom = validFrom;
	}
	
	/**
	 * @return the validTo
	 */
	public String getValidTo () {
		return validTo;
	}
	
	/**
	 * @param validTo the validTo to set
	 */
	public void setValidTo (String validTo) {
		this.validTo = validTo;
	}
	
	/**
	 * @return the balance
	 */
	public int getBalance () {
		return balance;
	}
	
	/**
	 * @param balance the balance to set
	 */
	public void setBalance (int balance) {
		this.balance = balance;
	}

	@Override
	public String toString () {
		return "PaymentBean [creditCardNumber=" + creditCardNumber + ", validFrom=" + validFrom + ", validTo=" + validTo
				+ ", balance=" + balance + "]";
	}
	
	
	
}
