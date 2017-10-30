<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<meta http-equiv="content-type" content="text/html;charset=utf-8" />

</head>
<body>

	<style type="text/css">
div#menu {
	margin: -100px 0 0 40px;
}
</style>
	<div class="col-xs-4"></div>
	<div align="left">
		<font color="balck">

			<ul class="nav col-xs-10 container">
				<li class="active"><a href="addStore.jsp"><span>Add
							Store</span></a>
				<li><a
					href="<%=response.encodeURL("AdministratorServlet")%>?action=ViewAllStore"><span>View
							Store</span></a></li>
				<li><a
					href="<%=response.encodeURL("AdministratorServlet")%>?action=StoreIDForModify"><span>Modify
							Store</span></a></li>
				<li><a
					href="<%=response.encodeURL("AdministratorServlet")%>?action=StoreID"><span>Delete
							Store</span></a></li>
				<li><a href="addFood.jsp"><span>Add Food</span></a></li>

				<li><a
					href="<%=response.encodeURL("AdministratorServlet")%>?action=ViewAllFood"><span>View
							Food</span></a></li>
				<li><a
					href="<%=response.encodeURL("AdministratorServlet")%>?action=ModifyFood"><span>Modify
							food</span></a></li>
				<li><a
					href="<%=response.encodeURL("AdministratorServlet")%>?action=DeleteFood"><span>Delete
							Food</span></a></li>
				<li><a href="#"><span>Change Order Status</span></a></li>
			</ul>
		</font>
	</div>

</body>
</html>


</body>
</html>