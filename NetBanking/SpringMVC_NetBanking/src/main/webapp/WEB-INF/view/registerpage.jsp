<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link href="../css/main.css" rel="stylesheet">
<style type="text/css">


#formpage_content {
	border-radius: 10px;
	width: 700px;
	margin: auto;
	margin-bottom: 30px;
	background: white;
	box-shadow: 5px 4px 8px 5px rgba(0, 0, 0, 0.2), 5px 6px 20px 5px rgba(0, 0, 0, 0.19);
}

.register_form input {
	display: block;
	margin: auto;
	width: 80%;
	display: inline-block;
	margin: 5px 0px 10px 10%;
	height: 30px;
	font-size: 15px;
	border: none;
	background-color: #c9c8c7;
	border-radius: 10px;
	text-indent: 10px;
}

.register_form label {
	display: block;
	margin-left: 10%;
	font-size: 20px;
	font-weight: bold;
	color: #2753f2;
}

#registerpage_heading {
	text-align: center;
}

.form_Section {
	float: left;
	width: 50%;
	margin-top: 20px;
	padding: 5px;
}

input[type='radio'] {
	display: inline;
	border: 1px sild red;
	height: 15px;
	width: 15px;
}



#radio_lable {
	display: inline;
	width: 100px;
	margin: 0px;
}

.form_button {
	margin-right: 20px;
	width: 150px;
	height: 30px;
}

#form_buttons_div {
	display: block;
	width: 400px;
	margin: auto;
	margin-top: 20px;
}
#loginLink
{
	margin-top:20px;
	text-align: center;
}

#radio_lable_option {
	display: inline;
	width: 100px;
	margin: 0px;
	color: black;
}

.register_button {
	border: none;
	background-color: #eb4034;
	color: white;
	border-radius: 10px;
}

.reset_button {
	border: none;
	background-color: #0687a1;
	color: white;
	border-radius: 10px;
}
.nav_bar
{
border:1px solid black;
}

</style>


</head>
<body>
	<!-- <div class="main_image_div"> -->
	<div id="main_div">
		<nav class="nav_bar">
			<div class="imagelogo">
				<img src="../images/banklogo.png" alt="bank logo" class="logoImage">
				<div class="logText">
					<p class="mgs">MGS BANKING</p>

				</div>
				<div class="clear_div"></div>
			</div>
			<div class="clear_div"></div>

		</nav>
		<div id="formpage_content">

			<h1 id="registerpage_heading">Register Customer</h1>
			<form action="/customer/register" method="post" class="register_form">
				<div class="form_Section">
					<label for="first_name">First Name:</label> <input type="text"
						name=firstName id="firstName" class="inputFiled"
						placeholder="Enter Your Name"> <label for="last_name">Last
						Name:</label>
					<!--  Last Name: -->

					<input type="text" name="lastName" id="lastName" class="inputFiled"
						placeholder="Enter Your LastName"> <label for="password">Password:</label>

					<input type="password" name="loginDetails.password"
						id="loginDetails.password" class="inputFiled"> <label
						for="password">Confirm Password:</label> <input type="password"
						 id="loginDetails.password"
						class="inputFiled"> <label for="password">Role:</label> <input
						type="text" name="loginDetails.role" id="loginDetails.role"
						value="customer" class="inputFiled" readonly="readonly">

				</div>

				<div class="form_Section">
					<label for="email">Email:</label> <input type="text" name="email"
						id="email" class="inputFiled" placeholder="Enter Your email">

					<label for="phone_number">Phone Number:</label> <input type="text"
						name="phoneNumber" id="phoneNumber" class="inputFiled"
						placeholder="Enter Your PhoneNo"> <label for="city">City:</label>

					<input type="text" name="city" id="city" class="inputFiled"
						placeholder="Enter Your City"> <label for="pan">PAN
						:</label> <input type="text" name="panNo" id="panNo" class="inputFiled"
						placeholder="Enter Your PanNo"> <label for="adhar">Adhar
						Number:</label> <input type="text" name="adhaarNo" id="adhaarNo"
						class="inputFiled" placeholder="Enter Your AdharNo">
				</div>
				<div class="clear_div"></div>

				<label for="accountType">Account Type:</label> <input type="radio"
					id="accountType" name="accountType" value="saving"
					class="inputFiled"> <label for="saving"
					id="radio_lable_option">Saving</label> <input type="radio"
					id="accountType" name="accountType" value="current"
					class="inputFiled"> <label for="current"
					id="radio_lable_option">Current</label><br>

				<div id="form_buttons_div">
					<button type="submit" value="Register"
						class="form_button register_button">Register</button>
					<button type="reset" value="reset" class="form_button reset_button">Reset</button>

				</div>


			</form>
			<p id="loginLink">
				Already Register?<a href="loginpage">Login</a>
			</p>






		</div>
	</div>
	<!-- </div> -->

</body>
</html>