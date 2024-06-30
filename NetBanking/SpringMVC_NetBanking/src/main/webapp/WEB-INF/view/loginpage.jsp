<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoginPage</title>
<link href="../css/main.css" rel="stylesheet">
<style>
* {
	margin: 0px;
	padding: 0px;
	box-sizing: border-box;
}


#main_div {
	
	width: 100vw;
	height: 100vh;
	/* background-color: rgba(13, 13, 13,0.7); */
	position: relative;
}

#loginpage_content {
	height: 400px;
	width: 400px;
	border-radius: 10px;
	text-align: center;
	/* background: #095f98; */
	background: white;
	box-shadow: 10px 10px 10px 5px rgb(52, 50, 50);
	position: absolute;
	inset: 0px;
	margin: auto;
	color: #03AED2;
	
}

#loginpage_content>form>label {
	color: black;
	display: block;
	text-align: left;
	margin-left: 55px;
	margin-bottom: 5px;
	margin-top: 10px;
	font-size: 24px;
	font-weight: bolder;
	/* color:white; */
	color: #0687a1;
}

#loginpage_content>h1 {
	font-size: 55px;
	margin-bottom: 30px;
	color: black
}

.inputFiled {
	display: block;
	height: 30px;
	width: 300px;
	margin: auto;
	border: none;
	border-radius: 5px;
	background-color: #c7babafb;
	text-indent: 5px;
}

.button {
	font-size: 18px;
	font-weight: bolder;
	padding: 5px;
	border-radius: 6px;
	border: none;
	display: block;
	background-color: #eb4034;
	
	height: 30px;
	width: 300px;
	margin-top: 15px;
	color: white;
}

#loginpage_content>#register {
	background-color: #00e1e7;
}

#reset_button {
	background-color: #0687a1;
}

#registerLink {
	/* color:white; */
	color: #03AED2;
	font-weight: bolder;
}


</style>
</head>
<body>

	<div id="main_div">
		<nav class="nav_bar">
			<div class="imagelogo">
			<img src="../images/banklogo.png" alt="bank logo" class="logoImage">
			<div class="logText">
				<p class="mgs">MGS BANKING</p>

			</div>
			<div class="clear_div"></div>
		</div>
		<div class="clear_div"></div>
		</nav>
		<div id="loginpage_content">
			<h1>Login</h1>
			<form action="/customer/login" method="post">
				<label for="loginid">Login Id:</label> <input type="text"
					name="loginId" id="loginid" class="inputFiled"
					placeholder="Loginid"> <label for="password">Password:</label>

				<input type="password" name="password" id="password" class="inputFiled"
					placeholder="Password">
			 	<c:if test="${isfaild}"> 
					 <p id="error_message">${message}</p>					

				</c:if> 

				<input type="submit" value="Login" class="button inputFiled">
				<input type="reset" value="Reset" id="reset_button"
					class="button inputFiled">
			</form>
			<br>

			<p>
				if not registered Please <a href="registerpage">Register</a>
			</p>



		</div>
	</div>
	
</body>

	



</html>