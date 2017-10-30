<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>

<link rel="stylesheet" href="/resources/demos/style.css" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


<style>
.datepicker {
	
}
</style>

<script>
  $(function() {
    $( ".datepicker" ).datepicker();
  });
  </script>

<script type="text/javascript">
  function validate(){
	  if(document.reg_frm.firstName.value=="")
		{
		document.getElementById('fname').innerHTML="Don't leave the First name as empty";
		document.reg_frm.firstName.focus();
		return false;
		}	
	else{
		document.getElementById('fname').innerHTML="";
		}
	  if(document.reg_frm.lastName.value=="")
		{
		//window.alert("Dont leave the First name as empty!!!");
		document.getElementById('lname').innerHTML="Don't leave the Last name as empty";
		document.reg_frm.lastName.focus();
		return false;
		}	
	else{
		document.getElementById('lname').innerHTML="";
		/* document.reg_frm.firstName.focus();
	    return true; */
	}
	  if(!document.reg_frm.dateOfBirth.value==""){
			re = /^(\d{2})\/(\d{1,2})\/(\d{4})$/;

		   
		      if(regs = document.reg_frm.dateOfBirth.value.match(re)) {
		        // day value between 1 and 31
		        if(regs[1] < 1 || regs[1] > 12) {
		        	document.getElementById('dob').innerHTML="Invalid value for Month: " + regs[1];
		          //alert("Invalid value for day: " + regs[1]);
		          document.reg_frm.dateOfBirth.focus();
		          return false;
		        }
		        else{
		        	document.getElementById('dob').innerHTML="";
		        }
		        // month value between 1 and 12
		        if(regs[2] < 1 || regs[2] > 31) {
		        	document.getElementById('dob').innerHTML="Invalid value for Day: " + regs[2];
		          //alert("Invalid value for month: " + regs[2]);
		          document.reg_frm.dateOfBirth.focus();
		          return false;
		        }
		        else{
		        	document.getElementById('dob').innerHTML="";
		        }
		        // year value between 1902 and 2016
		        if(regs[3] < 1902 || regs[3] > (new Date()).getFullYear()) {
		        	document.getElementById('dob').innerHTML="Invalid value for year: " + regs[3] + " - must be between 1902 and " + (new Date()).getFullYear();
		        //  alert("Invalid value for year: " + regs[3] + " - must be between 1902 and " + (new Date()).getFullYear());
		          document.reg_frm.dateOfBirth.focus();
		          return false;
		        }
		        else{
		        	document.getElementById('dob').innerHTML="";
		        }
		      } 
		       else {
		    	   document.getElementById('dob').innerHTML="Invalid date format: " +document.reg_frm.dateOfBirth.value;
		        //alert("Invalid date format: " +document.reg_frm.dateOfBirth.value);
		        form.startdate.focus();
		        return false;
		      }
					
		}
		else{
			 document.getElementById('dob').innerHTML="DOB Should not be empty";
			//window.alert("DOB Should not be empty");
			document.reg_frm.dateOfBirth.focus();
			return false;	
		}
	  if(document.reg_frm.gender.value=="select"){
		  document.getElementById('sel').innerHTML="Select One";
		  document.reg_frm.gender.focus();
			return false;
	  }
	  else
		{
		document.getElementById('sel').innerHTML="";
		}
	  
	  
	  
	  if(document.reg_frm.street.value==""){
			document.getElementById('srt').innerHTML="Dont leave the Street as empty!!!";
			//window.alert("Dont leave the State as empty!!!");
			document.reg_frm.street.focus();
			return false;
		}
		else
			{
			document.getElementById('srt').innerHTML="";
			}
	 if(document.reg_frm.location.value==""){
			document.getElementById('loc').innerHTML="Dont leave the Location as empty!!!";
			//window.alert("Dont leave the State as empty!!!");
			document.reg_frm.location.focus();
			return false;
		}
		else
			{
			document.getElementById('loc').innerHTML="";
			}
	  if(document.reg_frm.city.value==""){
			document.getElementById('cty').innerHTML="Dont leave the City as empty!!!";
			//window.alert("Dont leave the State as empty!!!");
			document.reg_frm.city.focus();
			return false;
		}
		else
			{
			document.getElementById('cty').innerHTML="";
			}
	  if(document.reg_frm.state.value==""){
			document.getElementById('ste').innerHTML="Dont leave the State as empty!!!";
			//window.alert("Dont leave the State as empty!!!");
			document.reg_frm.state.focus();
			return false;
		}
		else
			{
			document.getElementById('ste').innerHTML="";
			}
	  
	  if(!document.reg_frm.pincode.value==""){
			var pc=/^[1-9]\d{5}$/;
			if(!(pc.test(document.reg_frm.pincode.value)))
				{
				document.getElementById('pin').innerHTML="Only 6 digits numbers and should not start with zero !!!";
				//window.alert("Only 6 digits numbers and should not start with zero !!!");
				document.reg_frm.pincode.focus();
				return false;
				}
			else
			{
			document.getElementById('pin').innerHTML="";
			}
		}
		else
		{
				
			document.getElementById('pin').innerHTML="Dont leave the Pincode as empty!!!";
			//window.alert("Dont leave the Pincode as empty!!!");
			document.reg_frm.pincode.focus();
			return false;
		}
	  if(!document.reg_frm.mobile.value==""){
			if(isNaN(document.reg_frm.mobile.value))
			{ 
				//window.alert("Numbers only allowed");
				document.getElementById('ph').innerHTML="Numbers only allowed";
				document.reg_frm.mobile.focus();
				return false;
			}
			else{
				document.getElementById('ph').innerHTML="";
			}
			if(document.reg_frm.mobile.value.length==10){
				var rg=/^[0]?[789]\d{9}$/;
				if(!(rg.test(document.reg_frm.mobile.value))){
					//window.alert("Mobile number should starts with 7 or 8 or 9");
					document.getElementById('ph').innerHTML="Mobile number should starts with 7 or 8 or 9";
					document.reg_frm.mobile.focus();
					return false;	
				}
				else{
					document.getElementById('ph').innerHTML="";
				}
			}
			else{
				document.getElementById('ph').innerHTML="Phone number should be 10 digits";
				//window.alert("Phone number should be 10 digits");
				document.reg_frm.mobile.focus();
				return false;	
			}		
		}
		else
		{
			document.getElementById('ph').innerHTML="Dont leave the Phone as empty!!!";
			//window.alert("Dont leave the Phone as empty!!!");
			document.reg_frm.mobile.focus();
			return false;			
		}
		
		 if(!document.reg_frm.emailID.value==""){
			    var ex=/^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/;
			    if(!(ex.test(document.reg_frm.emailID.value))){
			    	//window.alert("Invalid Email");
			    	document.getElementById('email').innerHTML="Invalid Email";
					document.reg_frm.emailID.focus();
					return false;		
				} 
			    else{
			    	document.getElementById('email').innerHTML="";
			    }
			}		
			else{	
				//window.alert("Dont leave the Email as empty!!!");
				document.getElementById('email').innerHTML="Dont leave the Email as empty";
				document.reg_frm.emailID.focus();
				return false;
			} 
			
			if(!document.reg_frm.password.value==""){
				
				var minNumberofChars = 8;
			    var maxNumberofChars = 18;
			    var regularExpression  = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,18}$/;
			    
			    if(!(document.reg_frm.password.value.length < minNumberofChars || document.reg_frm.password.value.length > maxNumberofChars)){
			    	
			    	 if(!(regularExpression.test(document.reg_frm.password.value))) {
					       // window.alert("password should contain atleast one number and one special character");
					       document.getElementById('pwd').innerHTML="password should contain atleast one number and one special character";
					        document.reg_frm.password.focus();
					        return false;
					    }	
			    	 else{
			    		 document.getElementById('pwd').innerHTML="";
			    	 }
			    }
			    else{	    	
			    	//window.alert("Password Length Should be with in 8 & 18");
			    	document.getElementById('pwd').innerHTML="Password Length Should be with in 8 & 18";
					document.reg_frm.password.focus();
					return false;	
			  } 
				
			}
			else{					
				//window.alert("Dont leave the Password as empty!!!");
				document.getElementById('pwd').innerHTML="Dont leave the Password as empty";
				document.reg_frm.password.focus();
				return false;	
			}  
	  	  return true;
  }
  </script>
