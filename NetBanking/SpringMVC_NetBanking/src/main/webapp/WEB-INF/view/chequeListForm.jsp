<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ChequeList</title>
<link href="/css/main.css" rel="stylesheet">
<style type="text/css">

button{
    background-color: #eb4034;
    border: none;
    padding: 10px 15px 10px 15px;
    color: #ecdab5;
    font-weight: 800;
    font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
    border-radius: 10px;
    cursor:pointer

}
</style>


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

<h2 class="heading">All Cheques</h2>

<table border=1>
        <tr>
            <th>ChequeNo</th>
            
            <th>SenderAccountNumber</th>
            <th>ChequeDate</th>
            <th>Amount</th>
        
            <th>Action</th>
        </tr>
        <c:forEach var="chequeDetails" items="${receivedChecks}">
            <tr>
                <td>${chequeDetails.chequeNumber}</td>
                
                <td>${chequeDetails.senderAccount.accountNumber}</td>
                <td>${chequeDetails.chequeDate}</td>
                <td>${chequeDetails.amount}</td>
                
                <td><button onclick="document.location='/customer/bankslip/${chequeDetails.chequeNumber}'">Fill Bankslip</button></td>
                
            </tr>
        </c:forEach>

    </table>
    
    
    <h2 class="heading">Cleared Cheques</h2>
    
    
    <table border=1>
        <tr>
            <th>ChequeNo</th>
            
            <th>SenderAccountNumber</th>
            <th>ChequeDate</th>
            <th>Amount</th>
            <th>Status</th>
            
        </tr>
        <c:forEach var="chequeDetails" items="${ClearedCheqs}">
            <tr>
                <td>${chequeDetails.chequeNumber}</td>
                
                <td>${chequeDetails.senderAccount.getAccountNumber()}</td>
                <td>${chequeDetails.chequeDate}</td>
                <td>${chequeDetails.amount}</td>
                <td>${chequeDetails.status}</td>
                
            </tr>
        </c:forEach>

    </table>
    
    <h2 class="heading">Bounced Cheques</h2>
    
    
    <table border=1>
        <tr>
            <th>ChequeNo</th>
            
            <th>SenderAccountNumber</th>
            <th>ChequeDate</th>
            <th>Amount</th>
            <th>Status</th>
            <th>Action</th>
            
        </tr>
        <c:forEach var="chequeDetails" items="${bouncedCheqs}">
            <tr>
                <td>${chequeDetails.chequeNumber}</td>
                
                <td>${chequeDetails.senderAccount.getAccountNumber()}</td>
                <td>${chequeDetails.chequeDate}</td>
                <td>${chequeDetails.amount}</td>
                <td>${chequeDetails.status}</td>
                <td><button onclick="document.location='/customer/updateCheque/${chequeDetails.chequeNumber}'">Edit</button></td>
                
            </tr>
        </c:forEach>

    </table>

</body>
</html>