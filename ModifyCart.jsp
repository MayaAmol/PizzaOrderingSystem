<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${userID!=null}">
			<%-- <%
System.out.print("id:"+ userID +" food bean "); %> --%>
			<jsp:include page="UserHeader.jsp"></jsp:include>
			<form action="CustomerServlet" name="" method="post">

				<table height="510" width="90%" align="center">
					<tr>
						<td width="20%"><jsp:include page="UserMenu.jsp"></jsp:include></td>
						<td width="50%" align="center">
							<div class="modal-content col-xs-9" align="center">
								<div class="modal-header">
									<table class="table table-hover" height="100%" align="center"
										width="90%" border="0">
										<tr class="info">
											<td colspan="2" align="center"><h3>Your selected
													Pizza Details</h3></td>
										</tr>
										<tr><td><input type="hidden" value="${cartID}" name="cartID" ></td></tr>
										<tr>
											<th width="50%">Food ID:</th>
											<td>${foodBean.foodID}</td>
										</tr>
										<tr>
											<th>Name:</th>
											<td>${foodBean.name}</td>
										</tr>
										<tr>
											<th>Type:</th>
											<td>${foodBean.type}</td>
										</tr>
										<tr>
											<th>Size:</th>
											<td>${foodBean.foodSize}</td>
										</tr>
										<tr>
											<th>Unit Price:</th>
											<td>${foodBean.price}</td>
										</tr>
										<tr>
											<th>Enter Quantity:</th>
											<td><input type="text" name="quantity" value="${quantity }"></td>
										</tr>

										<%-- 		<tr>
											<th>Total Price:</th>
											<td><input type="text" name="totalPrice" value="${foodBean.price}"></td>
										</tr> --%>

										<tr>
											<td><a
												href="<%=response.encodeURL("CustomerServlet")%>?action=ViewAllFood"> Cancel </a></td>
											<td colspan="1" align="right">
												<button type="submit" value="ModifyCart" name="action"
													class="btn-info btn-lg">
													<span class="glyphicon glyphicon-shopping-cart"></span>
													Modify Cart
												</button>

											</td>
										</tr>
									</table>
								</div>
							</div>
						</td>
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
			<%-- <jsp:include page="<%=response.encodeURL("CredentialServlet")%>?action=LOGOUT&userID=${userID}" /> --%>
		</c:otherwise>
	</c:choose>
</body>
</html>