</head>

<body>
	<form name="reg_frm" action="CredentialServlet" method="post"
		onsubmit="return validate()">
		
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
		
		
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="text-center">New Customer Registration</h4>
			</div>
			<div class="modal-body">
				<table align="center" width="70%">
					<tr>
						<td width="20%" >First Name</td>
						<td width="50%" ><input type="text" name="firstName" value="" class="form-control"></td>
						<td><span style="color: red;" id="fname"></span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td>Last Name</td>
						<td><input type="text" name="lastName" value="" class="form-control"></td>
						<td><span style="color: red;" id="lname"></span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td>DOB</td>
						<td><input type="text" name="dateOfBirth" class="datepicker form-control">
							<span style="color: red;" id="dob"></span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td>Gender</td>
						<td><select name="gender" class="form-control">
								<option value="select">--Select--</option>
								<option value="male">Male</option>
								<option value="female">Female</option>
						</select></td>
						<td><span style="color: red;" id="sel"></span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td>Street</td>
						<td><input type="text" name="street" value="" class="form-control"></td>
						<td><span style="color: red;" id="srt"></span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td>Location</td>
						<td><input type="text" name="location" value="" class="form-control"></td>
						<td><span style="color: red;" id="loc"></span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td>City</td>
						<td><input type="text" name="city" value="" class="form-control"></td>
						<td><span style="color: red;" id="cty"></span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td>State</td>
						<td><input type="text" name="state" value="" class="form-control"></td>
						<td><span style="color: red;" id="ste"></span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td>PinCode</td>
						<td><input type="text" name="pincode" value="" class="form-control"></td>
						<td><span style="color: red;" id="pin"></span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td>MobileNo</td>
						<td><input type="text" name="mobile" value="" class="form-control"></td>
						<td><span style="color: red;" id="ph"></span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td>EmailID</td>
						<td><input type="text" name="emailID" value="" class="form-control"></td>
						<td><span style="color: red;" id="email"></span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password" value="" class="form-control"></td>
						<td><span style="color: red;" id="pwd"></span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
					<td></td>
						<td colspan="1" class=""><input class="btn btn-primary btn-lg col-xs-8 btn-block" type="submit" name="action"
							value="Register"></td>
					</tr>
				</table>
				</div>
				</div>
			
	</form>
	<br>
</body>
</html>
