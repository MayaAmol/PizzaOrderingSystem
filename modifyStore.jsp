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
				<table height="510" width="90%" align="center">

					<tr>
						<td width="25%"><jsp:include page="menu.jsp"></jsp:include></td>
						<td>
							<div align="left">
								<label for="inputEmail" class="control-label col-xs-2">
									Select Food ID:</label>
								<div class="col-xs-5">
									<select class="form-control" id="storeID" name="storeID">
										<c:forEach items="${storeList}" var="store">
											<option value="${store.storeID}">${store.storeID}</option>
										</c:forEach>
									</select>
								</div>
								<br>
								<div>&nbsp;</div>
								<div>
									<br> <label for="inputEmail"
										class="control-label col-xs-2"> </label>
									<div>
										<button class="btn btn-primary" name="action"
											value="searchStoreForModify">Search</button>
									</div>
								</div>
							</div>
						</td>
					</tr>
				</table>
				<jsp:include page="footer.jsp"></jsp:include>
			</form>
			<br>
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