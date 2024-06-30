<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- <style type="text/css">
* {
	padding: 0px;
	margin: 0px;
	box-sizing: border-box;
}
body {
    background: #b1b1b1;
    font-family: Arial, sans-serif;
}
.logoImage {
	float: left;
	height: 50px;
	width: 100px;
}

.logText {
	margin-top: 3px;
	float: left;
	font-size: 22px;
	text-align: center;
	color: antiquewhite;
}

.logText>p {
	font-weight: bolder;
}

.mgs {
	font-weight: bolder;
	color: antiquewhite;
	font-size: 35px;
}

.clear_div {
	clear: both;
}

.imagelogo {
	float: left;
	margin-left: 20px;
}

.nav_links {
	display: inline;
	float: right;
	margin-right: 20px;
}


.nav_link {
	float: left;
	color: white;
	list-style: none;
	display: block;
	height: 50px;
	margin: 0px 15px 0px 15px;
	padding: 15px 0px;
}

.nav_link>a {
	text-decoration: none;
	color: white;
	font-size: 20px;
}

.nav_link>a:hover {
	color: #eb4034;
}


.nav_bar {
        background-color:#172947;
        margin-bottom: 20px;
        padding: 10px 0;
        text-align: center;
        color: antiquewhite;
  }


.heading {
	text-align: center;
	margin: 20px 0px;
	font-size: 40px;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

table {
	margin: auto;
	margin-top: 20px;
	dorder: none;
}

th {
	padding: 10px;
	font-size: 22px;
	text-align: center;
	background-color: #0855d1;
	color: white;
	border: none;
}

td {
	padding: 10px;
	font-size: 20px;
	text-align: center;
	border: none;
}

tr:nth-child(even) {
background-color:#f5e1b8;
}
tr:nth-child(odd)
{
background-color: white;
} 
</style> -->
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
			<li class="nav_link"><a href="/customer/logout">LogOut</a></li>
			<div class="clear_div"></div>
		</ul>

		<div class="clear_div"></div>


	</nav>

	<h1 class="heading">My Transaction Details</h1>
	<table border=1>
		<tr>
			<th>TransactionID</th>
			<th>TransactionDate</th>
			<th>RecieverAccountNumber</th>
			<th>SenderAccountNumber</th>
			<th>TransactionAmount</th>
		</tr>
		<c:forEach var="TransactionDetails" items="${TrasectionlistAll}">
			<tr>
				<td>${TransactionDetails.transactionId}</td>
				<td>${TransactionDetails.transactionDate}</td>
				<td>${TransactionDetails.recieverAccount.getAccountNumber()}</td>
				<td>${TransactionDetails.senderAccount.getAccountNumber()}</td>
				<td>${TransactionDetails.transactionAmount}</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>