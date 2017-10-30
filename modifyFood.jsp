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

			<jsp:include page="header.jsp"></jsp:include>
			<form action="AdministratorServlet" name="login" method="post">
				<table height="470" width="100%">
					<tr>
						<td width="25%"><jsp:include page="menu.jsp"></jsp:include></td>
						<td><label for="inputEmail" class="control-label col-xs-2">
								Select Food ID:</label>
							<div class="col-xs-7">
								<select class="form-control" id="foodID" name="foodID">
									<c:forEach items="${foodList}" var="food">
										<option value="${food.foodID}">${food.foodID}</option>
									</c:forEach>
								</select>
							</div> <br>
							<div>&nbsp;</div>
							<div>
								<br> <label for="inputEmail" class="control-label col-xs-2">
								</label>
								<div class="col-xs-3"></div>
								<div>
									<button class="btn btn-success btn-lg col-xs-2" name="action"
										value="SearchFoodForModify">Search</button>
								</div>

							</div></td>
				</table>

			</form>
			<br>
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