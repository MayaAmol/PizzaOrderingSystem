<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Pizza Order</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
</head>
<body>
<form action="CredentialServlet" name="login" method="post">
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
		<div class="container-fluid">

			<ul class="nav navbar-nav navbar-right">
			
				<li><a href="#"><span class="glyphicon glyphicon-star"></span>
						About Us</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-comment"></span>
						Contact Us</a></li>
				<li><a href="Registrationdemo.jsp"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				
			</ul>
		</div>
		</nav>
		<jsp:include page="login.jsp"></jsp:include>
		<jsp:include page="footer.jsp"></jsp:include>
	
	<!-- script references -->
		<script
			src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</form>
	
</body>
</html>
	