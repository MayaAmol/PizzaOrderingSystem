/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : Cart.java
 * Description   : This file is used to do operation Sucessfull login, logout and registration.
 * Version       : 1.0
 * Created date  : Apr 26, 2016
 */


package com.wipro.pizza.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wipro.pizza.bean.CredentialBean;
import com.wipro.pizza.bean.ProfileBean;
import com.wipro.pizza.util.DateConverterfun;
import com.wipro.pizza.util.UserImpl;


/**
 * Servlet implementation class CredentialServlet
 */
@WebServlet("/CredentialServlet")
public class CredentialServlet extends HttpServlet {

	public static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(CredentialServlet.class);
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CredentialServlet () {
		super();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = "This is home page";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		LOG.debug("action :" + action);
		DateConverterfun convert = new DateConverterfun();
		CredentialBean credential = new CredentialBean();
		UserImpl user = new UserImpl();
		HttpSession session = request.getSession();
		String UserID = request.getParameter("userID");
		LOG.debug("userid ::" + UserID);
		String URL = null;
		/**********************************************************************************
		 * This if condition is used for procss login.
		 **********************************************************************************
		 */
		if ("Login".equals(action)) {
			session.setAttribute("userID", UserID);
			LOG.debug("Inside login()");
			String password = request.getParameter("password");
			LOG.debug("Login ID : " + UserID);
			credential.setUserID(UserID);
			credential.setPassword(password);
			LOG.debug("values from html : " + UserID + " " + password);
			String res = user.login(credential);
			LOG.debug("case:::::: = " + res);
			switch (res) {
			case "A":
				URL = "AdminHome.jsp";
				LOG.debug("Welcome admin :" + UserID);
				break;
			case "C":
				URL = "CustHome.jsp";
				LOG.debug("Welcome Customer :" + UserID);
				break;
			case "CHANGE":
				URL = "ChangePassword.jsp";
				out.println("Frist change your password");
				LOG.debug("Change your password :" + UserID);
				break;
			case "LOGGEDIN":
				URL = "LoggedIn.jsp";
				LOG.debug("yes are already logged in :" + UserID);
				break;
			case "INVALID":
				URL = "UserLogin.jsp";
				message = "Invalid Credential, please try again.";
				out.println("Invalid Credential, please try again.");
				LOG.debug("invalid credential :" + UserID);
				break;
			default:
				out.print("DEFAULT");
				URL = "UserLogin.jsp";
				break;
			}
		}
		/**********************************************************************************
		 * This if condition is used for process logout.
		 **********************************************************************************
		 */
		if ("LOGOUT".equals(action)) {
			LOG.debug("userid in logout: ");
			String uid = request.getParameter("userID");
			LOG.debug("userid in loguot: " + UserID);
			credential.setUserID(uid);
			if (session != null) {
				session.invalidate();
				LOG.debug("Seesion invalidate");
				boolean res = user.logout(uid);
				LOG.debug("after loguot res = " + res);
				if (res) {
					out.print("You are Logged out sucessfully.");
					URL = "UserLogin.jsp";
				}
			}
		}
		/**********************************************************************************
		 * This if condition is used for process change password.
		 **********************************************************************************
		 */
		if (action.equals("change")) {
			String userID = (String) session.getAttribute("userID");
			LOG.debug("userid in change password: " + userID);
			credential.setUserID(userID);
			String newPassword = request.getParameter("newPass");
			String result = user.changePassword(credential, newPassword);
			LOG.debug("after loguot res = " + result);
			if (result.equals("SUCCESS")) {
				out.print("Your password changed sucessfully.");
				System.out.print("result.");
				URL = "AdminHome.jsp";
			}
		}
		/**********************************************************************************
		 * This if condition is used for Customer Registration.
		 **********************************************************************************
		 */
		if ("Register".equals(action)) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date dateofbirth = null;
			try {
				dateofbirth = formatter.parse(request.getParameter("dateOfBirth"));
				LOG.debug("DATE *****************" + dateofbirth);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			ProfileBean profile = new ProfileBean();
			String fname = request.getParameter("firstName");
			String lname = request.getParameter("lastName");
			// String dob1 = request.getParameter("dateOfBirth");
			String gender = request.getParameter("gender");
			String street = request.getParameter("street");
			String location = request.getParameter("location");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String pincode = request.getParameter("pincode");
			String mobile = request.getParameter("mobile");
			String email = request.getParameter("emailID");
			String password = request.getParameter("password");
			java.util.Date dob = convert.convertUtil(request.getParameter("dateOfBirth"));
			LOG.debug("date from html = " + request.getParameter("dateOfBirth"));
			LOG.debug("date after fun = " + dob);
			String result = user.searchEmial(email);
			if ("NOT_EXIST".equals(result)) {
				profile.setFirstName(fname);
				profile.setLastName(lname);
				profile.setDateOfBirth(dateofbirth);
				profile.setGender(gender);
				profile.setStreet(street);
				profile.setLocation(location);
				profile.setCity(city);
				profile.setState(state);
				profile.setPincode(pincode);
				profile.setMobileNo(mobile);
				profile.setPassword(password);
				result = user.register(profile);
				out.println("You Are Register Sucessfully!!!");
				URL = "UserLogin.jsp";
				out.println("\n User Id :" + profile.getUserID() + "Login Here...");
			} else {
				out.print("already user avail...");
				URL = "Registrationdemo.jsp";
			}
			
			if ("SUCCESS".equals(result)) {
				URL = "UserLogin.jsp";
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(URL);
		rd.include(request, response);
	}
}
