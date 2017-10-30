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
		
				<table height="450" width="100%">

					<tr><td width="25%"><br><br><br><br><jsp:include page="menu.jsp"></jsp:include></td>
						<td width="75%"><display:table id="data" list="${foodList}" pagesize="3"
								export="true" sort="list" class="table">
								<display:column property="foodID" title="foodID" sortable="true" />
								<display:column property="name" title="Name" sortable="true" />
								<display:column property="type" title="Type" sortable="true" />
								<display:column property="foodSize" title="foodSize"
									sortable="true" />
								<display:column property="quantity" title="Quantity"
									sortable="true" />
								<display:column property="price" title="Price" sortable="true" />
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
			<jsp:include page="UserLogin.jsp" />
		</c:otherwise>
	</c:choose>
</body>
</html>