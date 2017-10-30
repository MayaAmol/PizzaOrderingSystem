/*
 * CopyrightInfo : copyright © 2015-16 Wipro Limited. All Rights Reserved.
 * File Name     : Cart.java
 * Description   : This file is used to do Admin Operation.
 * Version       : 1.0
 * Created date  : Apr 26, 2016
 */


package com.wipro.pizza.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wipro.pizza.bean.FoodBean;
import com.wipro.pizza.bean.ProfileBean;
import com.wipro.pizza.bean.StoreBean;
import com.wipro.pizza.dao.ProfileDAOImpl;
import com.wipro.pizza.service.Administrator;
import com.wipro.pizza.service.AdministratorImpl;


/**
 * Servlet implementation class AdministratorServlet
 */
@WebServlet("/AdministratorServlet")
public class AdministratorServlet extends HttpServlet {
	public static final org.apache.log4j.Logger LOG=org.apache.log4j.Logger.getLogger(AdministratorServlet.class);

	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdministratorServlet () {
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
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String URL = "AdminHome.jsp";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		LOG.debug("action :" + action);
		Administrator admin = new AdministratorImpl();
		HttpSession session = request.getSession();
		/**********************************************************************************
		 * This Switch is used for administrator operations.
		 **********************************************************************************
		 */
		switch (action) {
		
		
			/**********************************************************************************
			 * This Switch is used for Food operations.
			 **********************************************************************************
			 */
		case "addFood": {
			FoodBean food = new FoodBean();
			String fname = request.getParameter("name");
			String type = request.getParameter("type");
			String size = request.getParameter("size");
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			int price = Integer.parseInt(request.getParameter("price"));
			food.setName(fname);
			food.setType(type);
			food.setFoodSize(size);
			food.setQuantity(quantity);
			food.setPrice(price);
			admin.addFood(food);
			out.println("food Added Sucessfully!!! \n");
			out.println("\n Food Id :" + food.getFoodID());
			URL = "addFood.jsp";
			LOG.debug("food added  :");
		}
			break;
		case "ViewAllFood": {
			List<FoodBean> l = admin.viewAllFood();
			request.setAttribute("foodList", l);
			LOG.debug("in servlet viewAllFood() ");
			URL = "ViewAllFood.jsp";
		}
			break;
		case "DeleteFood": {
			List<FoodBean> l = admin.viewAllFood();
			request.setAttribute("foodList", l);
			LOG.debug("in servlet DeleteFood() ");
			URL = "DeleteFood.jsp";
		}
			break;
			
		case "ModifyFood": {
			List<FoodBean> l = admin.viewAllFood();
			request.setAttribute("foodList", l);
			LOG.debug("in servlet ModifyFood() ");
			URL = "modifyFood.jsp";
		}
			break;
		
		case "DeleteFoodDB": {
			LOG.debug("after accessing list:::");
			String foodID = request.getParameter("foodID");
			LOG.debug("id for delete food in serv " + foodID);
			ArrayList<String> l = new ArrayList<String>();
			l.add(foodID);
			LOG.debug("list food id:: " + l);
			boolean res = admin.removeFood(l);
			if (res) {
				URL = "AdministratorServlet?action=DeleteFood";
				out.println("Food Deleted.");
				LOG.debug("Food Deleted. :");
			}
		}
			break;
		case "ModifyFoodDB": {
			LOG.debug("inside ModifyFoodDB servlet admin");
			String foodID = request.getParameter("foodID");
			LOG.debug("food id in view detail:" + foodID);
			FoodBean foodBean = new FoodBean();
			foodBean.setFoodID(foodID);
			foodBean = admin.viewFood(foodID);
			session.setAttribute("foodBean", foodBean);
			LOG.debug("food details ::" + foodBean);
			if (foodBean != null) {
				LOG.debug("in servlet viewProfile() ");
				URL = "ViewFoodDetail.jsp";
				LOG.debug("in servlet ModifyFoodBD() ");
			}
		}
			break;
		case "updateFood": {
			LOG.debug("inside updateFood servlet admin");
			String foodID = request.getParameter("foodID");
			LOG.debug("food id in view detail:" + foodID);
			FoodBean food = new FoodBean();
			String fname = request.getParameter("name");
			String type = request.getParameter("type");
			String size = request.getParameter("size");
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			int price = Integer.parseInt(request.getParameter("price"));
			food.setFoodID(foodID);
			food.setName(fname);
			food.setType(type);
			food.setFoodSize(size);
			food.setQuantity(quantity);
			food.setPrice(price);
			boolean res = admin.modifyFood(food);
			LOG.debug(res);
			if (res) {
				out.println("food Are updates Sucessfully!!!");
				URL = "AdministratorServlet?action=ModifyFood";
				LOG.debug("food updated  :");
			}
			LOG.debug("in servlet ModifyFoodBD() ");
		}
			break;
		
		case "SearchFood": {
			LOG.debug("inside SearchFood servlet admin");
			String foodID = request.getParameter("foodID");
			LOG.debug("food id in view detail:" + foodID);
			FoodBean foodBean = new FoodBean();
			foodBean.setFoodID(foodID);
			foodBean = admin.viewFood(foodID);
			session.setAttribute("foodBean", foodBean);
			LOG.debug("food details ::" + foodBean);
			if (foodBean != null) {
				LOG.debug("in servlet viewProfile() ");
				URL = "FoodDetail.jsp";
				LOG.debug("in servlet ModifyFoodBD() ");
			}
		}
			break;
			
		case "SearchFoodForModify": {
			LOG.debug("inside SearchFood servlet admin");
			String foodID = request.getParameter("foodID");
			LOG.debug("food id in view detail:" + foodID);
			FoodBean foodBean = new FoodBean();
			foodBean.setFoodID(foodID);
			foodBean = admin.viewFood(foodID);
			session.setAttribute("foodBean", foodBean);
			LOG.debug("food details ::" + foodBean);
			if (foodBean != null) {
				LOG.debug("in servlet viewProfile() ");
				URL = "FoodDetailForModify.jsp";
				LOG.debug("in servlet ModifyFoodBD() ");
			}
		}
			break;
			
			
			/**********************************************************************************
			 * This Switch is used for Store operations.
			 **********************************************************************************
			 */
		case "addStore": {
			StoreBean store = new StoreBean();
			String name = request.getParameter("name");
			String street = request.getParameter("street");
			String mobile = request.getParameter("mobile");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String pincode = request.getParameter("pincode");
			store.setName(name);
			store.setStreet(street);
			store.setCity(city);
			store.setState(state);
			store.setPincode(pincode);
			store.setMobileNo(mobile);
			admin.addStore(store);
			out.println("You Are Register Sucessfully!!!");
			out.println("\n store Id :" + store.getStoreID());
			URL = "AdminHome.jsp";
			LOG.debug("Store added  :");
		}
			break;	
		case "ViewAllStore": {
			LOG.debug("In view all store servlets");
			AdministratorImpl admin1 = new AdministratorImpl();
			List<StoreBean> l = admin1.viewAllStore();
			request.setAttribute("storeList", l);
			LOG.debug("in servlet viewAllFood() ");
			URL = "ViewAllStore.jsp";
		}
			break;
			
		case "StoreID": {
			List<StoreBean> l = admin.viewAllStore();
			request.setAttribute("storeList", l);
			LOG.debug("in servlet getting storeid() ");
			URL = "deleteStore.jsp";
		}
			break;
		case "StoreIDForModify": {
			LOG.debug("in servlet StoreIDForModify() ");
			List<StoreBean> l = admin.viewAllStore();
			LOG.debug("List of all store ::"+l);
			request.setAttribute("storeList", l);
			LOG.debug("in servlet getting storeid()");
			URL = "modifyStore.jsp";
		}
			break;
		case "searchStore": {
			AdministratorImpl ad = new AdministratorImpl();
			LOG.debug("............");
			String storeID = request.getParameter("storeID");
			LOG.debug("storeid for deleting store in serv " + storeID);
			
			StoreBean storeBean = ad.viewStore(storeID);
			session.setAttribute("storeBean", storeBean);
			URL = "StoreDetailForDelete.jsp";
		}
			break;
		case "searchStoreForModify": {
			AdministratorImpl ad = new AdministratorImpl();
			LOG.debug("............");
			String storeID = request.getParameter("storeID");
			LOG.debug("storeid for deleting store in serv " + storeID);
			
			StoreBean storeBean = ad.viewStore(storeID);
			session.setAttribute("storeBean", storeBean);
			URL = "StoreDetailForModify.jsp";
		}
			break;		
			
		case "ModifyStoreDB": {
			StoreBean store = new StoreBean();
			store.setStoreID(request.getParameter("storeID"));
			store.setName(request.getParameter("name"));
			store.setCity(request.getParameter("city"));
			store.setMobileNo(request.getParameter("mobile"));
			store.setState(request.getParameter("state"));
			store.setPincode(request.getParameter("pincode"));
			store.setStreet(request.getParameter("street"));
			boolean res = admin.modifyStore(store);
			LOG.debug("res from update store :::"+res);
				URL = "AdminHome.jsp";
			
		}
			break;
		/*case "ModifyStoreDB": {
			AdministratorImpl ad = new AdministratorImpl();
			LOG.debug("............");
			String storeID = request.getParameter("storeID");
			LOG.debug("storeid for deleting store in serv " + storeID);
			
			StoreBean storeBean = ad.viewStore(storeID);
			session.setAttribute("storeBean", storeBean);
			URL = "StoreDetailForModify.jsp";
		}
			break;*/			
		case "DeleteStoreDB": {
			AdministratorImpl ad = new AdministratorImpl();
			LOG.debug("");
			String storeID = request.getParameter("storeID");
			LOG.debug("storeid for deleting store in serv " + storeID);
			ArrayList<String> l = new ArrayList<String>();
			l.add(storeID);
			LOG.debug("list store id:: " + l);
			int res = ad.removeStore(l);
			if (res == 1) {

				// need to change
				URL = "AdministratorServlet?action=";
				out.println("store Deleted.");
				LOG.debug("store Deleted. :");
			} else {
				out.println("error Food Deleted.");
			}
		}
			break;
		
		default:
			out.print("DEFAULT");
			URL = "AdminHome.jsp";
			break;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(URL);
		rd.include(request, response);
	}
}
