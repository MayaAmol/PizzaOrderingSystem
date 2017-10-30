

package com.wipro.pizza.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.glass.ui.View;
import com.wipro.pizza.bean.CartBean;
import com.wipro.pizza.bean.FoodBean;
import com.wipro.pizza.bean.OrderBean;
import com.wipro.pizza.bean.PaymentBean;
import com.wipro.pizza.bean.ProfileBean;
import com.wipro.pizza.bean.StoreBean;
import com.wipro.pizza.dao.ProfileDAOImpl;
import com.wipro.pizza.service.Administrator;
import com.wipro.pizza.service.AdministratorImpl;
import com.wipro.pizza.service.Customer;
import com.wipro.pizza.service.CustomerImpl;
import com.wipro.pizza.util.User;
import com.wipro.pizza.util.UserImpl;


/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {

	public static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(CustomerServlet.class);
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerServlet () {
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
		String URL = "CustHome.jsp";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		LOG.debug("action :" + action);
		Customer customer = new CustomerImpl();
		Administrator admin = new AdministratorImpl();
		User user = new UserImpl();
		CartBean cart = new CartBean();
		HttpSession session = request.getSession();
		/**********************************************************************************
		 * This Switch is used for Customer operations.
		 **********************************************************************************
		 */
		switch (action) {
		case "ViewAllFood": {
			List<FoodBean> l = admin.viewAllFood();
			request.setAttribute("foodList", l);
			LOG.debug("in servlet viewAllFood() ");
			URL = "ViewFoodCart.jsp";
		}
			break;
		case "ViewCart": {
			LOG.debug("inside view cart by id servlet customer");
			String foodID = request.getParameter("foodID");
			LOG.debug("food id in view detail:" + foodID);
			FoodBean foodBean = new FoodBean();
			foodBean.setFoodID(foodID);
			foodBean = admin.viewFood(foodID);
			session.setAttribute("foodBean", foodBean);
			LOG.debug("food details ::" + foodBean);
			if (foodBean != null) {
				LOG.debug("in servlet viewProfile() ");
				URL = "addToCart.jsp";
				LOG.debug("in servlet ModifyFoodBD() ");
			}
		}
			break;
		case "AddToCart": {
			FoodBean foodBean = (FoodBean) session.getAttribute("foodBean");
			String userID = (String) session.getAttribute("userID");
			String q = request.getParameter("quantity");
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			LOG.debug("quantity in customer servlet " + quantity);
			double unitCost = foodBean.getPrice();
			int cost = (int) (quantity * unitCost);
			LOG.debug("cost in customer serv ::" + cost);
			Calendar calendar = Calendar.getInstance();
			java.util.Date currentDate = calendar.getTime();
			java.sql.Date CurrentDate = new java.sql.Date(currentDate.getTime());
			LOG.debug("Curr date in customer servlet " + currentDate);
			cart.setUserID(userID);
			cart.setFoodID(foodBean.getFoodID());
			cart.setType(foodBean.getType());
			cart.setQuantity(quantity);
			cart.setCost(cost);
			cart.setOrderDate(CurrentDate);
			customer.addToCart(cart);
			out.println("Item Added Sucessfully in cart!!! \n");
			URL = "CustomerServlet?action=ViewMyCart";
			LOG.debug("item addes in cart");
		}
			break;
		case "ViewMyCart": {
			LOG.debug("In view all cart servlets");
			String userID = (String) session.getAttribute("userID");
			LOG.debug("userID in cart showing::" + userID);
			List<CartBean> l = customer.viewCart(userID);
			request.setAttribute("cartList", l);
			LOG.debug("in servlet viewAllFood() ");
			List<FoodBean> l1 = admin.viewAllFood();
			URL = "MyCart.jsp";
		}
			break;
		case "DeleteCartItem": {
			LOG.debug("inside DeleteCartItem servlet");
			// String cartID = (String) session.getAttribute("cartID");
			String cartID = request.getParameter("cartID");
			LOG.debug("cart ID:" + cartID);
			LOG.debug("storeid for deleting store in serv " + cartID);
			ArrayList<String> l = new ArrayList<String>();
			l.add(cartID);
			LOG.debug("list store id:: " + l);
			int res = customer.removeCart(l);
			if (res == 1) {
				URL = "CustomerServlet?action=ViewMyCart";
				out.println("store Deleted.");
				LOG.debug("store Deleted. :");
			} else {
				out.println("error Food Deleted.");
			}
		}
			break;
		case "ViewForModify": {
			LOG.debug("inside view cart  id for modify in servlet customer");
			String foodID = request.getParameter("foodID");
			String quantity = request.getParameter("quantity");
			LOG.debug("quantity :: " + quantity);
			LOG.debug("food id in view detail:" + foodID);
			int cartID = Integer.parseInt(request.getParameter("cartID"));
			cart.setCartID(Integer.parseInt(request.getParameter("cartID")));
			LOG.debug("cartID:::" + request.getParameter("cartID"));
			request.setAttribute("cartID", cartID);
			FoodBean foodBean = new FoodBean();
			foodBean.setFoodID(foodID);
			foodBean = admin.viewFood(foodID);
			session.setAttribute("foodBean", foodBean);
			request.setAttribute("quantity", quantity);
			LOG.debug("food details ::" + foodBean);
			if (foodBean != null) {
				LOG.debug("in servlet viewProfile() ");
				URL = "ModifyCart.jsp";
				LOG.debug("in servlet ModifyFoodBD() ");
			}
		}
			break;
		case "ModifyCart": {
			FoodBean foodBean = (FoodBean) session.getAttribute("foodBean");
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			cart.setQuantity(quantity);
			cart.setCartID(Integer.parseInt(request.getParameter("cartID")));
			Double price = foodBean.getPrice();
			int cost = (int) (quantity * price);
			cart.setCost(cost);
			LOG.debug("updates cost = " + cost);
			boolean res = customer.modifyCart(cart);
			LOG.debug("res from update cart :::" + res);
			URL = "CustomerServlet?action=ViewMyCart";
		}
			break;
		case "confirmOrder": {
			String totalCost = request.getParameter("totalCost");
			System.out.println("total cost::" + totalCost);
			request.setAttribute("totalCost", totalCost);
			URL = "ConfirmOrder.jsp";
		}
			break;
		case "makePayment": {
			String id = null;
			OrderBean order = new OrderBean();
			String userID = (String) session.getAttribute("userID");
			request.setAttribute("userID", userID);
			System.out.println(".......................in makePayment with uid" + userID);
			LOG.debug("userId in customer servlet " + userID);
			String creditCardNumber = request.getParameter("cardNo");
			String validFrom = request.getParameter("validFrom");
			String validTo = request.getParameter("validTo");
			System.out.println("valid from " + validFrom + "valid to " + validTo);
			PaymentBean payment = customer.viewCreditCard(userID);
			LOG.debug("payment details by DB::" + payment);
			if (creditCardNumber.equals(payment.getCreditCardNumber()) && validFrom.equals(payment.getValidFrom())
					&& validTo.equals(payment.getValidTo())) {
				System.out.println("equals details");
				// cart details of logged in user.
				List<CartBean> cartIDList = customer.viewCart(userID);
				ProfileBean profile = new ProfileBean();
				profile = user.viewProfile(userID);
				order.setOrderStatus("Confirmed");
				order.setUserID(userID);
				order.setStreet(profile.getStreet());
				order.setCity(profile.getCity());
				order.setState(profile.getState());
				order.setPincode(profile.getPincode());
				order.setMobileNo(profile.getMobileNo());
				Calendar calendar = Calendar.getInstance();
				java.util.Date currentDate = calendar.getTime();
				java.sql.Date CurrentDate = new java.sql.Date(currentDate.getTime());
				System.out.println("current date is " + CurrentDate);
				order.setOrderDate(CurrentDate);
				String result = customer.confirmOrder(order, (ArrayList<CartBean>) cartIDList);
				System.out.println("res from confirmOrder() " + result);
				if ("SUCCESS".equals(result)) {
					//REMOVE FROM CART
					ArrayList<String> ListOfCart = new ArrayList<String>();
					//ArrayList<String> quantity = new ArrayList<String>();
					for (CartBean cartbean : cartIDList) {
						int cartID = cartbean.getCartID();
						String cartid = Integer.toString(cartID);
						ListOfCart.add(cartid);
						
						int quantity = cartbean.getQuantity();
						String foodID = cartbean.getFoodID();
						admin.modifyFood(foodID, quantity);
					}
					System.out.println("list::" + ListOfCart);
					int res = customer.removeCart(ListOfCart);
					LOG.debug("store Deleted. :");
					//UPDATE QUANTITY IN FOOD TABLE
					
					
				}
			} else {
				out.print("Please, Enter Valid Detrails");
			}
			URL = "demo.jsp";
		}
			break;
		default:
			out.print("DEFAULT");
			URL = "CustHome.jsp";
			break;
		}
		RequestDispatcher rd = request.getRequestDispatcher(URL);
		rd.include(request, response);
	}
}
