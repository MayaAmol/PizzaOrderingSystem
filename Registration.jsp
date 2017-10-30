<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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


	<jsp:include page="header.jsp"></jsp:include>
	<form action="CredentialServlet" name="change" method="post">
		<table border="0" cellspacing="0" align="center" bgcolor="#b3ecff">
			<tr>
				<td height="450" colspan="2">
					<table border="0" cellspacing="1" align="center" bgcolor="#b3ecff">
						<div>&nbsp;</div>
						<tr align="center">
							<td width="800" colspan="2" height="450" align="center">
								<div>
									<div class="modal-content">
										<div class="modal-header">
											<h4 class="text-center">
												New Customer Registration
												</h4>
										</div>
										<div class="modal-body">
											<div align="left">
												<label for="inputEmail" class="control-label col-xs-3">
													First Name:</label>
												<div class="col-xs-9">
													<input type="text" class="form-control" name="firstName"
														placeholder="First Name">
												</div>
											</div>
											<div>&nbsp;</div>
											<div align="left">
												<label for="inputEmail" class="control-label col-xs-3">
													Last Name:</label>
												<div class="col-xs-9">
													<input type="text" class="form-control" name="lastName"
														placeholder="Last Name">
												</div>
											</div>
											<div>&nbsp;</div>

											<div align="left">
												<label for="inputEmail" class="control-label col-xs-3">
													Date Of Birth:</label>
												<div class="col-xs-9">
													<input type="text" class="form-control" name="dateOfBirth"
														placeholder="DD/MM/YYY">
												</div>
											</div>
											<div>&nbsp;</div>

											<div align="left">
												<label for="inputEmail" class="control-label col-xs-3">
													Gender:</label>
												<div class="col-xs-9">
													<select class="form-control" id="gender" name="gender">
														<option value="Male">Male</option>
														<option value="Female">Female</option>
													</select>
												</div>
											</div>
											<div>&nbsp;</div>

											<div align="left">
												<label for="inputEmail" class="control-label col-xs-3">
													Street:</label>
												<div class="col-xs-9">
													<input type="text" class="form-control" name="street"
														placeholder="Street Name">
												</div>
											</div>
											<div>&nbsp;</div>

											<div align="left">
												<label for="inputEmail" class="control-label col-xs-3">
													Location:</label>
												<div class="col-xs-9">
													<input type="text" class="form-control" name="location"
														placeholder="Location">
												</div>
											</div>
											<div>&nbsp;</div>

											<div align="left">
												<label for="inputEmail" class="control-label col-xs-3">
													City:</label>
												<div class="col-xs-9">
													<input type="text" class="form-control" name="city"
														placeholder="city">
												</div>
											</div>
											<div>&nbsp;</div>

											<div align="left">
												<label for="inputEmail" class="control-label col-xs-3">
													State:</label>
												<div class="col-xs-9">
													<input type="text" class="form-control" name="state"
														placeholder="State">
												</div>
											</div>
											<div>&nbsp;</div>

											<div align="left">
												<label for="inputEmail" class="control-label col-xs-3">
													Pincode:</label>
												<div class="col-xs-9">
													<input type="number" class="form-control" name="pincode"
														placeholder="6 digit pincode" maxlength="6">
												</div>
											</div>
											<div>&nbsp;</div>

											<div align="left">
												<label for="inputEmail" class="control-label col-xs-3">
													Mobile Number:</label>
												<div class="col-xs-9">
													<input type="number" class="form-control" name="mobile"
														placeholder="10 Digit mobile Number" maxlength="10">
												</div>
											</div>
											<div>&nbsp;</div>

											<div align="left">
												<label for="inputEmail" class="control-label col-xs-3">
													Email ID:</label>
												<div class="col-xs-9">
													<input type="email" class="form-control" name="email"
														placeholder="eg. name123@wipro.com">
												</div>
											</div>
											<div>&nbsp;</div>

											<div align="left">
												<label for="inputEmail" class="control-label col-xs-3">
													Enter Password:</label>
												<div class="col-xs-9">
													<input type="password" class="form-control" name="password"
														placeholder="********">
												</div>
											</div>
											<div>&nbsp;</div>

											<div align="left">
												<label for="inputEmail" class="control-label col-xs-3">
													Confirm Password:</label>
												<div class="col-xs-9">
													<input type="password" class="form-control"
														name="confirmPass" placeholder="********">
												</div>
											</div>
											<div>&nbsp;</div>

											<div>
												<label for="inputEmail" class="control-label col-xs-4">
												</label>
												<div class="col-xs-8" align="right">
													<button class="btn btn-primary btn-lg col-xs-8 btn-block"
														name="action" value="Register">Register</button>
												</div>
											</div>

											<div>&nbsp;</div>

										</div>
									</div>
								</div> &nbsp;
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<jsp:include page="footer.jsp"></jsp:include>
		<!-- script references -->
		<script
			src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</form>

</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Pizza Order</title>
<!-- <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
 --></head>
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
						<li><a href="UserLogin.jsp"><span class="glyphicon glyphicon-log-in"></span>
					Login</a></li>
				
			</ul>
		</div>
		</nav>
		<jsp:include page="Registrationdemo.jsp"></jsp:include>
		<jsp:include page="footer.jsp"></jsp:include>
	
	<!-- script references -->
		<script
			src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</form>
	
</body>
</html>
	