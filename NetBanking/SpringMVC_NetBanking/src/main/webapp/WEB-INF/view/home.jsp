<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<style>
* {
	padding: 0px;
	margin: 0px;
	box-sizing: border-box;
}

body {
	/* background-color: #b1b1b1; */
	font-family: Arial, sans-serif;
}

#banner_image {
	background: url(../images/banking_main_image.png);
	background-size: 500px;
	background-repeat: no-repeat;
	background-color: #172947;
	background-position: right 40px;
	height: 400px;
	border-bottom: 10px solid #409df5;
}

#banner_image_cover_div {
	height: 400px;
	padding-top: 10px;
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

.nav_link>a:hover {
	color: #eb4034;
}

.nav_link>a {
	text-decoration: none;
	color: white;
	font-size: 20px;
}

.popups {
	height: 100%;
	width: 100%;
	background-color: rgba(0, 0, 0, 0.9);
	position: fixed;
	left: 0;
	top: 0;
	display: none;
}

.msgdiv {
	/* width: 300px; */
	height: 400px;
	position: absolute;
	margin: auto;
	inset: 0;
	display: none;
}

.mgsdiv_button {
	background-color: #eb4034;
	border: none;
	height: 35px;
	width: 100px;
	border: none;
	border-radius: 15px;
	color: white;
	font-size: 18px;
	font-weight: bolder;
	display: block;
	margin: auto;
}

#message {
	color: green;
	margin: auto;
	text-align: center;
	font-size: 40px;
	margin-top: 5px;
	margin-bottom: 30px;
	color: white;
}

#successLogo {
	height: 200px;
	width: 200px;
	display: none;
	margin: auto;
}

#failLogo {
	display: none;
	margin: auto;
	height: 200px;
	width: 250px;
}

#banner_account_details {
	height: 250px;
	width: 500px;
	/* color:#172947;  */
	color: white;
	margin-top: 50px;
	margin-left: 100px;
	/* background-color:white; */
	background-color: rgba(0, 0, 0, 0.5);
	/* background-color:#4d6a99; */
	box-shadow: 5px 5px 5px black;
	padding: 20px;
	text-align: left;
	font-size: 35px;
	font-weight: bolder;
}

#banner_greetting {
	text-align: center;
	font-size: 45px;
}

#account_details {
	margin-top: 30px;
	display: inline-block;
	margin-left: 20px;
	font-size: 40px;
	float: left;
}

#banner_balance {
	float: left;
	font-size: 40px;
	margin-top: 30px;
	margin-left: 100px;
	text-align: center;
}

#View_balance_button {
	height: 30px;
	width: 150px;
	background-color: #eb4034;
	border: none;
	color: white;
	font-size: 20px;
	border-radius: 10px;
}

.balance {
	display: none;
}

.card {
	height: 100px;
	width: 300px;
	border-radius: 20px;
	background-color: rgba(254, 249, 105, 0.829);
	color: black;
	padding-top: 5px;
	padding-left: 20px;
	margin: 20px;
	box-shadow: 2px 2px 2px black;
	float: left;
	cursor: pointer;
}

.clear_div {
	clear: both;
}

.send_money_card {
	background-image: url(../images/send_money_logo.png);
	background-size: 170px;
	background-repeat: no-repeat;
	background-position: 120px -8px;
	background-color: #41fadb;
}

.card_text {
	font-weight: bold;
	font-size: 30px;
	padding: 10px;
	display: inline-block;
	text-align: center;
}

.card:hover {
	height: 105px;
	width: 305px;
	box-shadow: 5px 5px 5px black;
}

.my_transaction_card {
	background-image: url(../images/transaction_histroy_logo.png);
	background-size: 100px;
	background-repeat: no-repeat;
	background-position: 200px -5px;
	background-color: #59ff83;
}

.pay_bills_card {
	background-image: url(../images/bill_pay_logo.png);
	background-size: 110px 80px;
	background-repeat: no-repeat;
	background-position: 190px 5px;
	background-color: #9e73fa;
}

