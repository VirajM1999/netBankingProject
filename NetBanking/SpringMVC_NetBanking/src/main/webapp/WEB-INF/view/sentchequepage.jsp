<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	<div class="clear_div"></div>

<h2 class="heading">All Cheques</h2>

	<table border=1>

		<tr>
			<th>ChequeNo</th>
			
			<th>SenderAccountNumber</th>
			<th>ChequeDate</th>
			<th>Amount</th>
			<th>Status</th>
		
			
		</tr>
		<c:forEach var="chequeDetails" items="${sentCheques}">
			<tr>
				<td>${chequeDetails.chequeNumber}</td>
				
				<td>${chequeDetails.senderAccount.getAccountNumber()}</td>
				<td>${chequeDetails.chequeDate}</td>
				<td>${chequeDetails.amount}</td>
				<td>${chequeDetails.status}</td>
				
				
				
			</tr>
		</c:forEach>

	</table>
</body>
</html>