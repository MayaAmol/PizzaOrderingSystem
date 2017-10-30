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

				<table height="510" width="85%" align="center" class="">
				
					<tr>
						<td width="25%"> <jsp:include page="menu.jsp"></jsp:include></td>
						<td width="75%"><div class="modal-header">
								<h3 align="center">Store Details</h3>
							</div>
						<display:table id="data" list="${storeList}"
								pagesize="4" export="true" sort="list" class="table">
								<display:column property="storeID" title="StoreID"
									sortable="true"/>
								<display:column property="name" title="StoreName"
									sortable="true" />
								<display:column property="street" title="Street" sortable="true" />
								<display:column property="mobileNo" title="Mobileno"
									sortable="true" />
								<display:column property="city" title="City" sortable="true" />
								<display:column property="state" title="State" sortable="true" />
								<display:column property="pincode" title="Pincode"
									sortable="true" />
							</display:table></td>
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
		</c:otherwise>
	</c:choose>
</body>
</html>