.my_fd_card {
	background-image: url(../images/fd_card_background.png);
	background-size: 260px;
	background-repeat: no-repeat;
	background-position: 90px -5px;
}

.send_cheque_logo
{
	background-image: url(../images/send_cheque.png);
	background-size: 140px;
	background-repeat: no-repeat;
	background-position: 140px -5px;

}

.create_new_fd_card {
	background-image: url(../images/create_new_fd_logo.png);
	background-size: 120px 100px;
	background-repeat: no-repeat;
	background-position: 175px -4px;
	background-color: #faa273;
}
.recived_cheque_logo
{
	background-image: url(../images/recived_cheque_logo.png);
	background-size: 120px 120px;
	background-repeat: no-repeat;
	background-position: 175px -8px;
	background-color: #faa273;
}

.create_new_account_card {
	background-image: url(../images/create_new_account_logo.png);
	background-size: 140px 90px;
	background-repeat: no-repeat;
	background-position: 155px 3px;
	background-color: #facb73;
}
.sent_cheque
{
	background-image: url(../images/sent_cheque.png);
	background-size: 140px 90px;
	background-repeat: no-repeat;
	background-position: 155px 3px;
	background-color: #facb73;
}

.heading {
	text-align: center;
	color: #172947;
	font-size: 35px;
	letter-spacing: 5px;
	font-weight: bolder;

}

.card_holder {
	margin: auto;
	width: fit-content;
	margin-top: 20px;
}
.card_select_button
{
	display: block;
	border:none;
	height: 30px;
	width:100px;
	text-align: center;
	font-size: 20px;
	font-weight: bolder;
	margin: auto;
	
}
.footer
{
	background-color: black;
	border:1px solid black;
	padding:5px;
	padding-left:35%;
}
#fotter_logo
{
	float: none;
	display: black;
	margin: auto;
}



