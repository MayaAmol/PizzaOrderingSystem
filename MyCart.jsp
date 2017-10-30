<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Cart</title>
</head>
<body>
	<c:choose>
		<c:when test="${userID!=null}">

			<jsp:include page="UserHeader.jsp"></jsp:include>
			<form action="CustomerServlet" name="" method="post">

				<table height="510" width="90%" align="center">
					<tr>
						<td width="20%"><jsp:include page="UserMenu.jsp"></jsp:include></td>
						<td width="">
							<table class="table table-hover table-bordered" height=""
								align="center" width="50%">
								<tr height="20" class="info">
									<th>Food ID</th>
									<th>Type</th>
									<th>Quantity</th>
									<th>Cost</th>
									<th>Edit</th>
									<th>Delete</th>
									

								</tr>
								<c:forEach items="${cartList}" var="cart">
									<tr class="">
										<td>${cart.quantity}</td>
										<td>${cart.type}</td>
										<td>${cart.quantity}</td>
										<td>${cart.cost}</td>
									
										<td><a
											href="CustomerServlet?action=ViewForModify&foodID=${cart.foodID}&cartID=${cart.cartID}&quantity=${cart.quantity}">
												<span style="color: green;" class="glyphicon glyphicon-edit"> Modify</span></a></td>
												
												<td><a
											href="CustomerServlet?action=DeleteCartItem&cartID=${cart.cartID}" >
												<span style="color: red;" class="glyphicon glyphicon-remove">
												  Remove</span></a></td>

									</tr>
									<c:set var="totalCost" scope="page"
										value="${totalCost + cart.cost}" />

<%-- <td><a
										href="<%=response.encodeURL("CustomerServlet")%>?action=ViewAllFood">Continue
											Shopping</a></td> --%>
								</c:forEach>
								<tr height="25">
									
									<td colspan="7" class="success" align="right"><h3>
											Total Cost:
											<c:out value="${totalCost}" />
										</h3></td>
								</tr>
								<tr height="25">
									
									<td colspan="7" class="success" align="right"><h3>
											<a href="<%=response.encodeURL("CustomerServlet")%>?action=confirmOrder&totalCost=${totalCost}" class="btn-success btn-lg">
													<span class="glyphicon glyphicon-shopping-cart"></span>
													Confirm Order
												</a>
										</h3></td>
								</tr>
							</table>
					</tr>
				</table>

			</form>
			<jsp:include page="footer.jsp"></jsp:include>
			<!-- script references -->
			<script
				src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
			<script src="js/bootstrap.min.js"></script>
		</c:when>
		<c:otherwise>
			<c:out value="Your Session Expire, Please Login">
			</c:out>
			<jsp:include page="UserLogin.jsp" />
		</c:otherwise>
	</c:choose>
</body>
</html>