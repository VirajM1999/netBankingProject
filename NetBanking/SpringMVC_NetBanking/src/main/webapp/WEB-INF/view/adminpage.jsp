<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminPage</title>


<style type="text/css">

button{
	background-color: #eb4034;
    border: none;
    padding: 10px 15px 10px 15px;
    color: #ecdab5;
    font-weight: 800;
    font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
    border-radius: 10px;


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
			<li class="nav_link"><a href="/admin/logout">LogOut</a></li>
			<div class="clear_div"></div>
		</ul>
			
            
				
            <div class="clear_div"></div>


        </nav>
    
    <div>
    	<h1 class="heading">Accounts to be Approved</h1>
	<table class="account_approval_table">
		<tr>
			<th>customerId</th>
			<th>AccountNumber</th>
			<th>AccountType</th>
			<th>balance</th>
			<th>overdraftBalance</th>
			<th>rateOfInterest</th>
			<th>isApproved</th>
			<th>Creation Date</th>
			<th>Action</th>
			
		</tr>
		<c:forEach var="accountList" items="${AccountList}">
			<tr>
				<td>${accountList.customerId}</td>
				<td>${accountList.accountNumber}</td>
				<td>${accountList.accountType}</td>
				<td>${accountList.balance}</td>
				<td>${accountList.overdraftBalance}</td>
				<td>${accountList.rateOfInterest}</td>
				<td>${accountList.isApproved}</td>
				<td>${accountList.accountCreationDate}</td>
				<td><button onclick="document.location='/admin/updateStatus/${accountList.accountNumber}'">Approve</button></td>
			</tr>
		</c:forEach>

	</table>
</div>

<div>
    	<h1 class="heading">Accounts Blocked</h1>
	<table class="account_approval_table">
		<tr>
			<th>customerId</th>
			<th>firstName</th>
			<th>lastName</th>
			<th>email</th>
			<th>phoneNumber</th>
			<th>loginAttempt</th>
			<th>Action</th>
			
		</tr>
		<c:forEach var="CustomerList" items="${cDetailsList}">
			<tr>
				<td>${CustomerList.customerId}</td>
				<td>${CustomerList.firstName}</td>
				<td>${CustomerList.lastName}</td>
				<td>${CustomerList.email}</td>
				<td>${CustomerList.phoneNumber}</td>
				<td>${CustomerList.loginAttempt}</td>
				
				<td><button onclick="document.location='/admin/updateLoginAttempts/${CustomerList.customerId}'">Unblock</button></td>
			</tr>
		</c:forEach>

	</table>
</div>
	<div>
	<h1 class="heading">Cheques to be Approved</h1>
	<table border=1>
		<tr>
			<th>ChequeNumber</th>
			<th>RecieverAccountNumber</th>
			<th>SenderAccountNumber</th>
			<th>ChequeDate</th>
			<th>Amount</th>
			<th>Status</th>
			<th>Action</th>
			
			
		</tr>
		<c:forEach var="chequeToApp" items="${chequeListToApp}">
			<tr>
				<td>${chequeToApp.chequeNumber}</td>
				<td>${chequeToApp.recieverAccount.accountNumber}</td>
				<td>${chequeToApp.senderAccount.accountNumber}</td>
				<td>${chequeToApp.chequeDate}</td>
				<td>${chequeToApp.amount}</td>
				<td>${chequeToApp.status}</td>
				
				
				<td><button onclick="document.location='/admin/updateStatusOfCheque/${chequeToApp.chequeNumber}'">Approve</button></td>
			</tr>
		</c:forEach>

	</table>
	
	
	</div>


</body>
</html>