<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link href="/css/main.css" rel="stylesheet">
<style type="text/css">

#formpage_content {
	border-radius: 10px;
	width: 700px;
	margin: auto;
	margin-bottom: 30px;
	background: white;
	padding: 20px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	height: 445px;
	margin-top: 56px;
}

.register_form input[type="number"], .register_form input[type="password"],
	.register_form select,.register_form input[type="text"],.register_form input[type="date"]{
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
	margin-left: 17%;
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




</style>

</head>
<body>
	<!-- <div class="main_image_div"> -->
	<div id="main_div">
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
		<div class="clear_div"></div>
		
		<div id="formpage_content">

			<h1 id="registerpage_heading">New Cheque</h1>
			<form action="insert" method="post" class="register_form">
                <div class="form_Section">
                    <label for="recieverAccountNumber">Reciever Account Number:</label>

                    <input type="text" name=recieverAccountNumber
                        id="recieverAccountNumber" class="inputFiled"
                        placeholder="Enter Account Number">
                    <c:if test='${statusFor}'>
                        <p id="error_message">'${messageError}'</p>

                    </c:if>

                    <label for="senderAccountNumber">Sender Account Number:</label>
                    <!--  Last Name: -->

                    <input type="number" name="senderAccountNumber" id="senderAccountNumber" class="inputFiled" placeholder="Enter Account Number"
                        value="${myAccountKey.getAccountNumber()}" readonly="readonly">

                    <!-- <label for="chequeDate">Cheque Date:</label> <input type="date"
                        name="chequeDate" id="chequeDate" class="inputFiled">  -->
                    <label for="chequeDate">Cheque Date:</label> 
                    <input type="date" name="chequeDate" id="chequeDate" class="inputFiled">
                         <label for="amount">Amount:</label>
                         <input type="text" name="amount"
                        id="amount" class="inputFiled">


                    <div id="form_buttons_div">
                        <button type="submit" value="Submit Cheque"
                            class="form_button register_button">Submit Cheque</button>
                        <button type="reset" value="reset"
                            class="form_button reset_button">Reset</button>

                    </div>
                </div>

            </form>
		</div>
	</div>
	<!-- </div> -->
	<footer ></footer>

</body>
</html>