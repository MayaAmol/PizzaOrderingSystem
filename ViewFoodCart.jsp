<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
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
							<table class="table table-hover table-bordered" height="50%"
								align="center" width="50%">
								<tr class="info">
									<th>Food ID</th>
									<th>Food Name</th>
									<th>Food Size</th>
									<th>Price</th>
									<th>Type</th>
									<th>Add</th>
								</tr>
								<c:forEach items="${foodList}" var="food">
									<tr class="warning">
										<td>${food.foodID}</td>
										<td>${food.name}</td>
										<td>${food.foodSize}</td>
										<td>${food.price}</td>
										<td>${food.type}</td>
										<td><a
											href="CustomerServlet?action=ViewCart&foodID=${food.foodID}">Add
												to cart</a></td>
									</tr>

								</c:forEach>
							</table>

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