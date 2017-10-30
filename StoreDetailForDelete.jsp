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
				<table height="470" width="90%">
					<tr>
						<td width="30%"><jsp:include page="menu.jsp"></jsp:include></td>

						<td width="70%" colspan="1" height="450" align="center">
							<div id="" class="">
								<div class="col-xs-2"></div>
								<div class="modal-header">
									<h3 class="">Store Details</h3>
								</div>
								<div class="modal-body">
									<div>&nbsp;</div>
									<div align="left">
										<label for="inputEmail" class="control-label col-xs-3">
											Store ID:</label>
										<div class="col-xs-9">${storeBean.storeID}</div>
										<input type="hidden" name="storeID" value="${storeBean.storeID}">	
									</div>
									<div>&nbsp;</div>
									<div align="left">
										<label for="inputEmail" class="control-label col-xs-3">
											Store Name:</label>
										<div class="col-xs-9">${storeBean.name}</div>
									</div>
									<div>&nbsp;</div>
									<div align="left">
										<label for="inputEmail" class="control-label col-xs-3">
											Street:</label>
										<div class="col-xs-9">${storeBean.street}</div>
									</div>
									<div>&nbsp;</div>

									<div align="left">
										<label for="inputEmail" class="control-label col-xs-3">
											MobileNo:</label>
										<div class="col-xs-9">${storeBean.mobileNo}</div>
									</div>
									<div>&nbsp;</div>
									<div align="left">
										<label for="" class="control-label col-xs-3">
											City:</label>
										<div class="col-xs-9">${storeBean.city}</div>
									</div>
									<div>&nbsp;</div>
									<div align="left">
										<label for="inputEmail" class="control-label col-xs-3">
											State:</label>
										<div class="col-xs-9">${storeBean.state}</div>
									</div>
									<div>&nbsp;</div>
									<div align="left">
										<label for="inputEmail" class="control-label col-xs-3">
											Pincode:</label>
										<div class="col-xs-9">${storeBean.pincode}</div>
									</div>
									<div>&nbsp;</div>


									<div>
										<label for="inputEmail" class="control-label col-xs-4">
										</label>
										<div class="col-xs-8" align="right">
											<button class="btn btn-warning btn-lg col-xs-3 "
												name="action" value="DeleteStoreDB">Delete</button>
										</div>
									</div>
									<div>&nbsp;</div>
								</div>
							</div>
						</td>
					</tr>
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