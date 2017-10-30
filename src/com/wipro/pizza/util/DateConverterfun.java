package com.wipro.pizza.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverterfun {
	public java.util.Date convertUtil (String dte) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date cdate = null;
		try {
			cdate = formatter.parse(dte);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cdate;		
	}
	
	public static java.util.Date convertToSql (java.util.Date ndate) {
		
		System.out.println("This is convertUtilDateToSql() method");
		java.sql.Date sDate = new java.sql.Date(ndate.getTime());
		System.out.println("after converting date"+sDate);
		return sDate;
	}
	
}
