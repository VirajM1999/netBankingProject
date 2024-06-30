<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

/* Form styling */
form {
	width: 400px;
	margin: 134px auto;
	padding: 20px;
	background: white;
	border-radius: 10px;
	box-shadow: 5px 4px 8px 5px rgba(0, 0, 0, 0.2), 5px 6px 20px 5px rgba(0, 0, 0, 0.19);
}

/* Label styling */
label {
	display: block;
	margin-left: 10%;
	font-size: 20px;
	font-weight: bold;
	color: #2753f2;
	margin-bottom: 5px;
}

/* Input styling */
input[type='text'], input[type='password'], input[type='radio']
	{
	width: 80%;
	height: 30px;
	font-size: 15px;
	border: none;
	background-color: #c9c8c7;
	border-radius: 10px;
	text-indent: 10px;
	margin: 5px 10%;
}

/* Radio button styling */
input[type='radio'] {
	display: inline;
	border: 1px solid red; /* Corrected typo in 'solid' */
	height: 15px;
	width: 15px;
	margin-right: 5px; 
}




.form_button{
    width: 100px;
	height: 40px;
	font-size: 18px;
	border: none;
	background-color: #eb4034;
	border-radius: 15px;
	color: white;
    display: block;
    margin: auto;
	margin-top: 15px;

	text-align: center;
}
.form_button:hover
{
    background-color: white;
    color: #eb4034;
    border: 1px solid #eb4034;;
}




#newAccountHeading {
	text-align: center;
	margin-bottom: 30px;
}

#radio_lable_option {
	display: inline;
	width: 100px;
	margin: 0;
	color: black;
	margin-left: 10px;
}





</style>
<link href="../css/main.css" rel="stylesheet">
</head>
<body>
	<nav class="nav_bar">
		<div class="imagelogo">
			<img src="../images/banklogo.png" alt="bank logo" class="logoImage">
			<div class="logText">
				<p class="mgs">MGS BANKING</p>
			</div>
			<div class="clear_div"></div>
		</div>


		<ul class="nav_links">
			<li class="nav_link"><a href="home">Home</a></li>
			<li class="nav_link"><a href="profile">Profile</a></li>
			<li class="nav_link"><a href="#about">About</a></li>
			<li class="nav_link"><a href="logout">LogOut</a></li>
			<div class="clear_div"></div>
		</ul>

		<div class="clear_div"></div>
	</nav>
	<form action="/customer/saveaccount" method="post">
		<h1 id="newAccountHeading">New Account</h1>
		<div class="clear_div"></div>
		<label for="accountType">Account Type:</label> <input type="radio"
			id="accountType" name="accountType" value="saving" class="inputFiled">
		<label for="saving" id="radio_lable_option">Saving</label>
         <input	type="radio" id="accountType" name="accountType" value="current"
			class="inputFiled">
             <label for="current"id="radio_lable_option">Current</label>
              <input type="submit"	value="Add" class="form_button">
	</form>

</body>
</html>