</style>
<script type="text/javascript" src="../script/homeScript.js"></script>
</head>
<body>
	<div id="main_div">
		<div id="banner_image">
			<div id="banner_image_cover_div">
				<nav id="navbar">
					<div class="imagelogo">
						<img src="../images/banklogo.png" alt="bank logo"
							class="logoImage">
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

				<div id="banner_account_details">
					<p id="banner_greetting">Hey
						${customerDetailsKey.getFirstName()}....!</p>
					<div id="account_details">
						<p id="banner_accountType">${myAccountKey.getAccountType()}</p>
						<p id="banner_accountNumber">${myAccountKey.getAccountNumber()}</p>
					</div>
					<div id="banner_balance">
						<button onclick="showBalance()" id="View_balance_button">view
							balance</button>
						<div class="balance">&#x20B9;${myAccountKey.getBalance()}</div>
					</div>
					<div class="clear_div"></div>
				</div>

			</div>

		</div>
		<h1 id="mgsflag">${popUpMessage}</h1>

		<div class="card_div">
			<div class="card_holder">
				<h1 class="heading">Transactions</h1>
				<div class="card send_money_card"
					onclick="document.location='/customer/sendmoney'">
						<p class="card_text">
							Send <br>Money
						</p>
					</div>

				<div class="card my_transaction_card" onclick="document.location='/customer/allTransactions/${myAccountKey.getAccountNumber()}'">
					<p class="card_text">
						My <br>Transactions
					</p>
				</div>

				<div class="card pay_bills_card">
					<p class="card_text">
						Pay <br>Your Bills
					</p>
				</div>
				<div class="clear_div"></div>

			</div>

			<div class="card_holder">
				<h1 class="heading">Deposit</h1>
				<div class="card my_fd_card" onclick="document.location='/customer/showFD/${myAccountKey.getAccountNumber()}'">
					<p class="card_text">
						MY Fix <br>Deposit
					</p>
				</div>
				<div class="card create_new_fd_card" onclick="document.location='/customer/createNewFD'">
					<p class="card_text">
						New <br>Fix Deposit
					</p>
				</div>
				<div class="clear_div"></div>
			</div>

			<div class=card_holder>
				<h1 class="heading">Account</h1>
				<div class="card create_new_account_card" onclick="document.location='/customer/addaccount'">
					<p class="card_text">
						New <br>Account
					</p>
				</div>
				<div class="card">
					<p class="card_text">
						change Account:
					</p>
					<form action="/customer/changeaccount" >
						<select name="accountNumber"  onchange="this.form.submit()" class="card_select_button">
						<option>Account</option>
						<c:forEach var="getAccountNumber"
							items="${customerDetailsKey.getAccountList()}">
							<option>${getAccountNumber.accountNumber}</option>
						</c:forEach>
					
						</select>
					</form>
				</div>
				<div class="clear_div"></div>
			</div>
			
			
			
			<div class=card_holder>
				<h1 class="heading">Cheque</h1>
				<div class="card send_cheque_logo" onclick="document.location='/customer/chequeForm'">
					<p class="card_text">
						Send<br>Cheque
					</p>
				</div>
				
				
			
			
				<div class="card recived_cheque_logo" onclick="document.location='/customer/receivedCheque/${myAccountKey.getAccountNumber()}'">
					<p class="card_text">
						Received <br>Cheques
					</p>
				</div>
				
				<div class="card sent_cheque" onclick="document.location='/customer/sentCheque/${myAccountKey.getAccountNumber()}'">
					<p class="card_text">
						Sent <br>Cheques
					</p>
				</div>
				
				<div class="clear_div"></div>
			</div>

		</div>
		
	
	
	</div>
	<div class="popups">
		<div class="msgdiv">
			<img alt="logo" src="../images/successLogo.png" id="successLogo">
			<img alt="logo" src="../images/failLogo.png" id="failLogo">
			<h2 id="message"></h2>
			<button class="mgsdiv_button"
				onclick="closePopup();document.location='/customer/closemsg'">Close</button>
		</div>

	</div>
	<footer class="footer">
		<div class="imagelogo" id="fotter_logo">
						<img src="../images/banklogo.png" alt="bank logo"
							class="logoImage">
						<div class="logText">
							<p class="mgs">MGS BANKING</p>
						</div>
						<div class="clear_div"></div>
			</div>
			<div class="clear_div"></div>
	
	</footer>

	<script type="text/javascript">
	
		 
		var popUpWindow=document.getElementsByClassName("popups")[0];
		var msgDiv=document.getElementsByClassName(	"msgdiv")[0];
		var message=document.getElementById("message");
		var successLogoImg=document.getElementById(	"successLogo");
		var failLogImg=document.getElementById("failLogo");
		
		
		
		
		if(${displayMsg})
			{
			
				switch(document.getElementById("mgsflag").innerText)
				{
				case "transactionSuccess":
					successLogoImg.style.display="block";
					message.innerText="Transaction Successful...!";
					break;
					
				case "transactionFail":
					failLogImg.style.display="block";
					message.innerText="Transaction Failed...! "	;
					
					break;
				
				case "fdsuccess":
					successLogoImg.style.display="block"	;
					message.innerText="Fix Deposit Created Successfully ";	
					break;
				
				case "fdFail":
					failLogImg.style.display="block";
					message.innerText="Failed To Create FixDeposit...! Please Check Your Account Balance"	;
					
					break;
				
					
				}
				openPopUp();
			}
	
		function closePopup()
		{
			document.getElementById("failLogo").style.display="none";		
			document.getElementById("successLogo").style.display="none"	;
			popUpWindow.style.display="none";
			msgDiv.style.display="none";		 
		}
		
		function openPopUp()
		{
			popUpWindow.style.display="block";
			msgDiv.style.display="block" ;		
			
		}
		
		function showBalance()
		{
			document.getElementsByClassName("balance")[0].style.display="block";
		}
		

		
	
</script>


</body>



</html>