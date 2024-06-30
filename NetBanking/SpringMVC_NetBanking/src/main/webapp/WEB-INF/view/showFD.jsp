<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

</style>
<link href="/css/main.css" rel="stylesheet">
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
			<li class="nav_link"><a href="/customer/home">Home</a></li>
			<li class="nav_link"><a href="/customer/profile">Profile</a></li>
			<li class="nav_link"><a href="#about">About</a></li>
			<li class="nav_link"><a href="customer/logout">LogOut</a></li>
			<div class="clear_div"></div>
		</ul>

		<div class="clear_div"></div>


	</nav>

	<h1 class="heading">Fix Deposit Details</h1>
	<table>
		<tr>
			<th>FixDeposit ID</th>
			<th>Account Number</th>
			<th>Date of Creation</th>
			<th>Rate of Interest</th>
			<th>FD Amount</th>

		</tr>
		<c:forEach var="fixDepositByAccount" items="${fixDepositByAccountKey}">
			<tr>
				<td>${fixDepositByAccount.fixdepositeId}</td>
				<td>${fixDepositByAccount.accountNumber}</td>
				<td>${fixDepositByAccount.dateOfCreation}</td>
				<td>${fixDepositByAccount.rateOfInterest}</td>
				<td>${fixDepositByAccount.fdAmount}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>