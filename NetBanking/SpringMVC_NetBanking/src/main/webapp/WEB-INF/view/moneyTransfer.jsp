<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SendMoney</title>
<style type="text/css">
	
    
    
    /* Styling for the form container */
    form {
        max-width: 541px;
        margin: 53px auto;
        background: white;
        border-radius: 10px;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
        text-align: center; /* Center align all text within the form */
    }
    
    /* Styling for form labels */
    label {
        display: block;
        margin: 10px auto; /* Center align labels horizontally */
        font-size: 20px;
        font-weight: bold;
        color: #2753f2;
        text-align: left; /* Align label text to the left */
        width: 80%; /* Set width to match input width */
    }
    
    /* Styling for form inputs */
    input[type='text'], input[type='password'], input[type='radio'], input[type='submit'] {
        display: block;
        width: 80%; /* Adjust input width as needed */
        margin: 5px auto; /* Center align inputs horizontally */
        height: 30px;
        font-size: 15px;
        border: none;
        background-color: #c9c8c7;
        border-radius: 10px;
        text-indent: 10px;
    }
    
    input[type='submit'] {
   display: block;
    width: 16%;
    margin: 0px auto;
    height: 30px;
    font-size: 15px;
    border: none;
    background-color: #c9c8c7;
    border-radius: 15px;
    text-indent: 10px;
    background: #eb4034;
    margin-top: 18px;
    text-align: center;
    margin-left: 38.5%;
}
    
    /* Additional styles for radio buttons */
    input[type='radio'] {
        display: inline;
        border: 1px solid red; /* Corrected typo in 'solid' */
        height: 15px;
        width: 15px;
        margin-right: 5px; /* Added margin-right for spacing */
    }
    
    /* Styling for buttons */
    .form_button {
        margin-right: 20px;
        width: 150px;
        height: 30px;
        border: none;
        border-radius: 10px;
        color: white;
        font-weight: bold;
    }
    
    .sendmoney_button {
        background-color: #eb4034;
    }
    
   
    /* Styling for navigation bar */

    
   
    
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
			<li class="nav_link"><a href="/customer/home">Home</a></li>
			<li class="nav_link"><a href="/customer/profile">Profile</a></li>
			<li class="nav_link"><a href="#about">About</a></li>
			<li class="nav_link"><a href="/customer/logout">LogOut</a></li>
			<div class="clear_div"></div>
		</ul>

		<div class="clear_div"></div>


	</nav>
	  <form action="/customer/tranfermoney" method="post">
        <h1 id="sendmoney_heading">Send Money Application</h1>
        
        <label for="senderAccountNumber">Sender Account Number:</label>
        <input type="text" name="senderAccountNumber" value="${myAccountKey.getAccountNumber()}" readonly="readonly">
        
        <label for="receiverAccountNumber">Receiver Account Number:</label>
        <input type="text" name="receiverAccountNumber">
        
        
        <label for="amount">Amount:</label>
        <input type="text" name="amount">

      

        <input type="submit" value="Send" class="form_button sendmoney_button">
    </form>

</body>


    
</body>
</html>