<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BankSlip form</title>
<link href="/css/main.css" rel="stylesheet">
<style>
   

   #formpage_content {
       border-radius: 10px;
       width: 700px;
       margin: auto;
       margin-bottom: 30px;
       background: white;
       padding: 20px;
       box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
       height: 391px;
       margin-top: 56px;
   }
   
   .register_form input[type="text"], .register_form input[type="password"],
       .register_form select {
       display: block;
       margin: 10px 0;
       width: calc(80% - 20px);
       height: 30px;
       font-size: 15px;
       border: none;
       background-color: #c9c8c7;
       border-radius: 10px;
       padding: 0 10px;
       margin-left: 6px;
   }
   
   .register_form label {
       display: block;
       margin-left: 10px;
       font-size: 20px;
       font-weight: bold;
       color: #2753f2;
       margin-top: 15px;
   }
   
   .form_Section {
       width: 100%;
       margin-top: 20px;
       margin-left: 74px;
   }
   
   #selector {
       width: calc(80% - 20px);
       margin-left: 1%;
       height: 30px;
       font-size: 15px;
       border: none;
       background-color: #c9c8c7;
       border-radius: 10px;
       padding: 0 10px;
   }
   
   .form_button {
       margin-right: 20px;
       width: 150px;
       height: 30px;
       border: none;
       border-radius: 10px;
       cursor: pointer;
       font-size: 16px;
       font-weight: bold;
       text-transform: uppercase;
   }
   
   .register_button {
       background-color: #eb4034;
       color: white;
       margin-top: 15px;
       margin-left: 37%;
   }
   
   .reset_button {
       background-color: #0687a1;
       color: white;
   }
 
   
   #radio_lable_option {
       display: inline;
       width: 100px;
       margin: 0;
       color: black;
       margin-left: 10px;
   }
   
   #registerpage_heading {
       text-align: center;
   }
   #container {
       width: 100%;
       overflow: hidden; /* Clearfix to contain floated elements */
   }
   
   .inline-block-container {
       width: 45%; /* Adjust width as needed */
       float: left; /* Float the containers to achieve side-by-side layout */
       margin-right: 10px; /* Add margin between the containers */
       margin-bottom: 10px; /* Optional: Add margin bottom for spacing */
   }
   
   .inline-block-container label {
       display: block; /* Ensure labels are displayed as blocks */
       font-weight: bold; /* Example styling for labels */
       margin-bottom: 5px; /* Optional: Add bottom margin for spacing */
   }
   
   .inline-block-container div {
       width: calc(100% - 100px);
       height: 30px;
       border: 1px solid #ccc;
       padding: 5px;
       box-sizing: border-box;
       text-align: center;
       font-weight: 700;
       background: #c9c8c7;
       border-radius: 10px;
   }
   </style>
   
</head>
<body>
<div id="main_div">
    <nav class="nav_bar">
        <div class="imagelogo">
            <img src="../../images/banklogo.png" alt="bank logo" class="logoImage">
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
   
    
    <div id="formpage_content">
        <h1 id="registerpage_heading">BankSlip</h1>
        <form action="/customer/savebankslip" class="register_form" method="post">
            <div class="form_Section">
               
                
                <label for="AccountNumber">Receiver Account:</label>
                <input type="text" name="recieverAccountNumber" id="recieverAccountNmber" value="${cheque.recieverAccount.accountNumber}" class="inputFiled">
                
                <label for="Amount">Amount:</label>
                <input type="text" name="Amount" id="Amount" class="inputFiled" value="${cheque.amount}" placeholder="Enter Your Amount">
            </div>
            <div class="clear_div"></div>
            <div id="form_buttons_div">
                <input type="submit" value="Deposit" class="form_button register_button">
            </div>
        </form>
    </div>
</div>
</body>
</html>