<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="g"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

</style>
<link href="../css/main.css" rel="stylesheet">
</head>
<body>
	<nav class="nav_bar">
		<div class="imagelogo">
			<img src="/images/banklogo.png" alt="bank logo" class="logoImage">
			<div class="logText">
				<p class="mgs">MGS BANKING</p>
			</div>
			<div class="clear_div"></div>
		</div>


		<ul class="nav_links">
			<li class="nav_link"><a href="#home">Home</a></li>
			<li class="nav_link"><a href="profile">Profile</a></li>
			<li class="nav_link"><a href="#about">About</a></li>
			<li class="nav_link"><a href="logout">LogOut</a></li>
			<div class="clear_div"></div>
		</ul>

		<div class="clear_div"></div>


	</nav>
	<h1 class="heading">Customer Details</h1>
	<table border=1>
		<tr>
			<th>Customer ID</th>
			<td>${customerDetailsKey.customerId}</td>
		</tr>
		<tr>
			<th>First Name</th>
			<td>${customerDetailsKey.firstName}</td>
		</tr>
		<tr>
			<th>Last Name</th>
			<td>${customerDetailsKey.lastName}</td>
		</tr>
		<tr>
			<th>Email</th>
			<td>${customerDetailsKey.email}</td>
		</tr>
		<tr>
			<th>Phone Number</th>
			<td>${customerDetailsKey.phoneNumber}</td>
		</tr>
		<tr>
			<th>City</th>
			<td>${customerDetailsKey.city}</td>
		</tr>
		<tr>
			<th>PAN Number</th>
			<td>${customerDetailsKey.panNo}</td>
		</tr>
		<tr>
			<th>Adhaar Number</th>
			<td>${customerDetailsKey.adhaarNo}</td>
		</tr>
		<tr>
			<th>Login Id</th>
			<td>${customerDetailsKey.loginDetails.loginId}</td>
	</table>

</body>
</html>