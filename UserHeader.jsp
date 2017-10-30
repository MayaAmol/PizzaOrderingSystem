<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Bootstrap Case</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header navbar-brand">
			<img src="images/wipro_logo.jpg" height="85" width="100"> </a>
		</div>
		<ul class="nav navbar-nav">
			<li class="dropdown"><a href="#" data-toggle="dropdown"><font
					size="5" color="white">Online Pizza Ordering system </font></a></li>

		</ul>
	</div>
	<div class="container-fluid" align="center">
	<div class="navbar-header navbar-brand col-xs-2">
			<!-- <img src="images/wipro_logo.jpg" height="87" width="100"> --> </a>
		</div>
		<ul class="nav navbar-nav" >
			<li class="dropdown"><a href="#" data-toggle="dropdown"><font
					color="white">Welcome, ${userID } </font></a></li>

		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="<%=response.encodeURL("CustomerServlet")%>?action=ViewAllFood"><span
					class="glyphicon glyphicon-home"></span> Home</a></li>
			<li><a href="#"><span class="glyphicon glyphicon-star"></span>
					About Us</a></li>
			<li><a href="#"><span class="glyphicon glyphicon-comment"></span>
					Contact Us</a></li>
			<li><a
				href="<%=response.encodeURL("CredentialServlet")%>?action=LOGOUT&userID=${userID}"><span
					class="glyphicon glyphicon-log-out"></span> Logout</a></li>
		</ul>
	</div>
	</nav>
	<div>
</body>
</html>
